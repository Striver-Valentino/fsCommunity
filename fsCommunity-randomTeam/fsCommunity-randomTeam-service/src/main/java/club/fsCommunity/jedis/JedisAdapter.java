package club.fsCommunity.jedis;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Service("jedisAdapter")
public class JedisAdapter {

	@Autowired
	private JedisPool pool; 
	
	
	
	
	public void setObject(String key,Object obj){
		set(key,JSON.toJSONString(obj)); 
	}
	
	public <T> T getObject(String key,Class<T> clazz){
		String value = get(key); 
		
		if(value != null){
			return JSON.parseObject(value,clazz);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	public long sadd(String key,String value){
		Jedis jedis = null;
		
		try {
			jedis = pool.getResource(); 
			return jedis.sadd(key, value);  
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if(jedis != null){
				jedis.close();  
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
                jedis.close();
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
                jedis.close();
            }
        }
    }

    public long scard(String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.scard(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        } finally {
            if(jedis != null){
                jedis.close(); 
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
            jedis.set(key, value); 
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
    
    public String spop(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.spop(key);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
    
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
