package com.bych.auth_permission.manager.impl;

import com.bych.auth_permission.manager.BySRoleMenuManager;
import com.bych.auth_permission.mapper.BySRoleMenuMapper;
import com.bych.auth_permission.model.BySRoleMenu;
import club.map.core.manager.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BySRoleMenuManagerImpl extends GenericManagerImpl<BySRoleMenu, Integer> implements BySRoleMenuManager {

    @Autowired
    public BySRoleMenuManagerImpl(BySRoleMenuMapper mapper) {
        super(mapper, BySRoleMenu.class);
    }

    @Transactional
    @Override
    public void upperSave(BySRoleMenu bySRoleMenu) {
        this.save(bySRoleMenu);
    }
}