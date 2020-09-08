package com.jiafly.blueberry.common.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * 邮件工具类
 *
 * @author liuyi
 */
@Component
public class MailUtils {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public MailUtils(TemplateEngine templateEngine, JavaMailSender mailSender) {
        this.templateEngine = templateEngine;
        this.mailSender = mailSender;
    }

    /**
     * 发送普通邮件
     *
     * @param from    from
     * @param to      to
     * @param subject subject
     * @param content content
     */
    public void sendSimpleMail(String from, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * 发送html邮件
     *
     * @param from    from
     * @param to      to
     * @param subject subject
     * @param content content
     * @throws Exception e
     */
    public void sendHtmlMail(String from, String to, String subject, String content) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    /**
     * 发送模板邮件
     *
     * @param from         from
     * @param to           to
     * @param subject      subject
     * @param templateName templateName
     * @param contentMap   contentMap
     * @throws Exception e
     */
    public void sendTemplateMail(String from, String to, String subject, String templateName, Map<String, Object> contentMap) {
        try {
            Context context = new Context();
            context.setVariables(contentMap);
            String mailTemplate = templateEngine.process(templateName, context);
            sendHtmlMail(from, to, subject, mailTemplate);
        } catch (Exception exception) {

        }
    }

    /**
     * 发送附件邮件
     *
     * @param from     from
     * @param to       to
     * @param subject  subject
     * @param content  content
     * @param filePath filePath
     * @throws Exception e
     */
    public void sendAttachmentsMail(String from, String to, String subject, String content, String filePath) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        //要带附件第二个参数设为true
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }
}
