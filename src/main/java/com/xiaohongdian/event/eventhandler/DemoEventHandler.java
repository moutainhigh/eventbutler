package com.xiaohongdian.event.eventhandler;


import com.xiaohongdian.common.enums.EventTypeEnum;
import com.xiaohongdian.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * @Description 创建/删除评论、回答、回复的事件处理器
 * @Author xiaohongdian
 * @Date 2019/1/24
 **/
@Component
@Slf4j
public class DemoEventHandler implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        String eventCode = event.getEventCode();
        if (EventTypeEnum.COMMENT.getCode().equals(eventCode)) {
            onComment(event);
        } else if (EventTypeEnum.DELETE_COMMENT.getCode().equals(eventCode)){
            onDeleteComment(event);
        }
    }

    /**
     * 当发生事件：评论/回答/回复
     * @param event
     */
    private void onComment(Event event) {

    }

    private void onDeleteComment(Event event) {

    }

    @Override
    public List<String> getEventTypes() {
        return Arrays.asList(
                EventTypeEnum.COMMENT.getCode(),
                EventTypeEnum.DELETE_COMMENT.getCode());
    }

}