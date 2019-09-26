package com.woniuxy.web.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint("/chat")
@Component
public class MyWebSocket {
	private static Set<Session> set = new HashSet<>();
	@OnOpen
	public void onOpen(Session s) {
		set.add(s);
		System.out.println("欢迎**来到竞价室!");
	}
	@OnMessage
	public void onMessage(String message,Session session){
		System.out.println(set.size()+"!!!");
		for(Session s:set) {
			try {
				s.getBasicRemote().sendText(message);
			} catch (Exception e) {
			
			}
		}
	}
	
	public void onClose(Session session) {
		System.out.println("有人退出...");
		set.remove(session);
	}
	
	
	
	
	
	
	
	
	
}
