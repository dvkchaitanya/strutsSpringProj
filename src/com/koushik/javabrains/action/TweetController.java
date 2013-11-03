package com.koushik.javabrains.action;

import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.TweetModel;
import com.koushik.javabrains.service.TweetService;
import com.koushik.javabrains.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;


@Controller
public class TweetController extends ActionSupport implements ModelDriven{

    private static final Logger logger = Logger.getLogger(TweetController.class);
    private TweetService tweetService;
    private UserService userService;
    private List<TweetModel> tweetModels;
    private TweetModel tweetModel = new TweetModel();
    private Map session;
    private List<TweetEntity> tweetEntities;
    private List<UserEntity> userEntities;
    private String userSel;

    public void setTweetModel(TweetModel tweetModel) {
        this.tweetModel = tweetModel;
    }

    TweetModel getTweetModel() {
        return tweetModel;
    }

    @Override
    public TweetModel getModel() {
        return tweetModel;
    }

    public void setModel(TweetModel tweetModel){
        this.tweetModel = tweetModel;
    }
    public List<TweetModel> getTweetModels() {
        return tweetModels;
    }

    public void setTweetModels(List<TweetModel> tweetModels) {
        this.tweetModels = tweetModels;
    }

    TweetService getTweetService() {
        return tweetService;
    }

    @Autowired
    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String index() throws Exception {
       setTweetEntities(getTweetService().showAllTweets());
        return SUCCESS;
    }

    public String create(){
        populateUserNamesForDropDownList();

        return SUCCESS;
    }

     public String insert(){

        getTweetService().insert(tweetModel);
        return SUCCESS;
    }

    public String update(){
        getTweetService().update(tweetModel);
        return SUCCESS;
    }

    public String processUpdate(){
        return SUCCESS;
    }

    public String delete(){
        logger.info("In TweetController delete method");
        logger.info(tweetModel.getTweet());
        logger.info(tweetModel.getTweetId());
        getTweetService().delete(tweetModel);
        return SUCCESS;
    }

    @Override
    public void validate(){
        logger.debug("validate() method called");

        if(getTweetModel().getTweet() != null){
             if(getTweetModel().getTweet().equals("chaitu")){
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

    public void setTweetEntities(List<TweetEntity> tweetEntities) {
        this.tweetEntities = tweetEntities;
    }

    public List<TweetEntity> getTweetEntities() {
        return tweetEntities;
    }
    private void populateUserNamesForDropDownList(){
        logger.info("in populateUserNamesForDropDownList");
        setUserEntities(getUserService().showAllUsers()) ;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public String getUserSel() {
        return userSel;
    }

    public void setUserSel(String userSel) {
        this.userSel = userSel;
    }
}