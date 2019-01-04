package com.zan.hup.mail.api.service;

import com.zan.hup.mail.api.dto.MailSenderInfoDto;

/**
 * @author hupeng on 2018/12/4
 * @version 1.0
 * @Description
 */
public interface MailService {

    void sendSimpleMail(MailSenderInfoDto mailSenderInfoDto);

    void sendHtmlMail(MailSenderInfoDto mailSenderInfoDto);

    void sendAttachmentsMail(MailSenderInfoDto mailSenderInfoDto);

    void sendInlineResourceMail(MailSenderInfoDto mailSenderInfoDto);

    void sendTemplateMail(MailSenderInfoDto mailSenderInfoDto);
}
