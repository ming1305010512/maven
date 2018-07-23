package com.kyming.maven.account.email;

/**
 * @Author:longming
 * @Description:
 * @Date:Created in 10:02 2018/7/23
 * @Modified By:
 */
public interface AccountEmailService {

    /**
     *
     * @param to 接收地址
     * @param subject 邮件主题
     * @param htmlText 邮件内容
     * @throws Exception
     */
    void sendMail(String to,String subject,String htmlText)throws Exception;
}
