package com.rdh.booking.hospital.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rdh.booking.model.hosp.HospitalSet;
import com.rdh.booking.vo.hosp.HospitalSetQueryVo;

/**
 * @author yangz
 */
public interface HospitalSetService extends IService<HospitalSet> {
    Page<HospitalSet> getHospSetByQueryInPage(Long current, Long limit, HospitalSetQueryVo hospitalSetQueryVo);

    boolean saveHospitalSet(HospitalSet hospitalSet);

    void lockHospitalSetById(Long id, Integer status);
}
