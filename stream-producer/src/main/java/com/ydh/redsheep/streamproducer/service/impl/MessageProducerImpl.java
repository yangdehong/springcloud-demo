package com.ydh.redsheep.streamproducer.service.impl;

import com.ydh.redsheep.streamproducer.service.MessageProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

// Source.class里面就是对输出通道的定义（这是Spring Cloud Stream内置的通道封装）
@EnableBinding(Source.class)
public class MessageProducerImpl implements MessageProducer {

    // 将MessageChannel的封装对象Source注入到这里使用
    @Resource
    private Source source;

    @Override
    public void sendMessage(String content) {
        // 向mq中发送消息（并不是直接操作mq，应该操作的是spring cloud stream）
        // 使用通道向外发出消息(指的是Source里面的output通道)
        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
