package CodeForFuture.AutoCode.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;


/**
 * @author AutoCode
 *获取redis的连接
 */
public class RedisUtils {
	
	@Autowired
	private static RedisConnectionFactory rcf;
	
	public static RedisConnection  getMasterRedisConnection() {
		
		System.out.println(rcf);
		
		RedisConnection rc = rcf.getConnection();
		return rc;
		
	}   
	
	
}
