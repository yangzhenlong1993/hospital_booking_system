package com.rdh.booking.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rdh.booking.common.utils.MD5;
import com.rdh.booking.hospital.mapper.HospitalSetMapper;
import com.rdh.booking.hospital.service.HospitalSetService;
import com.rdh.booking.model.hosp.HospitalSet;
import com.rdh.booking.vo.hosp.HospitalSetQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @author yangz
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Override
    public Page<HospitalSet> getHospSetByQueryInPage(Long current, Long limit, HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = new Page<>(current, limit);
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        if (StringUtils.hasText(hospitalSetQueryVo.getHosname())) {
            wrapper.like("hosname", hospitalSetQueryVo.getHosname());
        }
        if (StringUtils.hasText(hospitalSetQueryVo.getHoscode())) {
            wrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());
        }
        page = this.baseMapper.selectPage(page, wrapper);
        return page;
    }

    @Override
    public boolean saveHospitalSet(HospitalSet hospitalSet) {
        hospitalSet.setStatus(1);
        //TODO signature key, should be extracted to a method
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()+""+ random.nextInt(1000)));
        boolean flag = this.save(hospitalSet);
        return flag;

    }

    @Override
    public void lockHospitalSetById(Long id, Integer status) {
        HospitalSet hospitalSet = this.getById(id);
        hospitalSet.setStatus(status);
        this.updateById(hospitalSet);
    }
}
