package com.bj.hai.yang.blog.start.service.impl;

import com.alibaba.fastjson.JSON;
import com.bj.hai.yang.blog.start.dao.test.HolidayDao;
import com.bj.hai.yang.blog.start.dto.Holiday;
import com.bj.hai.yang.blog.start.model.HolidayModel;
import com.bj.hai.yang.blog.start.service.HolidayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("holidayService")
public class HolidayServiceImpl implements HolidayService {

    @Resource
    private HolidayDao holidayDao;

    @Override
    public List<HolidayModel> selectByMonth() {
        List<Holiday> holidays = holidayDao.selectByMonth(201801);
        System.out.println("JSON.toJSONString(holidays) = " + JSON.toJSONString(holidays));
        return null;
    }
}
