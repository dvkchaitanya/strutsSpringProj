package com.koushik.javabrains.spring.ws;

import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.service.UserService;
import com.koushik.javabrains.spring.ws.types.UserDetailsRequest;
import com.koushik.javabrains.spring.ws.types.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/10/13
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Endpoint
public class UserServiceEndpoint {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PayloadRoot(localPart = "UserDetailsRequest",namespace = "http://www.vdesu.strutsSpringProj.samples.com/users")
    public @ResponsePayload
    UserDetailsResponse getUserNameById(@RequestPayload
                                        UserDetailsRequest userDetailsRequest ){
        UserEntity userEntity =userService.getUserById(userDetailsRequest.getUserId().intValue());
        String userName =userEntity.getUserName();
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        userDetailsResponse.setUserName(userName);
        return userDetailsResponse;
    }

}
