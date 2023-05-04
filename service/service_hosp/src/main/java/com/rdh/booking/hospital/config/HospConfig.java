package com.rdh.booking.hospital.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangz
 */

@Configuration
@MapperScan("com.rdh.booking.hospital.mapper")
public class HospConfig {
}
