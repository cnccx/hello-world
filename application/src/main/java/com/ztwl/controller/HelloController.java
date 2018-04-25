package com.ztwl.controller;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.ztwl.common.exception.MyException;
import com.ztwl.exception.MyResultEnum;
import com.ztwl.model.BoyVo;
import com.ztwl.service.impl.RabbitmqServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Log4j2
class HelloController {
    @Autowired
    private ProducerBean producerBean;

    @Autowired
    RabbitmqServiceImpl rabbitmqServiceImpl;

    @RequestMapping("/exception")
    public String exception() throws MyException {
        BoyVo boyVo = new BoyVo();
        boyVo.setName("wang");
        throw new MyException(MyResultEnum.BOY_AGE_ERROR, boyVo);
    }

    @RequestMapping("/hello")
    public String hello() {
        log.info("hello------");
        return "hello world";
    }

    @RequestMapping("/rabbitmq")
    public String testRabbitmq() {
        rabbitmqServiceImpl.sendMessage("test_rabbitmq");
        return "success";
    }

    @RequestMapping("/ons")
    public Object helloOns() {
        Message message = new Message();
        message.setTopic("schoolFeeds_debug");
        message.setBody("haha".getBytes());
        producerBean.sendAsync(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(sendResult.toString());
            }

            @Override
            public void onException(OnExceptionContext onExceptionContext) {
                log.info(onExceptionContext.toString());
            }
        });
        return producerBean.getProperties();
    }
}