package com.woniuxy.web.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.woniuxy.util.ValidateCode;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserServiceImpl service;

//	shiro 注册 用户增加加密
	@PostMapping
	@ResponseBody
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
	public Map<String, Object> login(@RequestBody User userFront, HttpServletRequest req) {
		String username = userFront.getUname();
		String password = userFront.getUpwd();
		System.out.println(username + password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		Map<String, Object> map = new HashMap<>();
		try {
			subject.login(token);
			map.put("status", 200);
			map.put("username", subject.getPrincipal());
			req.getSession().setAttribute("uid", service.findUserByUname(username).getUid());
		} catch (AuthenticationException e) {
			map.put("status", 500);
			map.put("message", "登录失败，可能是用户名或密码错误");
		}

		return map;
	}

	// 退出登录 注销功能
	@GetMapping(value = "logout")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}

	// 是否登录 成功返回200 失败返回500
	@GetMapping("isLogin")
	@ResponseBody
	public Map<String, Object> isLogin() {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Map<String, Object> map = new HashMap<>();
		map.put("status", subject.isAuthenticated() ? 200 : 500);
		map.put("username", username);
		if (username != null) {
			User user = service.findUserByUname(username);
			map.put("user", user);
		}
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

	// 获取验证码
	@GetMapping(value = "getCode")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// 生成验证码map
		Map<String, Object> codeMap = ValidateCode.generateCodeAndPic();

		// 验证码的值放在session里
		HttpSession session = req.getSession();
		session.setAttribute("code", codeMap.get("code").toString());

		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");

		// 输出流显示图片
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
		sos.flush();
		sos.close();
	}

	// 校验验证码
	@GetMapping(value = "checkCode")
	@ResponseBody
	public Map<String, Object> checkCode(HttpServletRequest req, HttpServletResponse resp, String code) {

		// session中取出真实的验证码
		String realCode = (String) req.getSession().getAttribute("code");
		Map<String, Object> map = new HashMap<>();

		// 对比前端验证码和真实验证码 一致返回true 不一致返回false
		if (code != null && code.equalsIgnoreCase(realCode)) {
			map.put("status", true);
		} else {
			map.put("status", false);
		}
		return map;
	}

}
