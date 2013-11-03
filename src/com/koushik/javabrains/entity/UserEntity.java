package com.koushik.javabrains.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/31/13
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "userEntity")
@Table(name = "users",catalog = "twitdatabase", uniqueConstraints = {
        @UniqueConstraint(columnNames = "userName")
})
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true, nullable = false)
    private int userId;

    @Column(name = "userName")
    private String userName;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "userEntity")
    private Set<TweetEntity> tweetEntitiySet = new HashSet<TweetEntity>(0);

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<TweetEntity> getTweetEntitiySet() {
        return tweetEntitiySet;
    }

    public void setTweetEntitiySet(Set<TweetEntity> tweetEntitiySet) {
        this.tweetEntitiySet = tweetEntitiySet;
    }
}
