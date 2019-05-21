package com.bych.config;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.util.Map;

/**
 * 将Map的key全部转换为小写
 * */
public class MapKeyLowerWrapper extends MapWrapper {

    public MapKeyLowerWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject, map);
    }
    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return name==null?"":name.toLowerCase() ;
    }
}