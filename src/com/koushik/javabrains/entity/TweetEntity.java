package com.koushik.javabrains.entity;

/*import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;*/
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweetId")
    private int tweetId;

    @Column(name = "tweet")
    private String tweet;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
