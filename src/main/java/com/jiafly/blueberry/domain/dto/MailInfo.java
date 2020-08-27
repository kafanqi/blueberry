package com.jiafly.blueberry.domain.dto;

/**
 * 邮箱信息
 *
 * @author liuyi
 */
public class MailInfo {
    /**
     * 收件人
     */
    private String to;
    /**
     * 发送主题
     */
    private String subject;
    /**
     * 发送内容
     */
    private String content;
    /**
     * 附件地址
     */
    private String filePath;

    public MailInfo() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
