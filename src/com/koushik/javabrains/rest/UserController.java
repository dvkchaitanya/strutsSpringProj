package com.koushik.javabrains.rest;

import com.koushik.javabrains.marshalling.UserNameWithIdsList;
import com.koushik.javabrains.service.UserService;
import com.koushik.javabrains.service.impl.UserServiceImpl;
import com.koushik.javabrains.viewBean.OnlyUserNameWithIds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/19/13
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public @ResponseBody OnlyUserNameWithIds getUserById(@PathVariable int userId){
         OnlyUserNameWithIds onlyUserNameWithIds =userService.getUserById(userId);
        return onlyUserNameWithIds;
    }

   @RequestMapping(value = "/list",method = RequestMethod.GET ,headers = "Accept=application/xml")
   public @ResponseBody
   UserNameWithIdsList showAllUsers(){
       UserNameWithIdsList userNameWithIdsList12 = new UserNameWithIdsList();
        userNameWithIdsList12.setUserNameWithIdsList(userService.showAllUsers());
       return userNameWithIdsList12;
   }

}

