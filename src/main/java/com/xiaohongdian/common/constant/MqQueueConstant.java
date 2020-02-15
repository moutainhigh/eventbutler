package com.xiaohongdian.common.constant;

/**
 * mq队列统一配置
 */
public class MqQueueConstant {

    // 文章点赞异步队列
    public static final String ARTICLE_LIKED_QUEUE ="article_like_queue";
    // 文章收藏异步队列
    public static final String ARTICLE_COLLECTED_QUEUE ="article_collect_queue";
    // 文章评论异步队列
    public static final String ARTICLE_COMMENT_QUEUE ="article_comment_queue";

    /**
     * 点赞/取消点赞文章问题的队列名
     */
    public static final String LIKE_ARTICLE_QUESTION_QUEUE = "like_article_question_event";
    /**
     * 收藏/取消收藏文章问题的队列名
     */
    public static final String COLLECT_ARTICLE_QUESTION_QUEUE = "collect_article_question_event";
    /**
     * 评论/回答/回复及删除的队列名
     */
    public static final String COMMENT_QUEUE = "comment_event";
    /**
     * 点赞/取消点赞评论/回答/回复的队列名
     */
    public static final String LIKE_COMMENT_QUEUE = "like_comment_event";
    /**
     * 发布/删除文章/问题的队列名
     */
    public static final String PUBLISH_ARTICLE_QUESTION_QUEUE = "publish_article_question_event";

}
