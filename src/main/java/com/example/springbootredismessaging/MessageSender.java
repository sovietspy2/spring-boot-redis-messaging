package com.example.springbootredismessaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MessageSender {

    @Autowired
    private StringRedisTemplate template;

    @Scheduled(fixedRate = 5000)
    private void sendMessage() {
        template.convertAndSend("chat", "Hell there "+new Date());
    }


}
