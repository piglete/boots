package com.bych.auth_permission.manager;

import com.bych.auth_permission.model.BySRoleMenu;
import club.map.core.manager.GenericManager;

public interface BySRoleMenuManager extends GenericManager<BySRoleMenu, Integer> {
    void upperSave(BySRoleMenu bySRoleMenu);
}