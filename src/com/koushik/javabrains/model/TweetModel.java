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
@Component("tweetModel")
public class TweetModel {

    private int tweetId;

    private String tweet;

    private int userSel;

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public void setTweetId(String tweetId){
        this.tweetId = Integer.parseInt(tweetId);
    }
    public String getTweet() {
        return tweet;
    }

    public void setTweet(String aTweet) {
        this.tweet = aTweet;
    }

    public int getUserSel() {
        return userSel;
    }

    public void setUserSel(int userSel) {
        this.userSel = userSel;
    }
}
