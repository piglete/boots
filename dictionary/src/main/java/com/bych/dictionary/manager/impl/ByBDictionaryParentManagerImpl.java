package com.bych.dictionary.manager.impl;

import com.bych.dictionary.manager.ByBDictionaryChildManager;
import com.bych.dictionary.manager.ByBDictionaryParentManager;
import com.bych.dictionary.mapper.ByBDictionaryParentMapper;
import com.bych.dictionary.model.ByBDictionaryChild;
import com.bych.dictionary.model.ByBDictionaryParent;
import club.map.base.redis.RedisKey;
import club.map.base.redis.SystemPropertiesConfig;
import club.map.base.util.AppTreeUtil;
import club.map.core.manager.impl.GenericManagerImpl;
import club.map.core.model.FlipFilter;
import club.map.core.model.Operate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class ByBDictionaryParentManagerImpl extends GenericManagerImpl<ByBDictionaryParent, Integer> implements ByBDictionaryParentManager {

    private ByBDictionaryChildManager byBDictionaryChildManager;
    private ByBDictionaryParentMapper byBDictionaryParentMapper;

    @Autowired
    public ByBDictionaryParentManagerImpl(ByBDictionaryParentMapper mapper,
                                          ByBDictionaryChildManager byBDictionaryChildManager,
                                          ByBDictionaryParentMapper byBDictionaryParentMapper
    ) {
        super(mapper, ByBDictionaryParent.class);
        this.byBDictionaryChildManager = byBDictionaryChildManager;
        this.byBDictionaryParentMapper = byBDictionaryParentMapper;
    }

    @Override
    public List treeDataForParent() {
        FlipFilter flipFilter = new FlipFilter(ByBDictionaryParent.class);
        List dictionaryParentList = this.list(flipFilter);
        List treeData = AppTreeUtil.getTreeData(dictionaryParentList);
        return treeData;
    }

    @Transactional
    @Override
    public void upperSave(ByBDictionaryParent byBDictionaryParent) {
        String code = byBDictionaryParent.getCode();
        if (byBDictionaryParent.getId() == null) {
            if (byBDictionaryParent.getParentId() != null) {
                String maxCode = byBDictionaryParentMapper.queryMaxCodeByParentId(code + "%", byBDictionaryParent.getParentId());
                if (maxCode != null) {
                    BigInteger bigInteger = new BigInteger(maxCode);
                    BigInteger result = bigInteger.add(BigInteger.valueOf(1));
                    byBDictionaryParent.setCode(result + "");
                } else {
                    byBDictionaryParent.setCode(code + "100");
                }
            } else {
                byBDictionaryParent.setCode("100");
            }
        }
        this.save(byBDictionaryParent);
    }

    @Transactional
    @Override
    public void removeById(Integer id) {
        ByBDictionaryParent byBDictionaryParent = this.get(id);
        String code = byBDictionaryParent.getCode();
        FlipFilter flipFilter = new FlipFilter(ByBDictionaryParent.class);
        flipFilter.addSearch(code + "%", Operate.LIKE, "code");
        List<ByBDictionaryParent> byBDictionaryParentList = this.list(flipFilter);
        if (byBDictionaryParentList.size() > 0) {
            for (ByBDictionaryParent bDictionaryParent : byBDictionaryParentList) {
                this.remove(bDictionaryParent.getId());
            }
        }
        FlipFilter flipFilterChild = new FlipFilter(ByBDictionaryChild.class);
        flipFilterChild.addSearch(code + "%", Operate.LIKE, "dictionaryCode");
        List<ByBDictionaryChild> byBDictionaryChildList = byBDictionaryChildManager.list(flipFilterChild);
        if (byBDictionaryChildList.size() > 0) {
            for (ByBDictionaryChild byBDictionaryChild : byBDictionaryChildList) {
                Integer childId = byBDictionaryChild.getId();
                byBDictionaryChildManager.remove(childId);
            }
        }
    }
}