package com.koushik.javabrains.marshalling;

import com.koushik.javabrains.service.impl.UserServiceImpl;
import com.koushik.javabrains.viewBean.OnlyUserNameWithIds;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/30/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "userNameWithIdsList12")
public class  UserNameWithIdsList {
    private List<OnlyUserNameWithIds>  userNameWithIdsList=
            new ArrayList<OnlyUserNameWithIds> ();

    public UserNameWithIdsList() {
    }

    public UserNameWithIdsList(List<OnlyUserNameWithIds> userNameWithIdsList) {
        this.userNameWithIdsList = userNameWithIdsList;
    }

    @XmlElement(name ="onlyUserNameWithIds")
    public List<OnlyUserNameWithIds> getUserNameWithIdsList() {
        return userNameWithIdsList;
    }

    public void setUserNameWithIdsList(List<OnlyUserNameWithIds> userNameWithIdsList) {
        this.userNameWithIdsList = userNameWithIdsList;
    }

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
/*  @XmlElement(name ="userNameWithIds")
    public List<OnlyUserNameWithIds> getOnlyUserNameWithIdsList() {
        return onlyUserNameWithIdsList;
    }

    public void setOnlyUserNameWithIdsList(List<OnlyUserNameWithIds> onlyUserNameWithIdsList) {
        this.onlyUserNameWithIdsList = onlyUserNameWithIdsList;

    }*/
}
