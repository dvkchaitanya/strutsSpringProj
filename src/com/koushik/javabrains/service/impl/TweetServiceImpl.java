package com.koushik.javabrains.service.impl;

import com.koushik.javabrains.dao.TweetDao;
import com.koushik.javabrains.model.TweetModel;
import com.koushik.javabrains.service.TweetService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class TweetServiceImpl implements TweetService {
    public int tweetServiceInt = 2;

    private static final Logger logger = Logger.getLogger(TweetServiceImpl.class);
    TweetDao tweetDao;

    @Override
    public TweetDao getTweetDao() {
        return tweetDao;
    }

    @Override
    public void setTweetDao(TweetDao tweetDao) {
        this.tweetDao = tweetDao;
    }

    @Override
    public void insert(TweetModel tweetModel){
        getTweetDao().insert(tweetModel);
    }

    @Override
    public List<TweetModel> showAllTweets() throws Exception{
          logger.debug("In service class  showAllTweets");
        List<TweetModel> tweetModelList = null;
        try{
              tweetModelList= getTweetDao().listTweets();
        }
        catch (Exception e){
            logger.debug(e);
        }
          return tweetModelList;
    }

    @Override
    public void delete(TweetModel tweetModel) {
        getTweetDao().deleteTweet(tweetModel);
    }

    @Override
    public void update(TweetModel tweetModel) {
        getTweetDao().updateTweet(tweetModel);
    }
}











