package com.ymzhao.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Create By ymzhao on 2020/4/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @TableId(value = "id", type = IdType.AUTO)
    protected Integer id;

    @ApiModelProperty(value = "创建时间", position = 98, hidden = true)
    protected LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", position = 99, hidden = true)
    protected LocalDateTime updateTime;
}
