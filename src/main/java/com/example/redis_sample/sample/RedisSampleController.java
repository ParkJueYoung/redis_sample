package com.example.redis_sample.sample;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisSampleController {

	@Autowired
	RedisSampleService redisSampleService;

	// 화면 최초 진입시 redis 저장소에 저장된 모든 Data의 Key를 가져온다.
	@GetMapping("/")
	public String index(Model model) {
		Set<String> keys = redisSampleService.findAllKeys();
		model.addAttribute("keys", keys);
		return "index";
	}
	
	// redis 저장소에 데이터를 추가한다.
	@PostMapping("/save")
	public String save(@RequestParam String key, @RequestParam String value, Model model) {
		redisSampleService.save(key, value);
		Set<String> keys = redisSampleService.findAllKeys();
		model.addAttribute("keys", keys);
		model.addAttribute("message", "Saved");
		return "index";
	}

	// redis 저장소에 저장된 특정 Key의 데이터를 가져온다.
	@GetMapping("/get")
	public String get(@RequestParam String key, Model model) {
		Object value = redisSampleService.find(key);
		Set<String> keys = redisSampleService.findAllKeys();
		model.addAttribute("keys", keys);
		model.addAttribute("key", key);
		model.addAttribute("value", value);
		return "index";
	}

	// redis 저장소에 저장된 특정 Key의 데이터를 삭제한다.
	@PostMapping("/delete")
	public String delete(@RequestParam String key, Model model) {
		redisSampleService.delete(key);
		Set<String> keys = redisSampleService.findAllKeys();
		model.addAttribute("keys", keys);
		model.addAttribute("message", "Deleted");
		return "index";
	}
}