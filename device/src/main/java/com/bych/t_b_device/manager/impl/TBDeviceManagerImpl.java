package com.bych.t_b_device.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import club.map.core.model.FlipFilter;
import club.map.core.model.Operate;
import club.map.core.model.Page;
import com.bych.by_b_region.mapper.ByBRegionMapper;
import com.bych.by_b_region.model.ByBRegion;
import com.bych.t_b_device.manager.TBDeviceManager;
import com.bych.t_b_device.mapper.TBDeviceMapper;
import com.bych.t_b_device.model.TBDevice;
import com.wanqing.util.StringHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class TBDeviceManagerImpl extends GenericManagerImpl<TBDevice, Integer> implements TBDeviceManager {

    private TBDeviceMapper tbDeviceMapper;
    private ByBRegionMapper byBRegionMapper;
    @Autowired
    public TBDeviceManagerImpl(TBDeviceMapper mapper,
                               TBDeviceMapper tbDeviceMapper,
                               ByBRegionMapper byBRegionMapper) {
        super(mapper, TBDevice.class);
        this.tbDeviceMapper=tbDeviceMapper;
        this.byBRegionMapper=byBRegionMapper;
    }


    @Override
    public int upperSave(TBDevice tbDevice) {
        int a = 0;
        if (tbDevice.getId() == null) {
            String deviceName = tbDevice.getName();
            //判断该用户名是否已存在
            Boolean flag = this.searchDeviceNameExist(deviceName);
            if (flag == true) {
                a = 1;
                return a;
            }
        }
        this.save(tbDevice);
        return a;
    }
    /**
     * 唯一性查询
     *
     * @param deviceName
     * @return
     */
    private Boolean searchDeviceNameExist(String deviceName) {
        Boolean flag = false;
        FlipFilter flipFilter = new FlipFilter(TBDevice.class);
        flipFilter.addSearch(deviceName, Operate.EQUAL, "name");
        List<TBDevice> bySUserInformationList = this.list(flipFilter);
        if (bySUserInformationList.size() > 0) {
            flag = true;
        }
        return flag;
    }
    @Override
    public Page search(String name, String telecomNumber,String cardNumber,String deviceType,String regionCode,Integer pageNo, Integer pageSize,String startTime,String endTime) {
        FlipFilter flipFilter = new FlipFilter(TBDevice.class);
        flipFilter.addSearch("%" + name + "%", Operate.LIKE, "name");
        flipFilter.addSearch("%" + telecomNumber + "%", Operate.LIKE, "telecomNumber");
        flipFilter.addSearch("%" + cardNumber + "%", Operate.LIKE, "cardNumber");
        flipFilter.addSearch(deviceType, Operate.EQUAL, "deviceType");
        flipFilter.addSearch("%" + regionCode + "%", Operate.LIKE, "regionCode");
            if (!"".equals(startTime) && !"".equals(endTime)) {
            flipFilter.addRegion("installTime", startTime, endTime);
        }
        Page page = null;
        flipFilter.updatePageNo(pageNo);
        flipFilter.setPageSize(pageSize);
        page = this.flipUsingInPage(flipFilter);
        List<TBDevice> tbDeviceList=page.getListInfo();
        for (TBDevice tbDevice:tbDeviceList) {
            this.searchInfo(tbDevice);
        }
        return page;
    }

    @Override
    public List<TBDevice> getAll(String name, String telecomNumber, String cardNumber,String regionCode, String deviceType, String executionStatus, String startTime, String endTime) {
        List<TBDevice> tbDeviceList=tbDeviceMapper.getAll(name,telecomNumber,cardNumber,regionCode,deviceType,executionStatus,startTime,endTime);

        return  tbDeviceList;
    }

    /**
     * 依赖注入(项目表依赖的其他表主键,根据id,获取对应名称注入)
     *
     * @param tbDevice
     */
    private void searchInfo(TBDevice tbDevice) {

        //获取区域名称和全称
        String regionCode = tbDevice.getRegionCode();
        if (StringHandler.isNotEmptyOrNull(regionCode)) {
            ByBRegion byBRegion = byBRegionMapper.searchByCode(regionCode);
            tbDevice.setRegionName(byBRegion.getName());
            tbDevice.setRegionAlias(byBRegion.getAlias());
        } else {
            tbDevice.setRegionName("");
            tbDevice.setRegionAlias("");
        }
    }
    @Transactional
    @Override
    public void removeByIds(String ids) {
        String[] idArr = ids.split(",");
        Arrays.asList(idArr).forEach(id -> {
            this.remove(Integer.valueOf(id));
        });
    }

    @Override
    public TBDevice getByTeleCode(String telCode) {
        ;
        return tbDeviceMapper.getByTeleCode(telCode);
    }

    @Override
    public TBDevice searchDetails(Integer id) {
        TBDevice tbDevice = this.get(id);

        return tbDevice;
    }

    @Override
    public TBDevice searchDetailsWithStatus(Integer id) {
        return null;
    }
}