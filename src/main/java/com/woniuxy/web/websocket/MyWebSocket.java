package com.woniuxy.web.websocket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint("/chat/{roomName}")
@Component
public class MyWebSocket {
	private static Map<String,Set<Session>> rooms = new HashMap<>();
	@OnOpen
	 public void connect(@PathParam("roomName") String roomName, Session session) throws Exception {
        // 将session按照房间名来存储，将各个房间的用户隔离
       
		if (!rooms.containsKey(roomName)) {
            // 创建房间不存在时，创建房间
			System.out.println(roomName+"!!!!!!!!!");
            Set<Session> room = new HashSet<>();
            // 添加用户
            room.add(session);
            rooms.put(roomName, room);
        } else {
            // 房间已存在，直接添加用户到相应的房间
        	System.out.println(roomName+"@@@");
            rooms.get(roomName).add(session);
        }
    }


    @OnClose
    public void disConnect(@PathParam("roomName") String roomName, Session session) {
        rooms.get(roomName).remove(session);
        System.out.println("111111111111");
        System.out.println(roomName+"##########");
        System.out.println("a client has disconnected!!!!!");
    }
 
    @OnMessage
    public void receiveMsg(@PathParam("roomName") String roomName,
                           String msg, Session session) throws Exception {
        // 此处应该有html过滤
        msg = session.getId();
        System.out.println(msg+"!!!!!!");
        // 接收到信息后进行广播
        broadcast(roomName, msg);
    }
 
    // 按照房间名进行广播
    public static void broadcast(String roomName, String msg) throws Exception {
        for (Session session : rooms.get(roomName)) {
                session.getBasicRemote().sendText(msg);
        }
    }

	
	
	
	
	
	
	
	
	
}
