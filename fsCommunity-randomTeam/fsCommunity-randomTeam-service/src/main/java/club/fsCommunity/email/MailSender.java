package club.fsCommunity.email;

import java.util.Map;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.apache.velocity.app.*;
import org.apache.velocity.exception.VelocityException;

import club.fsCommunity.service.CodeKeysService;


@Service
public class MailSender implements InitializingBean {

	@Autowired
	private CodeKeysService codeKeysService;
	
	
	
	private JavaMailSenderImpl mailSender;

	
	@Override
	public void afterPropertiesSet() throws Exception {
		mailSender = new JavaMailSenderImpl();
		
        mailSender.setUsername(codeKeysService.getSystemEmail());
        mailSender.setPassword(codeKeysService.getSystemEmailPwd());

        mailSender.setHost("smtp.qq.com"); 
        mailSender.setPort(465);
        mailSender.setProtocol("smtps"); 
        mailSender.setDefaultEncoding("utf8");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.ssl.enable",true);
        mailSender.setJavaMailProperties(javaMailProperties);
		
	}
	
	
	
	
	public boolean sendWithHTMLTemplate(String to, 
			                            String subject, 
			                            String template, 
			                            Map<String,Object> model){ 
		
		try {
			String nick = MimeUtility.encodeText("fs社区");
			InternetAddress from = new InternetAddress(nick + "<3540846483@qq.com>");

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);


			String result = template;
			mimeMessageHelper.setTo(to); 
			mimeMessageHelper.setFrom(from); 
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(result,true); 

			mailSender.send(mimeMessage);

			System.out.println("邮件已发送");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
		
}
