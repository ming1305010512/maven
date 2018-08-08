package com.kyming.maven.account;

import com.kyming.maven.account.persist.Account;
import com.kyming.maven.account.persist.AccountPersistService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * @Author:longming
 * @Description:
 * @Date:Created in 20:54 2018/7/26
 * @Modified By:
 */
public class AccountPersistServiceTest {

    private AccountPersistService service;

    @Before
    public void prepare() throws Exception{
        File file = new File("target/test-classes/persist-data.xml");
        if (file.exists()){
            file.delete();
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("account-persist.xml");
        service = (AccountPersistService) context.getBean("accountPersistService");
    }

    @Test
    public void testReadAccount() throws Exception{
//        Account account = service.readAccount("juven");
//        System.out.println(account);
        System.out.println("我是account-persist模块");
    }
}
