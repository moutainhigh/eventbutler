package com.xiaohongdian.event;

import com.alibaba.fastjson.JSON;
import com.xiaohongdian.common.constant.MqQueueConstant;
import com.xiaohongdian.common.enums.EventTypeEnum;
import com.xiaohongdian.common.util.SpringUtils;
import com.xiaohongdian.event.eventhandler.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 事件管理器，事件的发布、处理；事件处理器在这里注册
 * @Author xiaohongdian
 * @Date 2019/01/14
 */
@Component
@Slf4j
public class EventManager {

    @Autowired
    private SpringUtils springUtils;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 事件处理器池
     */
    private Map<String, EventHandler> eventHandlerMap = new HashMap<>();

    /**
     * 发布事件，将事件放到mq上
     * @param event
     */
    public void publishEvent(Event event) {
        String jsonString = JSON.toJSONString(event);
        //判断事件类型放到对应的消息队列上
        try {
            jmsMessagingTemplate.convertAndSend(getMqQueueName(event),jsonString);
        } catch (Exception e) {
            log.error("事件发布失败："+e.toString());
        }
    }

    /**
     * 根据事件获取对应的消息队列名
     * @param event
     * @return
     */
    private String getMqQueueName(Event event) {
        String eventCode = event.getEventCode();
        String mqQueueName = "";
        if (EventTypeEnum.PUBLISH_ARTICLE_QUESTION.getCode().equals(eventCode)||EventTypeEnum.DELETE_ARTICLE_QUESTION.getCode().equals(eventCode)) {
            mqQueueName = MqQueueConstant.PUBLISH_ARTICLE_QUESTION_QUEUE;
        }
        return mqQueueName;
    }

    /**
     * 处理事件
     * @param event 事件
     */
    public void handleEvent(Event event) {
        //通过事件类型找到相应的事件处理器，并将事件交给其处理
        EventHandler eventHandler = eventHandlerMap.get(event.getEventCode());
        if (eventHandler!=null) {
            eventHandler.handleEvent(event);
        } else {
            log.error("eventError ==> 事件类型："+event.getEventCode()+"，没有相应的事件处理器");
        }
    }

    /**
     * 事件管理器初始化后，将所有事件处理器注册到事件管理器中
     */
    @PostConstruct
    private void registerEventHandler() {
        List<EventHandler> beans = springUtils.getBeans(EventHandler.class);
        if (!beans.isEmpty()) {
            for (EventHandler eventHandler:beans){
                List<String> eventTypes = eventHandler.getEventTypes();
                if (eventTypes!=null&&eventTypes.size()>0) {
                    for (String eventType:eventTypes) {
                        eventHandlerMap.put(eventType,eventHandler);
                    }
                }
            }
        }
    }

}
