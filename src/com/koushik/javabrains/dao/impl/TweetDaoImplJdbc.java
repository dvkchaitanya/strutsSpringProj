package com.koushik.javabrains.dao.impl;

import com.koushik.javabrains.dao.TweetDao;
import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.model.TweetModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("tweetDaoJdbc")
public class TweetDaoImplJdbc implements TweetDao {
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = Logger.getLogger(TweetDaoImplJdbc.class);
    List<Map<String, Object>> tweetModelList;

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(TweetModel tweetModel){
        logger.debug("In insert method of tweetDaoImpl class");
        logger.debug(tweetModel.getTweet());
        getJdbcTemplate().update("insert into tweeets (tweetId, tweet) values (?,?)",
                             new Object[]{tweetModel.getTweetId(),tweetModel.getTweet()} );
    }

    @Override
    public List listTweets(){
        String sql ="select * from tweeets";
        logger.debug("sexy hi");
/*        List <TweetModel> tweetModels = new ArrayList<TweetModel>();
        List <Map<String, Object>> rows =  getJdbcTemplate().queryForList(sql,new TweetRowMapper());
        for (Map row : rows) {
            row.get("tweetId");
            TweetModel tm = new TweetModel();
            tm.setTweetId((Integer)row.get("tweetId"));
            tm.setTweet((String)row.get("tweet"));
            tweetModels.add(tm);
        }
        */
        return  getJdbcTemplate().query(sql,new BeanPropertyRowMapper(TweetModel.class));
    }

    @Override
    public void deleteTweet(TweetModel tweetModel) {
        int tweetId = tweetModel.getTweetId();
        String sql = "delete from tweeets where tweetId ="+tweetId;
        getJdbcTemplate().update(sql);
    }

    @Override
    public void updateTweet(TweetEntity tweetModel) {
        String tweet = tweetModel.getTweet();
        int tweetId = tweetModel.getTweetId();
        String sql = "update tweeets set tweet='"+tweet+"' where tweetId="+tweetId;
        logger.debug("obama");
        logger.debug(sql);
        getJdbcTemplate().update(sql);
    }
}
