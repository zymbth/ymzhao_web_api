package com.ymzhao.website.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description="API结果编码")
public enum APIResultCode {
    /* 成功状态码 */
    SUCCESS(0, "成功"),
    /* 通用失败状态码 */
    FAILURE(1, "失败, 未知错误, 请查看详细日志"),
    
    /* 参数错误：1000-1999 */
    PARAM_NOT_COMPLETE(1000, "参数缺失"),
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_TYPE_BIND_ERROR(1002, "参数类型错误"),

    /* 用户错误：2000-2999*/
    USER_NOT_LOGGED_IN(2001, "用户未登录"),
    USER_LOGIN_ERROR(2002, "用户不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003, "用户已被禁用"),
    USER_NOT_EXIST(2004, "用户不存在"),
    USER_HAS_EXISTED(2005, "用户已存在"),
    USER_NO_PERMISSION(2006, "无访问权限"),
    
    /* 系统错误：3000-3999 */
    SYSTEM_API_ERROR(3000, "接口调用异常"),

    /* 业务问题：60000-69999 */
    BIZ_ERROR(60000, "业务错误");

    private Integer code;
	private String message;
	
	APIResultCode(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	public Integer code() {
		return this.code;
	}
	public String message() {
		return this.message;
	}
}
