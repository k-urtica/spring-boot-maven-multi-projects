package common.com.example.cache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	/** Redis接続プロパティ */
	private final RedisProperty property;

	@Autowired
	public RedisConfig(RedisProperty property) {
		this.property = property;
	}

	/**
	 * Redis接続コネクションファクトリーオブジェクトを生成する
	 *
	 * @return {@link LettuceConnectionFactory} オブジェクト
	 */
	@Bean
	public RedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName(property.getHost());
		configuration.setPort(property.getPort());
		return new LettuceConnectionFactory(configuration);
	}

	/**
	 * カスタムRedisTemplateオブジェクトを生成する
	 *
	 * @param 接続コネクションファクトリー
	 * @return
	 */
	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
		template.setConnectionFactory(cf);

		return template;
	}
}
