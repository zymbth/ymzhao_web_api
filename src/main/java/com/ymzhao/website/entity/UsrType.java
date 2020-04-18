package com.ymzhao.website.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ymzhao
 * @since 2020-04-18
 */
@Data
@ApiModel(value = "用户类型类", description = "用户类型的入参类与返回类")
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UsrType implements Serializable {

    /*private static final long serialVersionUID = 1L;*/

    @ApiModelProperty(value = "类型名称", position = 2)
    private String typename;

    @ApiModelProperty(value = "类型描述", position = 3)
    private String desc;
}
