package com.koushik.javabrains.viewBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/23/13
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "onlyUserNameWithIds")
public class OnlyUserNameWithIds {
    private int userId;
    private String userName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OnlyUserNameWithIds)) return false;

        OnlyUserNameWithIds that = (OnlyUserNameWithIds) o;

        if (userId != that.userId) return false;
        if (!userName.equals(that.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + userName.hashCode();
        return result;
    }
}
