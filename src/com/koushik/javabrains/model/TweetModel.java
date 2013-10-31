package com.koushik.javabrains.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 9/28/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name ="tweetModel")
@Component("tweetModel")
@Table(name = "tweeets")
public class TweetModel {

    private int tweetId;

    private String tweet;

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String aTweet) {
        this.tweet = aTweet;
    }

}
