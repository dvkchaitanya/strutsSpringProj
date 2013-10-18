package com.koushik.javabrains.action;

import com.koushik.javabrains.model.TweetModel;
import com.koushik.javabrains.service.TweetService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class TweetController extends ActionSupport implements ModelDriven{

    Logger logger = Logger.getLogger(TweetController.class);
    private TweetService tweetService;
    private List<TweetModel> tweetModels;
    private TweetModel tweetModel = new TweetModel();
    private Map session;
    public void setTweetModel(TweetModel tweetModel) {
        this.tweetModel = tweetModel;
    }

    public TweetModel getTweetModel() {
        return tweetModel;
    }

    @Override
    public TweetModel getModel() {
        return tweetModel;
    }

    /*public void setModel(TweetModel tweetModel){
        this.tweetModel = tweetModel;
    }*/
    public List<TweetModel> getTweetModels() {
        return tweetModels;
    }

    public void setTweetModels(List<TweetModel> tweetModels) {
        this.tweetModels = tweetModels;
    }

    public TweetService getTweetService() {
        return tweetService;
    }

    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }
   public String index() throws Exception {
        setTweetModels(tweetService.showAllTweets());;
        return SUCCESS;
    }

    public String create(){
        return SUCCESS;
    }

     public String insert(){
         logger.debug("insert() method called");
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
}