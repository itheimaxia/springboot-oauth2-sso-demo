package com.brianxia.authserver.user.entity;

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
public class TPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private  Integer id;

    private String name;

    private String keyword;

    private String description;


}
