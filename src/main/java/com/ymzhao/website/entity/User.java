package com.ymzhao.website.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * user informations
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
@Data
@ApiModel(value = "用户类", description = "用户的入参类与返回类")
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends BaseEntity {

    /*private static final long serialVersionUID = 1L;*/

    @ApiModelProperty(value = "用户类型", position = 2)
    private Integer usrtype;

    @ApiModelProperty(value = "用户名", position = 3)
    private String usrname;

    @JsonIgnore
    @ApiModelProperty(value = "用户密码", position = 4)
    private String pwd;

    @ApiModelProperty(value = "电话", position = 5)
    private String tel;

    @ApiModelProperty(value = "邮箱", position = 6)
    private String email;
}
