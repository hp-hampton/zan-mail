package com.zan.hup.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hupeng on 2018/12/3
 * @version 1.0
 * @Description
 */
@RestController
@RequestMapping("/api/mail")
@Slf4j
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1959719812@qq.com");
        message.setTo("1959719812@qq.com");
        message.setSubject("kong");
        message.setText("kong");
        message.copyTo(message);
        try {
            mailSender.send(message);
            log.info("简单邮件已经发送。");
        } catch (Exception e) {
            log.error("发送简单邮件时发生异常！", e);
        }
    }
}
