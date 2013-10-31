package com.koushik.javabrains.entity;

/*import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;*/
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/23/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity(name ="tweetEntity")
@Table(name = "tweeets")
public class TweetEntity
        implements Serializable
{
    @Id
    @Column(name = "tweetId")
    private int tweetId;

    @Column(name = "tweet")
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

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

}
