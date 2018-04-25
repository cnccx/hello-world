package com.ztwl.service.impl;

import com.ztwl.common.utils.RabbitmqReceiver;
import com.ztwl.common.utils.RabbitmqSender;
import com.ztwl.rabbitmq.RabbitmqProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: parent-demo
 * @description: rabbit service
 * @author: zhangjiaxing
 * @create: 2018-03-02 15:12
 **/
@Service
public class RabbitmqServiceImpl implements RabbitmqReceiver {

    private Logger logger = LogManager.getLogger(this.getClass());
    @Autowired(required = false)
    private RabbitmqProperties rabbitmqProperties;

    @Autowired
    private RabbitmqSender rabbitmqSender;

    @Override
    public Boolean processMessage(byte[] body) {
        return false;
    }

    public void sendMessage(Object object) {
        rabbitmqSender.sendMessage(rabbitmqProperties.getExchange(), object.toString());
        logger.info("send message " + object.toString() + " to exchange: " + rabbitmqProperties.getExchange());
    }
}
