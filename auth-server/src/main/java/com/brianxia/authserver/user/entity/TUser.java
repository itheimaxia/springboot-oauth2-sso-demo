package com.brianxia.authserver.user.entity;

import java.time.LocalDate;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private  Integer id;

    private LocalDate birthday;

    private String gender;

    private String username;

    private String password;

    private String remark;

    private String station;

    private String telephone;


}
