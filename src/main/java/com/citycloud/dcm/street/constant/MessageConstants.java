package com.citycloud.dcm.street.constant;

/**
 * 消息常量
 *
 * @author Wu.Liang
 * @date 2019年8月2日
 */
public class MessageConstants {
    /**
     * 操作成功
     */
    public static final String RESPONSE_MESSAGE_SUCCESS = "操作成功";
    /**
     * 操作失败
     */
    public static final String RESPONSE_MESSAGE_FAILED = "操作失败";
    /**
     * 当前未登录或登录失效
     */
    public static final String RESPONSE_MESSAGE_FAILED_01 = "当前未登录或登录失效";
    /**
     * 系统中找不到此记录，请确认ID是否正确
     */
    public static final String RESPONSE_MESSAGE_FAILED_02 = "系统中找不到此记录，请确认ID是否正确";
    /**
     * 系统中找不到相关记录
     */
    public static final String RESPONSE_MESSAGE_FAILED_02_01 = "系统中找不到相关记录";
    /**
     * 当前单据流程未开始
     */
    public static final String RESPONSE_MESSAGE_FAILED_03 = "当前单据流程未开始";
    /**
     * 当前单据流程已经结束
     */
    public static final String RESPONSE_MESSAGE_FAILED_04 = "当前单据流程已经结束";
    /**
     * 用于字符串拼接的分隔符号：", "
     */
    public static final String SEPARATOR_01 = ", ";

    /**
     * 禁止实例化
     *
     * @author Wu.Liang
     */
    private MessageConstants() {
    }
}
