package com.kyming.maven.account.persist;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * @Author:longming
 * @Description:
 * @Date:Created in 15:28 2018/7/26
 * @Modified By:
 */
public class AccountPersistServiceImpl implements AccountPersistService {


    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    private SAXReader reader = new SAXReader();

    private Document readDocument()throws AccountPersistException{

        File dataFile = new File(file);
        if (!dataFile.exists()){
            dataFile.getParentFile().mkdirs();
            Document doc = DocumentFactory.getInstance().createDocument();
            Element rootEle = doc.getRootElement();
            rootEle.addElement("amounts");
            writeDocument(doc);
        }
        try {
            return reader.read(new File(file));
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new AccountPersistException();
        }
    }

    private void writeDocument(Document document)throws AccountPersistException{
        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
            XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
            writer.write(document);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccountPersistException();
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new AccountPersistException();
                }
            }
        }
    }

    public Account creaateAccount(Account account) throws AccountPersistException {
        return null;
    }

    /**
     *
     * @param id
     * @return
     * @throws AccountPersistException
     *
     *
     * 对应的XML文件为：
     *  <?xml version="1.o" encoding="utf-8"?>
            <account-persist>
                <accounts>
                    <account>
                        <id>juven</id>
                        <name>JuvenXu</name>
                        <email>juven@ changeme.com</email>
                        <password>this_should_ be_encrypted&lt; /password &gt;
                        <activated>false</activated>&lt; /accounts &gt;</password>
                    </account>
                </accounts>
            </account-persist>
     */

    public Account readAccount(String id) throws AccountPersistException {
        Document document = readDocument();
        Element accountsEle = document.getRootElement().element("amounts");
        for (Element accountEle : (List<Element>) accountsEle.elements()){
            if (accountEle.elementText("id").equals(id)){
                return buildAccount(accountEle);
            }
        }
        return null;
    }

    private Account buildAccount(Element element){
        Account account = new Account();
        account.setId(element.elementText("id"));
        account.setName(element.elementText("name"));
        account.setEmail(element.elementText("email"));
        account.setPassword(element.elementText("password"));
        account.setActivated("true".equals(element.elementText("activated"))?true:false);
        return  account;
    }

    public Account updateAccount(Account account) throws AccountPersistException {
        return null;
    }

    public void deleteAccount(String id) throws AccountPersistException {

    }
}
