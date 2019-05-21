package com.bych.dictionary.manager;

import com.bych.dictionary.model.ByBDictionaryChild;
import club.map.core.manager.GenericManager;
import club.map.core.model.Page;

import java.util.List;

public interface ByBDictionaryChildManager extends GenericManager<ByBDictionaryChild, Integer> {
    List<ByBDictionaryChild> searchByDictionaryCode(String dictionaryCode);

    void upperSave(ByBDictionaryChild byBDictionaryChild);

    void removeByIds(String ids);

    Page searchChild(String alias, String dictionaryCode,Integer pageNo, Integer pageSize);

    List<ByBDictionaryChild> searchByParentAlias(String alias);

    /**
     * 查询年份
     * 过滤:在查询到的字典表的年份类型中过滤掉大于当前时间年份的值
     * @param dictionaryCode
     * @return
     */
    List<ByBDictionaryChild> searchLessNowYearByDictionaryCode(String dictionaryCode);
}