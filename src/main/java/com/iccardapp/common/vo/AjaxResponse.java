package com.iccardapp.common.vo;



import java.util.List;

import org.springframework.stereotype.Component;

/**
 * ajax返回json对象实体类
 * 
 * @author shine
 * 
 */
@Component
public class AjaxResponse {

    /**
     * 成功
     */
    public static final Integer SUCCESS = 0;

    /**
     * 失败
     */
    public static final Integer FAILURE = -1;

    /**
     * 异常
     */
    public static final Integer EXCEPTION = -2;

    /**
     * 返回码
     */
    private Integer code = SUCCESS;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 数据记录ID
     */
    private int recordId;

    /**
     * 数据记录编码
     */
    private String recordNO;

    /**
     * 数据记录名称
     */
    private String recordName;

    /**
     * 数据记录对象
     */
    private Object record;

    /**
     * 数据记录列表
     */
    private List<?> records;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordNO() {
        return recordNO;
    }

    public void setRecordNO(String recordNO) {
        this.recordNO = recordNO;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public Object getRecord() {
        return record;
    }

    public void setRecord(Object record) {
        this.record = record;
    }

    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<?> records) {
        this.records = records;
    }
}