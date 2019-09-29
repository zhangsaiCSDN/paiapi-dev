package com.woniuxy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.domain.User;
import com.woniuxy.service.impl.UserServiceImpl;
import com.woniuxy.util.AppUtils;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserServiceImpl service;

//	shiro 注册 用户增加加密
	@PostMapping
	@ResponseBody
	@CrossOrigin
	public Map<String, Object> save(@RequestBody User user) {
		System.out.println(user);
		Map<String, Object> map = new HashMap<>();
		try {
			String password_salt = AppUtils.uuid();
			String password = AppUtils.encrypt(user.getUpwd(), password_salt);
			user.setUpwd(password);
			user.setSalt(password_salt);
			map.put("status", 200);
			map.put("message", "注册成功");
			System.out.println(user);
			service.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
			map.put("message", "注册失败，可能是用户名已存在");
		}
		return map;
	}

	// 登录过程 成功返回200 失败返回500
	@PostMapping("login")
	@ResponseBody
	public Map<String, Object> login(String username, String password,HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		Map<String, Object> map = new HashMap<>();
		try {
			subject.login(token);
			map.put("status", 200);
			map.put("username", subject.getPrincipal());
			User user = service.findUserByUname(username);
			req.setAttribute("uid", user.getUid());
		} catch (AuthenticationException e) {
			map.put("status", 500);
			map.put("message", "登录失败，可能是用户名或密码错误");
		}

		return map;
	}

	// 是否登录 成功返回200 失败返回500
	@GetMapping("isLogin")
	@ResponseBody
	public Map<String, Object> isLogin() {
		System.out.println("isLogin");
		Subject subject = SecurityUtils.getSubject();

		Map<String, Object> map = new HashMap<>();
		map.put("status", subject.isAuthenticated() ? 200 : 500);
		return map;
	}

	@DeleteMapping
	@ResponseBody
	public void delete(Integer uid) {
		service.delete(uid);
	}

	@PutMapping
	@ResponseBody
	public void update(@RequestBody User user) {
		String password_salt = AppUtils.uuid();
		String password = AppUtils.encrypt(user.getUpwd(), password_salt);
		user.setUpwd(password);
		user.setSalt(password_salt);
		service.update(user);
	}

	@GetMapping(value = "/{uid}")
	@ResponseBody
	public User findOne(@PathVariable Integer uid) {
		return service.findOne(uid);
	}

	@GetMapping
	@ResponseBody
	public List<User> find() {
		return service.findInfo();
	}

}
