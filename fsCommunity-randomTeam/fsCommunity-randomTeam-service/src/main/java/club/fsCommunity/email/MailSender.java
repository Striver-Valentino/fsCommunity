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

/**
 * 发送邮件 工具类
 * @author Administrator
 *
 */
@Service
public class MailSender implements InitializingBean {

	@Autowired
	private CodeKeysService codeKeysService;
	
	/*@Autowired
	private VelocityEngine velocityEngine;*/
	
	private JavaMailSenderImpl mailSender;

	/**
	 * MailSender 初始化时，设置好 邮件 参数
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		mailSender = new JavaMailSenderImpl();
		
		// 邮箱和密码
        mailSender.setUsername(codeKeysService.getSystemEmail());
        mailSender.setPassword(codeKeysService.getSystemEmailPwd());

        mailSender.setHost("smtp.qq.com"); // qq 个人邮箱 的 发送服务器；qq 企业邮箱 的 发送服务器："smtp.exmail.qq.com"
        mailSender.setPort(465);
        mailSender.setProtocol("smtps"); // smtp 加上 s 结尾 ，就是 SSL
        mailSender.setDefaultEncoding("utf8");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.ssl.enable",true);
        mailSender.setJavaMailProperties(javaMailProperties);
		
	}
	
	
	
	/**
	 * 发送邮件，以 html 格式 发送
	 * @param to
	 * @param subject
	 * @param template
	 * @param model
	 * @return
	 */
	public boolean sendWithHTMLTemplate(String to, // 目标邮箱，即 接收者 邮箱
			                            String subject, // 邮件 标题
			                            String template, // 要用来 渲染 的 模板 的 路径
			                            Map<String,Object> model){   // Map<String,Object> 保存 要 传到 Velocity 模板 的 参数
		
		try {
			// 发件人 昵称
			String nick = MimeUtility.encodeText("fs社区");
			// 发件人信息
			InternetAddress from = new InternetAddress(nick + "<3540846483@qq.com>"); // 这个格式 是 显示到 页面 的 格式

			//构造一封邮件，MimeMessage 多媒体 信息 邮件
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			// mimeMessageHelper 用来 辅助 构建 mimeMessage
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

			/**
			 * 要发 邮件，邮件内容 一般 是 不固定的，
			 * 可以 准备 一个模板，不同的邮件，只需要 替换 几个 词 即可。
			 * 可以借助 Velocity 模板。
			 */
			// 利用 Velocity引擎 渲染 一个 自定义模板
			// 这样，每个 收件人 收到的 邮件 都不一样（格式一样，内容不同），并且 不会 被 邮件系统认为是 垃圾邮件（如果 给每个人 发一样的邮件，就会被 认为是 垃圾邮件）
			//String result = VelocityEngineUtils
			        //.mergeTemplateIntoString(velocityEngine,template,"UTF-8",model); // 注意，这里的 model是 Map，不是 Model model，但是 这个 Map 也可以把数据 带到 velocity，并不是因为 Map 本身就可以 把数据 带到 velocity，
			                                                                         // 而是 ，VelocityEngineUtils.mergeTemplateIntoString() 方法 底层 对 Map 中的数据做了一系列处理，让表面上看起来 Map 可以把数据 带到 velocity。

			String result = template;
			mimeMessageHelper.setTo(to); // 接收者
			mimeMessageHelper.setFrom(from); // 发送者
			mimeMessageHelper.setSubject(subject); // 主题
			mimeMessageHelper.setText(result,true); // 发送内容，就是上面 渲染好 的 自定义模板内容

			mailSender.send(mimeMessage); // 发邮件

			System.out.println("邮件已发送");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
		
}
