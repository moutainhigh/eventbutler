package com.xiaohongdian.event;

import com.alibaba.fastjson.JSON;
import com.xiaohongdian.common.constant.MqQueueConstant;
import com.xiaohongdian.common.enums.EventTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;


/**
 * 事件发布器
 */
@Component
@Slf4j
public class EventPublisher {

    //@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发布事件，将事件放到mq上
     * @param event 事件
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
        if (EventTypeEnum.LIKE_ARTICLE_QUESTION.getCode().equals(eventCode)||EventTypeEnum.CANCEL_LIKE_ARTICLE_QUESTION.getCode().equals(eventCode)) {
            mqQueueName = MqQueueConstant.LIKE_ARTICLE_QUESTION_QUEUE;
        } else if (EventTypeEnum.COLLECT_ARTICLE_QUESTION.getCode().equals(eventCode)||EventTypeEnum.CANCEL_COLLECT_ARTICLE_QUESTION.getCode().equals(eventCode)) {
            mqQueueName = MqQueueConstant.COLLECT_ARTICLE_QUESTION_QUEUE;
        } else if (EventTypeEnum.COMMENT.getCode().equals(eventCode)||EventTypeEnum.DELETE_COMMENT.getCode().equals(eventCode)) {
            mqQueueName = MqQueueConstant.COMMENT_QUEUE;
        } else if (EventTypeEnum.LIKE_COMMENT.getCode().equals(eventCode)||EventTypeEnum.CANCEL_LIKE_COMMENT.getCode().equals(eventCode)) {
            mqQueueName = MqQueueConstant.LIKE_COMMENT_QUEUE;
        } else if (EventTypeEnum.PUBLISH_ARTICLE_QUESTION.getCode().equals(eventCode)||EventTypeEnum.DELETE_ARTICLE_QUESTION.getCode().equals(eventCode)) {
            mqQueueName = MqQueueConstant.PUBLISH_ARTICLE_QUESTION_QUEUE;
        }
        return mqQueueName;
    }

}
