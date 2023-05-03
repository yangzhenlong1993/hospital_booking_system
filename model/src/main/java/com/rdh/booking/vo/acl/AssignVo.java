package com.rdh.booking.vo.acl;

import lombok.Data;

/**
 * @author yangz
 */
@Data
public class AssignVo {

    private Long roleId;

    private Long[] permissionId;
}
