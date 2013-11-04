package com.Chat.Logic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/10/20
 * Time: 17:33
 * To change this template use File | Settings | File Templates.
 */
class MailLogic extends Authenticator {
    final String username = "dev.miyamoto.s";
    final String password = "65887987";
    final String from_name = "送信者名";

    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    Session session = null;
    MimeMessage mimeMessage = null;
    String charset = "UTF8";
    String sendTo = null;
    String title = null;
    String contents = null;

    public MailLogic() {
    }

//    public MailLogic(String charset) {
//        this.charset = charset;
//    }

    boolean isConnected() {
        return session != null;
    }

    public boolean hasMessage() {
        return mimeMessage != null;
    }

    public boolean hasDestination() {
        return sendTo != null;
    }

    public boolean hasTitle() {
        return title != null;
    }

    public boolean hasText() {
        return contents != null;
    }

    void connect() {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public void create_mail() {
        if (!isConnected()) connect();
        if (hasMessage()) return;
        mimeMessage = new MimeMessage(session);
        try {
// 送信元メールアドレスと送信者名を指定
            mimeMessage.setFrom(new InternetAddress(username + "@gmail.com", from_name, charset));
// メールの形式を指定
            mimeMessage.setHeader("Content-Type", "text/html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendTo(String mail_addr) {
        this.sendTo = mail_addr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.contents = text;
    }

    public boolean send() {
        if (hasMessage() && hasDestination() && hasText() && hasTitle()) {
            try {
                mimeMessage.setRecipients(Message.RecipientType.TO, sendTo);
                mimeMessage.setSubject(title, charset);
                mimeMessage.setText(contents, charset);
// 送信日付を指定
                mimeMessage.setSentDate(new Date());
                Transport.send(mimeMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;

        } else return false;
    }
}
