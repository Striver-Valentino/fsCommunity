package test.club.fsCommunity.initData;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import club.fsCommunity.common.utils.EncryptionUtil;
import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.mapper.CodekeysMapper;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Codekeys;
import club.fsCommunity.pojo.CodekeysExample;
import club.fsCommunity.service.GameService;

/**
 * 初始化所有的key，后续也可以继续插入；全部都放到数据库的codeKeys表
 * @author Administrator
 *
 */
public class initCodeKeys {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	
	CodekeysMapper codekeysMapper = (CodekeysMapper) ac.getBean("codekeysMapper");

	@Test
	public void initKeys(){
		
		String encodeRules = "fsCommunitycc41209";
		
		// 七牛云 accessKey
		Codekeys codekeys1 = new Codekeys();
		codekeys1.setId(randomNumberUtil.generateCodekeysID());
		codekeys1.setName("qiniuAK");
		codekeys1.setValue(EncryptionUtil.AESEncode(encodeRules, "2NRHRODNIiuMuRfM9aRCNRF5yGjuwk9piZ458VMI"));
		codekeys1.setRules(encodeRules);
		codekeysMapper.insert(codekeys1);
		
		// 七牛云 secretKey
		Codekeys codekeys2 = new Codekeys();
		codekeys2.setId(randomNumberUtil.generateCodekeysID());
		codekeys2.setName("qiniuSK");
		codekeys2.setValue(EncryptionUtil.AESEncode(encodeRules, "BEk00p4fj6rOoihOuZ98gcaCJeymDO37gjrfrtX-"));
		codekeys2.setRules(encodeRules);
		codekeysMapper.insert(codekeys2);
		
		
		// 系统邮箱账号
		Codekeys codekeys3 = new Codekeys();
		codekeys3.setId(randomNumberUtil.generateCodekeysID());
		codekeys3.setName("systemEmail");
		codekeys3.setValue(EncryptionUtil.AESEncode(encodeRules, "3540846483@qq.com"));
		codekeys3.setRules(encodeRules);
		codekeysMapper.insert(codekeys3);
		
		// 系统邮箱密码
		Codekeys codekeys4 = new Codekeys();
		codekeys4.setId(randomNumberUtil.generateCodekeysID());
		codekeys4.setName("systemEmailPwd");
		codekeys4.setValue(EncryptionUtil.AESEncode(encodeRules, "sldsektoqwardbhj"));
		codekeys4.setRules(encodeRules);
		codekeysMapper.insert(codekeys4);
		
		System.out.println("所有Codekeys初始化完成");
		
	}
	
}
