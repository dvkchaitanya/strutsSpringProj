package com.koushik.javabrains.dao;

import com.koushik.javabrains.model.TweetModel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/13/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TweetDao {
    JdbcTemplate getJdbcTemplate();

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    void insert(TweetModel tweetModel);

    List<TweetModel> listTweets();

    void deleteTweet(TweetModel tweetModel);

    void updateTweet(TweetModel tweetModel);
}
