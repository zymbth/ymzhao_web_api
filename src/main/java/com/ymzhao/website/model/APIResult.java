package com.ymzhao.website.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description="API结果")
public class APIResult<T> implements Serializable {
	private static final long serialVersionUID = -7459323925969543628L;
	
    @ApiModelProperty(value="响应编码,请查看APIResultCode类",example="0-成功,1-失败", position=1)
	private Integer code;
    
    @ApiModelProperty(value="响应消息,请查看APIResultCode类",example="成功;失败", position=2)
	private String message;
    
    @ApiModelProperty(value="响应数据内容",example="null", position=3)
	private T data;
    
    @ApiModelProperty(value="附加详细内容",example="null", position=4)
	private String details;
	
	APIResult(){
		this(APIResultCode.SUCCESS, null, null);
	}
	
	APIResult(APIResultCode resultCode){
		this(resultCode, null, null);
	}
	
	APIResult(APIResultCode resultCode, T data){
		this(resultCode, data, null);
	}
	
	APIResult(APIResultCode resultCode, String details){
		this(resultCode, null, details);
	}
	
	APIResult(APIResultCode resultCode, T data, String details){
		this.code = resultCode.code();
		this.message = resultCode.message();
		this.data = data;
		this.details = details;
	}
	

	public static <TT> APIResult<TT> success() {
		return new APIResult<TT>(APIResultCode.SUCCESS);
	}
	
	public static <TT> APIResult<TT> success(TT data) {
		return new APIResult<TT>(APIResultCode.SUCCESS, data);
	}
	
	public static <TT> APIResult<TT> failure(APIResultCode resultCode) {
		assert resultCode != APIResultCode.SUCCESS;
		return new APIResult<TT>(resultCode);
	}
	
	public static <TT> APIResult<TT> failure(APIResultCode resultCode, String details) {
		assert resultCode != APIResultCode.SUCCESS;
		return new APIResult<TT>(resultCode, details);
	}

}
