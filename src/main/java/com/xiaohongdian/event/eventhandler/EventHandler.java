package com.xiaohongdian.event.eventhandler;


import com.xiaohongdian.event.Event;

import java.util.List;

/**
 * @Description 事件处理器接口
 * 一种类型的事件只会有一个事件处理器来处理；
 * 一个事件处理器可以处理多种类型的事件
 * @Author xiaohongdian
 * @Date 2019/01/14
 */
public interface EventHandler {

    /**
     * 处理事件
     * @param event
     */
    void handleEvent(Event event);

    /**
     * 获取当前事件处理器负责处理的事件类型
     * @return
     */
    List<String> getEventTypes();
}
