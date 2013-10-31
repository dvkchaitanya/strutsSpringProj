package com.koushik.javabrains.service;

import com.koushik.javabrains.dao.TweetDao;
import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.model.TweetModel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/13/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TweetService {
    TweetDao getTweetDao();

    void setTweetDao(TweetDao tweetDao);

    void insert(TweetModel tweetModel);

    List<TweetEntity> showAllTweets();

    void delete(TweetModel tweetModel);

    void update(TweetModel tweetModel);
}
