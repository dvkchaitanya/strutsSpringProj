package com.koushik.javabrains.marshalling;

import com.koushik.javabrains.entity.UserEntity;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 *
 *
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/21/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({UserEntity.class})
public class UserEntitiesList {
    @XmlElement(name = "usersList")
    private List<UserEntity> userEntities;

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
