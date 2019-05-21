package com.bych.dictionary.manager;

import com.bych.dictionary.model.ByBDictionaryParent;
import club.map.core.manager.GenericManager;

import java.util.List;

public interface ByBDictionaryParentManager extends GenericManager<ByBDictionaryParent, Integer> {
    List treeDataForParent();

    void upperSave(ByBDictionaryParent byBDictionaryParent);

    void removeById(Integer id);
}