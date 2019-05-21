package com.bych.auth_permission.manager;

import com.bych.auth_permission.model.BySRole;
import club.map.core.manager.GenericManager;
import club.map.core.model.Page;

import java.util.List;

public interface BySRoleManager extends GenericManager<BySRole, Integer> {
    Page search(String roleName, Integer roleType, Integer pageNo, Integer pageSize);

    void upperSave(BySRole bySRole);

    List<BySRole> searchWithOutPage(String roleName);

    Boolean removeForRole(Integer id);

    void upperSaveMenu(Integer id, String menuIds);
}