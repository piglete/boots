package com.bych.auth_permission.manager;

import com.bych.auth_permission.model.BySMenu;
import club.map.core.manager.GenericManager;
import club.map.core.model.Page;

import java.util.List;

public interface BySMenuManager extends GenericManager<BySMenu, Integer> {
    List treeData();

    void upperSave(BySMenu bySMenu);

    Page search(String menuName, Integer pageNo, Integer pageSize);

    void removeByIds(String ids);

    List<BySMenu> searchAllMenu();

    List<BySMenu> detailForRoleMenu(Integer id);
}