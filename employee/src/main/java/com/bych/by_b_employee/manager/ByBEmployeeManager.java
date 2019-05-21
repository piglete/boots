package com.bych.by_b_employee.manager;

import com.bych.by_b_employee.model.ByBEmployee;
import club.map.core.manager.GenericManager;
import club.map.core.model.Page;

import java.util.List;

public interface ByBEmployeeManager extends GenericManager<ByBEmployee, Integer> {
    Page search(String username, String telephone, String sex, String pinyin, String positionState, String departmentCode, String isLeader, Integer pageNo, Integer pageSize);

    void removeByIds(String ids);

    void upperSave(ByBEmployee byBEmployee);

    ByBEmployee searchDetails(Integer id);

    void updateByIdForPositionState(Integer id, String positionState);

    void updateByIdForIcon(Integer id, String icon);

    List<ByBEmployee> searchForUsername(String departmentCode);

    List<ByBEmployee> searchForLeader();

    ByBEmployee searchDepartmentLeader(String departmentCode, String positionState, String isLeader);

    String searchByCode(String code);

    ByBEmployee searchIdAndNameByCode(String code);

    ByBEmployee searchUsernameAndDepartmentNameById(Integer messageCreateId);

    List<ByBEmployee> searchWithoutPage(String username, String telephone, String sex, String pinyin, String positionState, String departmentCode, String isLeader);
}