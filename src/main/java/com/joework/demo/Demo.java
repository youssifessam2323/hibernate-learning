package com.joework.demo;

import com.joework.demo.config.AppConfig;
import com.joework.demo.dao.SingerDao;
import com.joework.demo.models.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class Demo {

    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        Singer singer = singerDao.findById(2l);
        singerDao.delete(singer);
        listSingers(singerDao.findAll());
        ctx.close();

    }

    private static void listSingers(List<Singer> singers) {
        logger.info(" ---- Listing singers:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }
}