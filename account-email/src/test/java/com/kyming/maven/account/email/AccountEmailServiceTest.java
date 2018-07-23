package com.kyming.maven.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

import static org.junit.Assert.assertEquals;

/**
 * @Author:longming
 * @Description:
 * @Date:Created in 11:11 2018/7/23
 * @Modified By:
 */
public class AccountEmailServiceTest {

    private GreenMail greenMail;

    @Before
    public  void startMailServer() throws Exception{
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("1653219895@qq.com","long2190019ming");
        greenMail.start();
    }

    @Test
    public void testSendMail()throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail("1653219895@qq.com",subject,htmlText);
        greenMail.waitForIncomingEmail(2000,1);
        Message [] msgs = greenMail.getReceivedMessages();
        assertEquals(1,msgs.length);
        assertEquals(subject,msgs[0].getSubject());
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void stopMailServer()throws Exception{
        greenMail.stop();
    }
}
