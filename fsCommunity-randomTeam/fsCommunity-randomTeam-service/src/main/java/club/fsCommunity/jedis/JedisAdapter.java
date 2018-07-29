package club.fsCommunity.jedis;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 用 Jedis 操作 redis 的 类
 * @author Administrator
 *
 */
@Service("jedisAdapter")
public class JedisAdapter {

	@Autowired
	private JedisPool pool; // JedisPool 已经在  /spring/applicationContext-jedis.xml 里 初始化
	
	
	/**
	 * Jedis 的 help 函数，在 异步 队列 里 会用到
	 */
	
	// 保存 对象（可以理解为 把 对象 缓存 到 redis 中）
	public void setObject(String key,Object obj){ // redis 的 set 也可以 保存 一个对象（对象需要 序列化，即 转化为 json）
		// 序列化
		// 这个 set() 方法 是 封装了  Jedis.set()
		set(key,JSON.toJSONString(obj)); // json 其实 就是 一种 String
	}
	
	// 取出 对象
	public <T> T getObject(String key,Class<T> clazz){
		String value = get(key); // 取出的是 json // 这个 get() 方法 是 封装了  Jedis.get()
		
		if(value != null){
			// 把 json 重新 解析 成 对象（根据 clazz 可以 知道 对象的 类型）
            // 反序列化
			return JSON.parseObject(value,clazz);
		}
		return null;
	}
	
	
	
	
	
	
	/**
	 * 以下 进一步  封装  Jedis 的各种方法。
	 */
	
	public long sadd(String key,String value){
		Jedis jedis = null;
		
		try {
			jedis = pool.getResource(); // 因为现在用的是 Jedis池 的概念，所以 jedis.sadd() 不要 直接用，而是 封装 一个方法 再用。
			return jedis.sadd(key, value);  // jedis 的 set，sadd() 方法 执行后 返回的是 所操作集合 的 元素 总数
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if(jedis != null){
				jedis.close();  // 如果不关闭，默认情况下，最多 只能 8个用户 使用。
				                // pool 由 spring 来管理，不用 手动关闭
			}
		}
	}
	
	public long srem(String key,String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.srem(key,value);
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        } finally {
            if(jedis != null){
                jedis.close(); // 如果不关闭，最多 只能 8个用户 使用。
            }
        }
    }

    public boolean sismember(String key,String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sismember(key,value);
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        } finally {
            if(jedis != null){
                jedis.close(); // 如果不关闭，最多 只能 8个用户 使用。
            }
        }
    }

    public long scard(String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.scard(key); // 返回集合 key 的基数(集合中元素的数量)。
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        } finally {
            if(jedis != null){
                jedis.close(); // 如果不关闭，最多 只能 8个用户 使用。
            }
        }
    }


    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value); // set 命令 不是 设置 list，而是 设置 String ，这是 redis 五大数据类型 里 最简单的类型。
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
	
	
	
    
    
    public long lpush(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpush(key, value);
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public List<String> brpop(int timeout, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            // brpop 是 rpop的block版本，即当timeout为0时，若遇到名称为key i的list不存在或该list为空，则命令结束（但不会退出，而是一直等待）。如果 timeout>0，则遇到上述情况时，等待timeout秒，如果问题没有解决，则对key i+1开始的list执行pop操作。
            // 假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。
            // 反之，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
            return jedis.brpop(timeout, key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
	
    
    
    
    
    
    // 添加到 Sorted Sets
    public long zadd(String key,Integer score,String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zadd(key, score, value);
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    // 返回有序集  Sorted Sets 指定的 key 中，指定区间内的成员。其中成员的位置按 score 值递增(从小到大)来排序。具有相同 score 值的成员按字典序(lexicographical order )来排列。
    // 区间是    0 ~ -1 显示整个有序集成员
    public Set<String> zrange(String key,Integer start,Integer end) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zrange(key, start, end);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    // 统计 Sorted Sets 元素个数
    public Long zcard(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zcard(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    //从list右边弹出
    public String rpop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.rpop(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    //从list左边弹出
    public String lpop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpop(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    // 统计 list 元素个数
    public Long llen(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.llen(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    // 从 右边 插入 list 中
    public long rpush(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.rpush(key, value);
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    // 从set弹出一个元素
    public String spop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.spop(key); // 移除并返回集合中的一个    随机   元素。
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    /**
     * 删除给定的一个或多个 key 。不存在的 key 会被忽略。
     * @param key
     * @return    返回  被删除 key 的数量。
     */
    public Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.del(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    /**
     * 检查给定 key 是否存在。
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
	
}
