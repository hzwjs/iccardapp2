package com.iccardapp.common.vo;




/**
 * 变量配置类，用于各种基础变量的定义
 * 
 * @author taojin
 * 
 */
public class GlobalConstant {

	// 登录用户信息
	public static final String SESSION_INFO = "sessionInfo";

	// 登录用户
	public static final String LOGIN_USER_INFO = "loginUser";

	// 用户激活
	public static final int USER_ACTIVE = 0;

	// 用户冻结
	public static final int USER_FREEZE = 1;

	// 用户未修改密码
	public static final int USER_UPCHGPWD = 2;

	// 用户是管理员
	public static final int USER_IS_ADMIN = 0;

	// 用户不是管理员
	public static final int USER_NOT_ADMIN = 1;

	// 平台用户
	public static final int USER_TPYE_PLATFORM = 1;

	// 注册用户
	public static final int USER_TPYE_REGIST = 2;

	// 司机用户
	public static final int USER_TPYE_DRIVER = 3;

	// 业务未审核
	public static final int BUSI_UNCHECK = 1;

	// 业务已审核
	public static final int BUSI_CHECKED = 2;

	// 报名截止
	public static final int BUSI_CLOSE = 3;

	// 业务承运中
	public static final int BUSI_TRANSPORTING = 4;

	// 送达（所有订单送达）
	public static final int BUSI_ARRIVED = 5;

	// 已结算（全部结算或事故终止）
	public static final int BUSI_SETTLED = 6;

	// 订单抢单
	public static final int ORDER_GRABED = 1;

	// 订单已取消
	public static final int ORDER_UNDOED = 2;

	// 订单已通过未承运
	public static final int ORDER_PASSED = 3;

	// 订单正在承运
	public static final int ORDER_TRANSPORTING = 4;

	// 订单已送达（回单未寄送）
	public static final int ORDER_ARRIVED = 5;

	// 送达确认
	public static final int ORDER_CONFIRM = 6;

	// 订单回单已寄出
	public static final int ORDER_SLIPSENT = 7;

	// 订单回单到达未结算
	public static final int ORDER_SLIPGOT = 8;

	// 订单出现事故
	public static final int ORDER_ACCIDENT = 9;

	// 订单事故终止
	public static final int ORDER_ACCOVER = 10;

	// 订单已结算
	public static final int ORDER_SETTLED = 11;
	
	// 运力公司未审核
	public static final int ORDER_TRA_UNCHECK = 1;

	// 运力公司通过
	public static final int ORDER_TRA_PASS = 2;

	// 运力公司拒绝
	public static final int ORDER_TRA_REFUSE = 3;
	
	// 资源公司未审核
	public static final int ORDER_RES_UNCHECK = 1;

	// 资源公司通过
	public static final int ORDER_RES_PASS = 2;

	// 资源公司拒绝
	public static final int ORDER_RES_REFUSE = 3;

	// 公司未审核
	public static final int COM_CHECKED_NO = 0;

	// 公司审核通过
	public static final int COM_CHECKED = 1;

	// 公司审核不通过
	public static final int COM_UNCHECK = 2;

	// 司机空闲
	public static final int DRIVER_FREE = 1;

	// 司机忙碌
	public static final int DRIVER_BUSY = 2;

	// 司机承运中
	public static final int DRIVER_JOB = 3;

	// 默认司机行驶里程
	public static final int DRIVER_MILEAGE = 0;

	// 默认司机事故数
	public static final int DRIVER_ACDNT = 0;

	// 默认司机等级
	public static final int DRIVER_LEVEL = 1;

	// 广告可用
	public static final int ADV_UNNOT = 1;

	// 默认广告不可用
	public static final int ADV_NOT = 2;

	// 广告展示 登录
	public static final int ADV_SHOW_LOGIN = 1;

	// 广告展示 主页
	public static final int ADV_SHOW_INDEX = 2;

	// 新闻 可以
	public static final int NEWS_ABLE = 0;

	// 新闻 不可以
	public static final int NEWS_NOT_ABLE = 1;

	// 论坛 可用
	public static final int FORUM_ABLE = 0;

	// 论坛 不可用
	public static final int FORUM_NOT_ABLE = 1;
}
