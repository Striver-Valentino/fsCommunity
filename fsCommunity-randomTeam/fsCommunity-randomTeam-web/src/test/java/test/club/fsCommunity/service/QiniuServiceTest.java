package test.club.fsCommunity.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import club.fsCommunity.service.CloudService;
import club.fsCommunity.service.GameService;
import club.fsCommunity.service.impl.QiniuServiceImpl;

public class QiniuServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-jedis.xml",
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	
	CloudService cloudService = (CloudService) ac.getBean("CloudService");
	
	@Test
	public void TestSaveImage(){
		
		String result = null;
		try {
			File file = new File("G:/JAVA/AProject/fsCommunity/01.jpg");
			FileInputStream in_file = new FileInputStream(file);
			
			// 转 MultipartFile ；MockMultipartFile 依赖 spring-test
			MultipartFile multi = new MockMultipartFile(file.getName(), in_file);
			
			System.out.println(multi.getName());
			
			result = cloudService.saveImage(multi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("测试上传结果：" + result);
		
	}
}
