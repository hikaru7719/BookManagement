package utilities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public void Mail(int num,String book_name,String address) throws IOException {

		Properties objPrp=new Properties();
	    objPrp.put("mail.smtp.host","sapphire.u-gakugei.ac.jp"); // SMTPサーバ名
	    objPrp.put("mail.host","sapphire.u-gakugei.ac.jp"); // 接続するホスト名
	    // メールセッションを確立
	    Session session=Session.getDefaultInstance(objPrp,null);
	    // 送信メッセージを生成
	    MimeMessage objMsg=new MimeMessage(session);
	    try {
	    // 送信先（TOのほか、CCやBCCも設定可能）
	      objMsg.setRecipients(Message.RecipientType.TO,"hazelab@sapphire.u-gakugei.ac.jp");
	    // Fromヘッダ
	      InternetAddress objFrm=new InternetAddress("Shu@sapphire.u-gakugei.ac.jp","技ゼミ管理システム");

	      objMsg.setFrom(objFrm);

		// 件名
		objMsg.setSubject("お知らせ","ISO-2022-JP");//ISO-2022-JPはエンコード
		String text = "こんにちは。\n現在借りられている"+ book_name + "の貸し出し予約がされました。\n読み終わったら返却よろしくお願いします。";
		// 本文
		objMsg.setText(text);
		Transport.send(objMsg);

		System.out.println("メール送信完了しました！");

		} catch (UnsupportedEncodingException e) {

		e.printStackTrace();

		} catch (MessagingException e) {

		e.printStackTrace();

		}

		}
}
