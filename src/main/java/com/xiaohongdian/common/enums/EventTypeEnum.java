package com.xiaohongdian.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 事件枚举
 */
public enum EventTypeEnum {
    LIKE_ARTICLE_QUESTION("点赞文章/问题", "LIKE_ARTICLE_QUESTION"),
    COLLECT_ARTICLE_QUESTION("收藏文章/问题", "COLLECT_ARTICLE_QUESTION"),
    COMMENT("评论/回答/回复", "COMMENT"),
    LIKE_COMMENT("点赞评论/回答/回复", "LIKE_COMMENT"),
    FOLLOW_FOLDER("关注收藏夹", "FOLLOW_FOLDER"),
    UPDATE_FOLDER("收藏夹放入新内容", "UPDATE_FOLDER"),
    FOLLOW_BANNER("关注专栏", "FOLLOW_BANNER"),
    UPDATE_BANNER("专栏有新文章发布", "UPDATE_BANNER"),
    FOLLOW_SOMEONE("关注某人", "FOLLOW_SOMEONE"),
    INVITATION_ANSWER("邀请答题", "INVITATION_ANSWER"),
    PUBLISH_ARTICLE_QUESTION("发布文章/问题", "PUBLISH_ARTICLE_QUESTION"),
    AT_SOMEONE_ARTICLE_QUESTION("文章/问题中@某人", "AT_SOMEONE_ARTICLE_QUESTION"),
    AT_SOMEONE_COMMENT_ANSWER("评论、回答中@某人", "AT_SOMEONE_COMMENT_ANSWER"),
    COLLECT_ANSWER("收藏回答", "COLLECT_ANSWER"),
    CREATE_FOLDER("创建收藏夹", "CREATE_FOLDER"),
    CREATE_BANNER("创建专栏", "CREATE_BANNER"),
    CANCEL_LIKE_ARTICLE_QUESTION("取消点赞文章/问题", "CANCEL_LIKE_ARTICLE_QUESTION"),
    CANCEL_COLLECT_ARTICLE_QUESTION("取消收藏文章/问题", "CANCEL_COLLECT_ARTICLE_QUESTION"),
    CANCEL_FOLLOW_FOLDER("取消关注收藏夹", "CANCEL_FOLLOW_FOLDER"),
    CANCEL_FOLLOW_BANNER("取消关注专栏", "CANCEL_FOLLOW_BANNER"),
    CANCEL_FOLLOW_SOMEONE("取消关注某人", "CANCEL_FOLLOW_SOMEONE"),
    CANCEL_LIKE_COMMENT("取消点赞评论/回答/回复", "CANCEL_LIKE_COMMENT"),
    CANCEL_COLLECT_ANSWER("取消收藏回答", "CANCEL_COLLECT_ANSWER"),
    HIDE_DELETE_ARTICLE_QUESTION("隐藏删除文章/问题", "HIDE_DELETE_ARTICLE_QUESTION"),
    DELETE_COMMENT("删除评论/回答/回复", "DELETE_COMMENT"),
    DELETE_FOLDER("删除收藏夹", "DELETE_FOLDER"),
    DELETE_BANNER("删除专栏", "DELETE_BANNER"),
    REMOVE_BANNER("移出专栏内容", "REMOVE_BANNER"),
    REMOVE_FOLDER("移出收藏夹内容", "REMOVE_FOLDER"),
    DELETE_REPLY_IN_ARTICLE("删除文章中的回复", "DELETE_REPLY_IN_ARTICLE"),
    DELETE_REPLY_IN_QUESTION("删除问题中回复", "DELETE_REPLY_IN_QUESTION"),
    DELETE_ARTICLE_QUESTION("删除文章/问题", "DELETE_ARTICLE_QUESTION");


    private String name;
    private String code;

    EventTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static EventTypeEnum getEnumByName(String name) {
        if (StringUtils.isNotBlank(name)) {
            for (EventTypeEnum eventTypeEnum : EventTypeEnum.values()) {
                if (eventTypeEnum.getName().equals(name)) {
                    return eventTypeEnum;
                }
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}




