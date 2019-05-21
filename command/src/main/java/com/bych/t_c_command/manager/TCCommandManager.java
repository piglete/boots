package com.bych.t_c_command.manager;

import club.map.core.manager.GenericManager;
import com.bych.t_c_command.model.VCCommand;

import java.util.List;

public interface TCCommandManager extends GenericManager<VCCommand, Integer> {
    List<VCCommand> search(String sn, String deviceName,Integer deviceSta,Integer exeSta);
}