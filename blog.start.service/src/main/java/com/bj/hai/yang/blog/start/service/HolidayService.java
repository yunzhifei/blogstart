package com.bj.hai.yang.blog.start.service;

import com.bj.hai.yang.blog.start.model.HolidayModel;

import java.util.List;

public interface HolidayService {
    List<HolidayModel> selectByMonth();
}
