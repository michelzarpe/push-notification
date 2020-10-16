package com.push.notification;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping(value = "/stream")
public class Stream {
	public static final SseEmitter notifier = new SseEmitter();
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String getTest() throws IOException {
		notifier.send(new String("Ola mundo"));
		return "Testando REST";
	}
	
	@RequestMapping(value = "/stream", method = RequestMethod.GET)
	public SseEmitter enableNotifier(){
		  return notifier;
	}
	
}
