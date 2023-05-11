package com.rdh.booking.data.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rdh.booking.model.cmn.Dict;
import com.rdh.booking.model.hosp.HospitalSet;
import com.rdh.booking.vo.hosp.HospitalSetQueryVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yangz
 */
public interface DictService extends IService<Dict> {
    List<Dict> findChildData(Long id);

    void exportDictData(HttpServletResponse response);
}
