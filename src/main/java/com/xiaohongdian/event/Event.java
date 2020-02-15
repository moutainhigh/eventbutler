package com.xiaohongdian.event;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;

/**
 * 事件实体
 */
@Data
@Accessors(chain = true)
public class Event {

    /**
     * 事件类型
     */
    private String eventCode;
    /**
     * 事件相关业务方法的参数
     */
    private List<Object> params;
    /**
     * 事件相关业务方法的返回值
     */
    private Object result;
    /**
     * 操作人员工号
     */
    private String dataEmployeeId;

    public Event setParam(Object param) {
        this.params = Arrays.asList(param);
        return this;
    }

}