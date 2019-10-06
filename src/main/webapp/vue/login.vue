<template>
	<!-- login -->
	<div>
		<div class="loginStyle">
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
							<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" v-model="uname" placeholder="请输入你的用户名" /></div>
							<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" v-model="upwd"
								 placeholder="请输入你的密码" /></div>
							<div class="username">
								<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" v-model="code" placeholder="验证码" /></div>
								<div class="right fl"><img :src='src' @click="codeRefresh"></div>
							</div>
							<span class="alertMsg">{{alertMsg}}</span>
						</div>
						<div class="login_submit">
							<button class="submit" type="button" @click="login">
								立即登录
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</template>


<style scoped>
	.loginStyle {
		margin-top: 100px;
	}

	.shurukuang,
	.yanzhengma {
		color: #000000;
		font-family: "微软雅黑";
		border-radius: 5px;
	}

	.alertMsg {
		color: red;
		font-family: "微软雅黑";
		font-size: 20px;
	}
</style>

<script>
	export default {

		data() {
			return {
				uname: '',
				upwd: '',
				code: '',
				src: 'http://localhost:8080/users/getCode',
				alertMsg: ' ',
				codeStatus: false
			};
		},
		mounted: function() {

		},
		created:function(){
			this.codeRefresh();
		},
		methods: {
			login() {
				if (this.codeStatus) {
					this.loginPost();
				} else {
					this.alertMsg = '您输入的验证码有误,点击验证码刷新';
				}
			},
			loginPost() {
				this.$ajax.post('http://localhost:8080/users/login', {
					'uname': this.uname,
					'upwd': this.upwd
				}).then((response) => {
					if (response.data.status == 500) {
						//登录失败
						this.codeRefresh();
						this.alertMsg = response.data.message;
					} else {
						this.$parent.isLogin();
						this.pageChange('/index');
					}
				})
			},
			checkCode() {
				this.$ajax.get('http://localhost:8080/users/checkCode?code=' + this.code).then((response) => {
					this.codeStatus = response.data.status;
					if ((response.data.status)) {
						this.alertMsg = '';
					} else {
						this.alertMsg = '您输入的验证码有误,点击验证码刷新';
					}
				})
			},
			pageChange(path) {
				this.$router.push(path);
			},
			codeRefresh() {
				this.src = 'http://localhost:8080/users/getCode?aa' + new Date();
			}
		},
		watch: {
			code(val) {
				if (val.length == 4) {
					this.checkCode();
				} else if (val.length > 4) {
					this.alertMsg = '验证码长度为四位,请检查后再次输入';
				} else if (val.length < 4) {
					this.alertMsg = '';
				}
			}
		}
	}
</script>
