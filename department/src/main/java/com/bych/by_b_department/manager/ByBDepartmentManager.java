package com.bych.by_b_department.manager;

import com.bych.by_b_department.model.ByBDepartment;
import club.map.core.manager.GenericManager;

import java.util.List;

public interface ByBDepartmentManager extends GenericManager<ByBDepartment, Integer> {

    void upperSave(ByBDepartment byBDepartment);

    void removeByIds(String ids);

    List treeSearch();

    List<ByBDepartment> search();

    List<ByBDepartment> searchForChild(Integer invalidFlag);

    List<ByBDepartment> searchForParent(Integer releaseFlag, String departmentCode, Integer invalidFlag);

    List<ByBDepartment> searchForGroup(String code, Integer invalidFlag);

    List<ByBDepartment> searchForAllGroup(Integer releaseFlag, Integer invalidFlag);

    void updateDepartmentInvalid(Integer id);
}