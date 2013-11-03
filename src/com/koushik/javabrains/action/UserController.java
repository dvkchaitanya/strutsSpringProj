package com.koushik.javabrains.action;

import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;
import com.koushik.javabrains.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 *
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/1/13
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserController extends ActionSupport implements ModelDriven{
   Logger logger = Logger.getLogger(UserController.class);
    private UserModel userModel = new UserModel();
    private List<UserEntity> userEntities;
    private List<UserModel> userModels;
    private UserService userService;
    @Override
    public UserModel getModel() {
        return getUserModel();
    }

    public UserModel getUserModel() {
        return userModel;
    }
     public void setModel(UserModel userModel){
        this.userModel = userModel;
    }
    public List<UserModel> getUserModels() {
        return userModels;
    }

    public void setUserModels(List<UserModel> userModels) {
        this.userModels = userModels;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String index() throws Exception {
//        setUserModels(userService.showAllUsers());
       setUserEntities(userService.showAllUsers());
       logger.info("In index method back");
       for (UserEntity userEntity : userEntities) {
                for (TweetEntity tweetEntity :userEntity.getTweetEntitiySet()){
                    logger.info(userEntity.getUserName() +":**********:"+tweetEntity.getTweet());
                }
            }
        return SUCCESS;
    }

    public String create(){
        return SUCCESS;
    }

     public String insert(){
         logger.info("insert() method called");
        getUserService().insert(userModel);
        return SUCCESS;
    }

    public String update(){
        getUserService().update(userModel);
        return SUCCESS;
    }

    public String processUpdate(){
        return SUCCESS;
    }

    public String delete(){
        getUserService().delete(userModel);
        return SUCCESS;
    }

    @Override
    public void validate(){
        if(getUserModel().getUserName() != null){
             if(getUserModel().getUserName().equals("chaitu")){
                addActionError("you should not add your name");
            } else {
                addActionMessage("valid details entered");
            }
        }

    }

/*    @Override
    public void setSession(Map<String, Object> stringObjectMap) {
        stringObjectMap
    }*/

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

}
