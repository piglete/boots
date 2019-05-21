package com.bych.service;

import com.bych.by_b_region.manager.ByBRegionManager;
import com.bych.by_b_region.model.ByBRegion;
import com.bych.by_s_user_information.manager.BySUserInformationManager;
import com.bych.t_b_device.manager.TBDeviceManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author: lxl
 * @CreateDate: 2019/05/15
 * @Version: v1.0
 */
@Component
public class ImportDataImpl implements ImportData{

    @Autowired
    private ByBRegionManager byBRegionManager;
    @Autowired
    private BySUserInformationManager bySUserInformationManager;
    @Autowired
    private TBDeviceManager tbDeviceManager;

    static{

    }

    @Transactional
    @Override
    public void importFromExcel(String filePath,Integer type) {
        //String filePath = "E:\\123.xlsx";

        //判断是否为excel类型文件
        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx"))
        {
            System.out.println("文件不是excel类型");
        }

        FileInputStream fis =null;
        Workbook wookbook = null;

        try
        {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿

        }
        catch (Exception ex)
        {
            //ex.printStackTrace();
            try
            {
                //2007版本的excel，用.xlsx结尾

                wookbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //得到一个工作表
        Sheet sheet = wookbook.getSheetAt(0);

//        //获得表头
//        Row rowHead = sheet.getRow(0);
//
//        //判断表头是否正确
//        if(rowHead.getPhysicalNumberOfCells() != 3)
//        {
//            System.out.println("表头的数量不对!");
//        }

        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        switch (type){

            case 1:
//                //要获得属性
//                String id = "";
//                String sn = "";
//                String name = "";
//                String pressure = "";
//                String time = "";
//                String address = "";
//                TBDevice tbDevice=null;
//                TSPressure tsPressure=null;
//                //获得所有数据
//                for(int i = 1 ; i <= totalRowNum ; i++)
//                {
//                    tsPressure=new TSPressure();
//
//                    try {
//                        //获得第i行对象
//                        Row row = sheet.getRow(i);
//
//                        //获得获得第i行第0列的 String类型对象
//                        //设备编号
//                        Cell cell = row.getCell((short)0);
//                        id = cell.getStringCellValue().toString();
//                        //压力值
//                        cell = row.getCell((short)3);
//                        pressure = cell.getStringCellValue();
//                        if (!StringUtil.isNull(pressure)) {
//                            tsPressure.setPressVal(Double.parseDouble(pressure));
//                        }
//                        //采集时间
//                        cell = row.getCell((short)4);
//                        time=cell.getStringCellValue();
//                        if (!StringUtil.isNull(time)) {
//                            Date obsertime=FormatUtils.formatDateTime(time);
//                            tsPressure.setObserveTime(obsertime);
//                        }
//                        tbDevice=tbDeviceManager.getByTeleCode(id);
//                        if (tbDevice == null) {
//                            System.out.println("插入第"+i+"条没有设备信息");
//                            tbDevice=new TBDevice();
//                            tbDevice.setTelecomNumber(id);
//
//                            //设备编号
//                            cell = row.getCell((short)1);
//                            sn = cell.getStringCellValue();
//                            tbDevice.setSn(sn);
//                            //名称
//                            cell = row.getCell((short)2);
//                            name = cell.getStringCellValue();
//                            tbDevice.setName(name);
//                            //地址
//                            cell = row.getCell((short)5);
//                            address = cell.getStringCellValue();
//                            tbDevice.setAddress(address);
//                            tbDeviceManager.save(tbDevice);
//                        }
//                        tsPressure.setEquId(tbDevice.getId());
//                        tsPressureManager.save(tsPressure);
//                        System.out.println("插入第"+i+"条");
//                    }catch (Exception EX){
//                        System.out.println("插入第"+i+"条shibai");
//                    }
//
//
//                }
//                break;
          case 2:
                //要获得属性
                String code = "";
                String regionname = "";
                String alais = "";

                ByBRegion byBRegion=null;
                //获得所有数据
                for(int i = 1 ; i <= totalRowNum ; i++)
                {
                    byBRegion=new ByBRegion();

//                    //获得第i行对象
//                    Row row = sheet.getRow(i);
//                    //获得获得第i行第0列的 String类型对象
//                    //1
//                    Cell cell = row.getCell((short)0);
//                    code = cell.getStringCellValue();
//                    byBRegion.setCode(code);
//                    //2
//                    cell = row.getCell((short)1);
//                    regionname = cell.getStringCellValue();
//                    byBRegion.setName(regionname);
//                    //名称
//                    cell = row.getCell((short)2);
//                    alais = cell.getStringCellValue();
//                    byBRegion.setAlias(alais);
//
//                    byBRegionManager.save(byBRegion);
//                    System.out.println("插入区域第"+i+"条");

                }
              break;
            case 3:
             /*   //要获得属性
                String dianya = "";
                String remain = "";
                String xinhao = "";
                String battery_sta = "";
                String battery_remain = "";
                String device_sta="";
                String wireless = "";
                String posion_sta = "";
                String alarm_sta = "";
                String caverage = "";
                String noise_ratio = "";
                String temp = "";
                String ex_dianya = "";
                String ex_yali = "";
                String ex_heart = "";
                String ex_battery = "";
                TSDeviceStatus tsDeviceStatus =null;
                //获得所有数据
                for(int i = 1 ; i <= totalRowNum ; i++)
                {
                    tsDeviceStatus=new TSDeviceStatus();

                    try {
                        //获得第i行对象
                        Row row = sheet.getRow(i);
                        //获得获得第i行第0列的 String类型对象
                        //1
                        Cell cell = row.getCell((short) 0);
                        code = cell.getStringCellValue();
                        tbDevice = tbDeviceManager.getByTeleCode(code);
                        if (tbDevice == null) {
                            tbDevice = new TBDevice();
                            tbDevice.setTelecomNumber(code);
                            tbDeviceManager.save(tbDevice);
                            tsDeviceStatus.setEquId(tbDevice.getId());
                        } else {
                            tsDeviceStatus.setEquId(tbDevice.getId());
                        }
                        //电压
                        cell = row.getCell((short) 1);
                        dianya = cell.getStringCellValue();
                        tsDeviceStatus.setSupplyVoltage(Double.parseDouble(dianya));
                        //电池剩余
                        cell = row.getCell((short) 2);
                        battery_remain = cell.getStringCellValue();
                        tsDeviceStatus.setRemained(Double.parseDouble(battery_remain));
                        //信号强度
                        cell = row.getCell((short) 3);
                        xinhao = cell.getStringCellValue();
                        tsDeviceStatus.setSingalStrength(Double.parseDouble(xinhao));
                        //电池状态
                        cell = row.getCell((short) 4);
                        battery_sta = cell.getStringCellValue();
                        tsDeviceStatus.setBatterySta(Integer.parseInt(battery_sta));
//                    //设备状态
//                    cell = row.getCell((short)5);
//                    device_sta = cell.getStringCellValue();
//                    tsDeviceStatus.setDeviceSta(Integer.parseInt(device_sta));
                        //无线模块
                        cell = row.getCell((short) 6);
                        wireless = cell.getStringCellValue();
                        tsDeviceStatus.setWirelessSta(Integer.parseInt(wireless));
                        //布放
                        cell = row.getCell((short) 7);
                        posion_sta = cell.getStringCellValue();
                        tsDeviceStatus.setLayoutSta(Integer.parseInt(posion_sta));
                        //报警
                        cell = row.getCell((short) 8);
                        alarm_sta = cell.getStringCellValue();
                        tsDeviceStatus.setAlarmSta(Integer.parseInt(alarm_sta));
                        //信号覆盖
                        cell = row.getCell((short) 9);
                        caverage = cell.getStringCellValue();
                        tsDeviceStatus.setCoverage(Integer.parseInt(caverage));
                        //信噪比
                        cell = row.getCell((short) 10);
                        noise_ratio = cell.getStringCellValue();
                        tsDeviceStatus.setNoiseRatio(Integer.parseInt(noise_ratio));
                        //温度
                        cell = row.getCell((short) 11);
                        temp = cell.getStringCellValue();
                        tsDeviceStatus.setTemperature(Integer.parseInt(temp));
                        //电压异常
                        cell = row.getCell((short) 12);
                        ex_dianya = cell.getStringCellValue();
                        tsDeviceStatus.setAbnormalVoltage(Integer.parseInt(ex_dianya));
                        //压力异常
                        cell = row.getCell((short) 13);
                        ex_yali = cell.getStringCellValue();
                        tsDeviceStatus.setAbnormalPress(Integer.parseInt(ex_yali));
                        //心跳异常
                        cell = row.getCell((short) 14);
                        ex_heart = cell.getStringCellValue();
                        tsDeviceStatus.setAbnormalHeart(Integer.parseInt(ex_heart));
                        //电池异常
                        cell = row.getCell((short) 15);
                        ex_battery = cell.getStringCellValue();
                        tsDeviceStatus.setAbnormalBattery(Integer.parseInt(ex_battery));
                        //采集时间
                        cell = row.getCell((short) 16);
                        time = cell.getStringCellValue();
                        if (!StringUtil.isNull(time)) {
                           Date obsertime=FormatUtils.formatDateTime(time);
                           tsDeviceStatus.setObserveTime(obsertime);
                        }

                        //设备状态
                        cell = row.getCell((short) 17);
                        device_sta = cell.getStringCellValue();
                        if (device_sta.equals("ONLINE")) {

                            tsDeviceStatus.setDeviceSta(0);
                        } else if (device_sta.equals("OFFLINE")) {
                            tsDeviceStatus.setDeviceSta(1);
                        } else {
                            tsDeviceStatus.setDeviceSta(null);
                        }
                        tsDeviceStatusManager.save(tsDeviceStatus);
                        System.out.println("插入设备状态第" + i + "条");
                    }catch (Exception e){
                        System.out.println("插入设备状态第" + i + "条"+e);
                    }
                }
                break;*/
            case 4:
//                //要获得属性
//                String telecom = "";
//                String sn_num = "";
//                String kahao = "";
//                String devicename = "";
//                String devicetype = "0";
//                String producetime = "";
//                //获得所有数据
//                for(int i = 1 ; i <= totalRowNum ; i++)
//                {
//
//                try {
//                    //获得第i行对象
//                    Row row = sheet.getRow(i);
//                    //获得获得第i行第0列的 String类型对象
//                    //1
//                    Cell cell = row.getCell((short) 0);
//
//                    code = cell.getStringCellValue();
//                    tbDevice = tbDeviceManager.getByTeleCode(code);
//                    if (tbDevice == null) {
//                        tbDevice = new TBDevice();
//
//                    }
//                    tbDevice.setTelecomNumber(code);
//                    //2
//                    cell = row.getCell((short) 1);
//                    sn_num = cell.getStringCellValue();
//                    tbDevice.setSn(sn_num);
//                    //3
//                    cell = row.getCell((short) 2);
//                    kahao = cell.getStringCellValue();
//                    tbDevice.setCardNumber(kahao);
//                    //设备名称
//                    cell = row.getCell((short) 3);
//                    devicename = cell.getStringCellValue();
//                    tbDevice.setName(devicename);
//                    //设备名称
//                    cell = row.getCell((short) 4);
//                    devicetype = cell.getStringCellValue();
//                    tbDevice.setDeviceType(0);
//                    //生产日期
//                    cell = row.getCell((short) 5);
//                    producetime = cell.getStringCellValue();
//                    tbDevice.setProduceTime(producetime);
//                    //经度
//                    cell = row.getCell((short) 6);
//                    temp = cell.getStringCellValue();
//                    if (!StringUtil.isNull(temp) ) {
//                        tbDevice.setLangitude(Double.parseDouble(temp));
//                    }
//
//                    //纬度
//                    cell = row.getCell((short) 7);
//                    temp = cell.getStringCellValue();
//                    if (!StringUtil.isNull(temp) ) {
//                        tbDevice.setLatitude(Double.parseDouble(temp));
//                    }
//
//                    //地址
//                    cell = row.getCell((short) 8);
//                    address = cell.getStringCellValue();
//                    tbDevice.setAddress(address);
//                    //安装日期
//                    cell = row.getCell((short) 9);
//                    temp = cell.getStringCellValue();
//                    tbDevice.setInstallTime(temp);
//                    //设备类别
//                    cell = row.getCell((short) 10);
//                    temp = cell.getStringCellValue();
//                    tbDevice.setCategory(temp);
//                    //区域
//                    cell = row.getCell((short) 11);
//                    temp = cell.getStringCellValue();
//                    String regioncode = byBRegionManager.searchCodeByName(temp);
//                    if (!StringUtil.isNull(regioncode)) {
//                        tbDevice.setRegionCode(regioncode);
//                    }
//
//                    tbDeviceManager.upperSave(tbDevice);
//                    System.out.println("插入区域第" + i + "条");
//                }catch (Exception e){
//                    System.out.println("插入区域第" + i + "条shibai "+e);
//                }
//                }
                break;
                default:
                    break;
        }


    }
}
