package com.kyming.maven.account.persist;

/**
 * @Author:longming
 * @Description:account-persist模块对外提供的服务，对应账户的增删改查
 * @Date:Created in 15:21 2018/7/26
 * @Modified By:
 */
public interface AccountPersistService {

    Account creaateAccount(Account account)throws AccountPersistException;
    Account readAccount(String id)throws  AccountPersistException;
    Account updateAccount(Account account)throws AccountPersistException;
    void deleteAccount(String id)throws AccountPersistException;
}
