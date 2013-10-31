package com.koushik.javabrains.service.impl;

import com.koushik.javabrains.dao.TweetDao;
import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.model.TweetModel;
import com.koushik.javabrains.service.TweetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("tweetService")
@Transactional
public class TweetServiceImpl implements TweetService {
    public int tweetServiceInt = 2;

    private static final Logger logger = Logger.getLogger(TweetServiceImpl.class);
    private TweetDao tweetDao;

    @Override
    public TweetDao getTweetDao() {
        return tweetDao;
    }

    @Override
    @Autowired
    public void setTweetDao(TweetDao tweetDao) {
        this.tweetDao = tweetDao;
    }

    @Override
//    @Transactional
    public void insert(TweetModel tweetModel){
        getTweetDao().insert(tweetModel);
    }

    @Override
//    @Transactional
    public List<TweetEntity> showAllTweets() {
          logger.info("In service class  showAllTweets sexy");
        List<TweetEntity> tweetEntityList = null;
        try{
//              tweetModelList= getTweetDao().listTweets();
                tweetEntityList = getTweetDao().listTweets();
/*            logger.debug("after method called from service class");
                for (TweetEntity tweetEntity : tweetEntityList) {
                   logger.debug(tweetEntity.toString());
                    logger.debug(tweetEntity.getTweet());
                    logger.debug(tweetEntity.getTweetId());
                    logger.debug("In for loop");
                }*/
        }
        catch (Exception e){
            logger.debug(e);
        }
          return tweetEntityList ;
    }

    @Override
    @Transactional
    public void delete(TweetModel tweetModel) {
        logger.info("in delete method of TweetServiceImpl "+tweetModel.getTweetId());
        getTweetDao().deleteTweet(tweetModel);
    }

    @Override
//    @Transactional
    public void update(TweetModel tweetModel) {
        TweetEntity tweetEntity =new TweetEntity();
        tweetEntity.setTweetId(tweetModel.getTweetId());
        tweetEntity.setTweet(tweetModel.getTweet());
        getTweetDao().updateTweet(tweetEntity);
    }
}











