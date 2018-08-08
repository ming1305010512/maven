package com.kyming.maven.account.persist;

/**
 * @Author:longming
 * @Description:定义了账户的简单模型
 * @Date:Created in 15:19 2018/7/26
 * @Modified By:
 */
public class Account {

    private String id;
    private String name;
    private String email;
    private String password;
    private boolean activated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                '}';
    }
}
