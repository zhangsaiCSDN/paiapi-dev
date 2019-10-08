package com.woniuxy.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm.SaltStyle;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class ShiroConfig {

	@Bean
	public DataSource ds() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://39.106.170.86:3306/paipai");
		ds.setUsername("root");
		ds.setPassword("paipai16");
		return ds;
	}

	public HashedCredentialsMatcher hcm() {
		HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
		hcm.setHashAlgorithmName("MD5");
		hcm.setHashIterations(1024);
		return hcm;
	}

	@Bean
	public JdbcRealm jdbcRealm() {
		JdbcRealm realm = new JdbcRealm();
		realm.setDataSource(ds());

		// 认证
		realm.setAuthenticationQuery("SELECT upwd,salt FROM user WHERE uname=?");
		// 根据用户名查询角色
		realm.setUserRolesQuery(
				"SELECT rname FROM user_role ur INNER JOIN user u ON ur.`uid` = u.`uid` INNER JOIN role r ON ur.rid = r.rid AND uname = ?");
		// 根据角色名查询权限
		realm.setPermissionsQuery(
				"SELECT pmsname FROM role_permission rp INNER JOIN role r ON rp.`rid` = r.`rid` INNER JOIN permission p ON rp.`pmsid` = p.`pmsid` AND rname = ?");
		// 必须加这个配置，否则对客户端传来的明文密码不进行解密
		realm.setSaltStyle(SaltStyle.COLUMN);

		realm.setCredentialsMatcher(hcm());

		// 支持权限查询(必须配置该项，否则无法判断用户拥有的角色是否拥有某个权限)
		// 这样才能，根据用户去查询用户的权限。
		realm.setPermissionsLookupEnabled(true);

		return realm;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(jdbcRealm());
		return securityManager;
	}

	/*
	 * 以下的过滤器会自动，执行改行代码： SecurityUtils.setSecurityManager(securityManager)
	 * 该代码就是把securityManager设置为全局的！ 这样，我们就可以在项目的任何一个地方
	 * 通过SecurityUtils.getSubject来获取登录当前应用的主体了，
	 */
	@Bean
	public ShiroFilterFactoryBean sf() {
		ShiroFilterFactoryBean sf = new ShiroFilterFactoryBean();
		sf.setSecurityManager(securityManager());
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//		filterChainDefinitionMap.put("/admin/index.html", "authc");
		filterChainDefinitionMap.put("/admin/index.html", "authc,roles[admin]");
		sf.setUnauthorizedUrl("/admin/admin.html");
		sf.setLoginUrl("/admin/admin.html");
		sf.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return sf;      
	}

}
