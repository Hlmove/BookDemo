package com.hlmove.demo_bookcase.result;

/**
 * 统一并自定义返回状态码，如有需求可以另外增加
 * @author Hlmove
 */
public enum ResultCode {

	/* 成功状态码 */
	SUCCESS(1, "操作成功"),

	/* 图书管理模块错误 10001 - 19999 */
	BOOK_NAME_IS_NULL(10001, "图书名称为空"),
	BOOK_AUTHOR_IS_NULL(10002, "图书作者为空"),
	BOOK_PUBLISHER_IS_NULL(10003, "图书出版社为空"),

	BOOK_IS_NOT_EXIST(10004, "图书信息不存在，请刷新页面重试"),


	/* 分类管理模块错误 20001 - 29999 */
	CATEGORY_IS_NOT_EXIST(20001, "分类不存在，请刷新页面重试"),
	;


	private Integer code;

	private String message;

	ResultCode(Integer code, String message) {
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
