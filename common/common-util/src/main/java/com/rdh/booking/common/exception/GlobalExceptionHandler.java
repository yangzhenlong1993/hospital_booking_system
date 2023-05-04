package com.rdh.booking.common.exception;

import com.rdh.booking.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    //need to manually throw the HospitalException
    @ExceptionHandler(HospitalException.class)
    @ResponseBody
    public Result error(HospitalException e){
        e.printStackTrace();
        return Result.fail();
    }
}
