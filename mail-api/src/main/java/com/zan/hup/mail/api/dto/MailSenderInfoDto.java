package com.zan.hup.mail.api.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hupeng on 2018/12/3
 * @version 1.0
 * @Description
 */
@Data
public class MailSenderInfoDto implements Serializable {

    /**
     * 发件人
     */
    @Nullable
    private String from;

    /**
     *
     */
    @Nullable
    private String replyTo;

    /**
     * 收件人
     */
    @Nullable
    private String[] to;

    /**
     * 抄送地址
     */
    @Nullable
    private String[] cc;

    /**
     * 密送地址
     */
    @Nullable
    private String[] bcc;

    @Nullable
    private Date sentDate;

    /**
     * 主题
     */
    @Nullable
    private String subject;

    /**
     * 内容
     */
    @Nullable
    private String text;

    /**
     * 附件ID
     */
    private String id;
}
