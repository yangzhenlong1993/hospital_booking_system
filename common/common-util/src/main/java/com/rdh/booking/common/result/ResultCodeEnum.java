package com.rdh.booking.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"Success"),
    FAIL(201, "Failed"),
    PARAM_ERROR( 202, "incorrect parameter"),
    SERVICE_ERROR(203, "service error"),
    DATA_ERROR(204, "data error"),
    DATA_UPDATE_ERROR(205, "data version error"),

    LOGIN_AUTH(208, "not logged in"),
    PERMISSION(209, "no permission"),

    CODE_ERROR(210, "incorrect CAPTCHA"),
//    LOGIN_MOBLE_ERROR(211, "账号不正确"),
    LOGIN_DISABLED_ERROR(212, "the user has been banned"),
    REGISTER_MOBLE_ERROR(213, "the phone has been banned"),
    LOGIN_AURH(214, "need to login"),
    LOGIN_ACL(215, "no permission"),

    URL_ENCODE_ERROR( 216, "URL encoding failed"),
    ILLEGAL_CALLBACK_REQUEST_ERROR( 217, "Illegal callback request"),
    FETCH_ACCESSTOKEN_FAILD( 218, "Failed to get accessToken"),
    FETCH_USERINFO_ERROR( 219, "Failed to get user information"),
    //LOGIN_ERROR( 23005, "登录失败"),

    PAY_RUN(220, "paying"),
    CANCEL_ORDER_FAIL(225, "Failed to cancel order"),
    CANCEL_ORDER_NO(225, "Cannot cancel appointment"),

    HOSCODE_EXIST(230, "Hospital code already exists"),
    NUMBER_NO(240, "Insufficient reservation slots"),
    TIME_NO(250, "Appointments are not available at the moment"),

    SIGN_ERROR(300, "signature error"),
    HOSPITAL_OPEN(310, "The hospital is not open and temporarily inaccessible"),
    HOSPITAL_LOCK(320, "The hospital is locked and temporarily inaccessible"),
    ;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
