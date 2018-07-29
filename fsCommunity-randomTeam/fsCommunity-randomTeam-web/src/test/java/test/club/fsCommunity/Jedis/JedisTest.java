package test.club.fsCommunity.Jedis;

import java.util.Random;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.common.utils.RedisKeyUtil;
import club.fsCommunity.jedis.JedisAdapter;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.service.EnrollService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-jedis.xml",
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	
	JedisAdapter jedisAdapter = (JedisAdapter) ac.getBean("jedisAdapter");
	
	@Test
	public void testJedisPool() {
		JedisPool pool = (JedisPool)ac.getBean("jedisPool");
		Jedis jedis = null;
		try {
			jedis = pool.getResource();

			jedis.set("name", "lisi");
			String name = jedis.get("name");
			System.out.println(name);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (jedis != null) {
				// 关闭连接
				jedis.close(); // pool 由 spring 来管理，不用 手动关闭
			}
		}
	}
	
	@Test
	public void testSortedSets(){
		
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			int score = random.nextInt();
			jedisAdapter.zadd("testSortedSets1", score, "test"+i);
			System.out.println("test"+i+"_score:"+score);
		}
		
		Set<String> set = jedisAdapter.zrange("testSortedSets1", 0, -1);
		
		for (String str : set) {
			System.out.println("str:" + str);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
