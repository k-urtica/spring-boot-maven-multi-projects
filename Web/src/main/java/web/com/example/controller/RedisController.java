package web.com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	//	private final CacheWriterManager manager;
	//
	//	public RedisController(CacheWriterManager manager) {
	//		this.manager = manager;
	//	}

	@GetMapping("/")
	public String writeCache() {
		return "OK";
	}
}
