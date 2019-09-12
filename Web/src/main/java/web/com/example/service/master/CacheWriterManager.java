package web.com.example.service.master;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import common.com.example.cache.CacheWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CacheWriterManager {

	/** キャッシュ実行クラスのビーン */
	private final Map<String, CacheWriter> cacheWriter;

	public CacheWriterManager(Map<String, CacheWriter> cacheWriter) {
		this.cacheWriter = cacheWriter;
	}

	@PostConstruct
	void postConstruct() {
		log.info("開始");
		cacheWriter.forEach((key, value) -> {
			log.info("Cache Execution：" + key);
			value.cacheMasterData();
		});
	}

}
