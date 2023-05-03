package com.rdh.booking.hospital.controller;

import com.rdh.booking.hospital.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangz
 */
@RestController
@RequestMapping("admin/hosp/hospitalSet")
public class HospitalSetController {
    @Resource
    private HospitalSetService hospitalSetService;
}
