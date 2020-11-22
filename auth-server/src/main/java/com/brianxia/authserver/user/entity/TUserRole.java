package com.brianxia.authserver.user.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author brianxia
 * @since 2020-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;


}
