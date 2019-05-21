package com.bych.t_c_command.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import com.bych.t_c_command.manager.TCCommandManager;
import com.bych.t_c_command.mapper.TCCommandMapper;
import com.bych.t_c_command.model.VCCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TCCommandManagerImpl extends GenericManagerImpl<VCCommand, Integer> implements TCCommandManager {

    @Autowired
    public TCCommandMapper tcCommandMapper;
    @Autowired
    public TCCommandManagerImpl(TCCommandMapper mapper) {
        super(mapper, VCCommand.class);
    }

    @Override
    public List<VCCommand> search(String sn, String deviceName,Integer deviceSta,Integer exeSta) {
        return tcCommandMapper.search(sn,deviceName,deviceSta,exeSta);
    }
}