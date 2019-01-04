package com.zan.hup.mail.api.service.impl;

import com.zan.hup.file.FileClient;
import com.zan.hup.mail.api.dto.MailSenderInfoDto;
import com.zan.hup.mail.api.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author hupeng on 2018/12/4
 * @version 1.0
 * @Description
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    private MimeMessage message;

    private JavaMailSender mailSender;

    @Autowired
    private FileClient fileClient;

    @Override
    public void sendSimpleMail(MailSenderInfoDto mailSenderInfoDto) {

    }

    @Override
    public void sendHtmlMail(MailSenderInfoDto mailSenderInfoDto) {
        try {
            this.buildMimeMessageHelper(mailSenderInfoDto.getFrom(), mailSenderInfoDto.getTo(), mailSenderInfoDto.getSubject(), mailSenderInfoDto.getText());
            log.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送带附件的邮件时发生异常！", e);
        }
        mailSender.send(message);
    }

    @Override
    public void sendAttachmentsMail(MailSenderInfoDto mailSenderInfoDto) {

        try {
            MimeMessageHelper mimeMessageHelper = this.buildMimeMessageHelper(mailSenderInfoDto.getFrom(), mailSenderInfoDto.getTo(), mailSenderInfoDto.getSubject(), mailSenderInfoDto.getText());
            mailSender.send(message);
            //mimeMessageHelper.addAttachment();
            log.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送带附件的邮件时发生异常！", e);
        }
    }

    @Override
    public void sendInlineResourceMail(MailSenderInfoDto mailSenderInfoDto) {

    }

    @Override
    public void sendTemplateMail(MailSenderInfoDto mailSenderInfoDto) {

    }

    @Bean
    private void createMimeMessage(JavaMailSender mailSender) {
        this.message = mailSender.createMimeMessage();
        this.mailSender = mailSender;
    }

    private MimeMessageHelper buildMimeMessageHelper(String from, String[] to, String subject, String text) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        return helper;
    }
}
