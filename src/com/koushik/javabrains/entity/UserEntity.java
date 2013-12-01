package com.koushik.javabrains.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
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
@XmlRootElement(name = "userEntity")
@XmlAccessorType(XmlAccessType.NONE)
public class UserEntity implements Serializable {

//    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true, nullable = false)
    private int userId;

    @XmlElement(required = true)
    @Column(name = "userName")
    private String userName;

//    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "userEntity",cascade = CascadeType.ALL)
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", tweetEntitiySet=" + tweetEntitiySet +
                '}';
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (tweetEntitiySet != null ? !tweetEntitiySet.equals(that.tweetEntitiySet) : that.tweetEntitiySet != null)
           return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }*/
}
