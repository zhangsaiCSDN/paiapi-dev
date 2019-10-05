<template>
	<!-- login -->
	<div>
		<form class="form center">
			<div class="login">
				<div class="login_center">
					<div class="login_top">
						<div class="left fl">会员登录</div>
						<div class="right fr">您还不是我们的会员？<a @click="pageChange('register')">立即注册</a></div>
						<div class="clear"></div>
						<div class="xian center"></div>
					</div>
					<div class="login_main center">
						<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入你的用户名" /></div>
						<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="password"
							 placeholder="请输入你的密码" /></div>
						<div class="username">
							<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码" /></div>
							<div class="right fl"><img src=""></div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="login_submit">
						<input class="submit" type="submit" name="submit" value="立即登录">
					</div>
				</div>
			</div>
		</form>
	</div>
</template>


<style scoped>

</style>

<script>
	export default {

		data() {
			return {

			};
		},
		mounted: function() {

		},
		methods: {
			pageChange(path) {
				this.$router.push(path);
			}
		}
	}
</script>
