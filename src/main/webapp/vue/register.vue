<template>
	<form>
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a @click="pageChange('index')">拍拍网</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;
						<input class="shurukuang" type="text" name="username" placeholder="请输入你的用户名" v-model="uname" />
						<span>{{unameMsg}}</span>
					</div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;
						<input class="shurukuang" type="password" placeholder="请输入你的密码" v-model="upwd" />
						<span>{{upwdMsg}}</span>
					</div>
					<div class="username">确认密码:&nbsp;&nbsp;
						<input class="shurukuang" type="password" v-model="upwd2" placeholder="请确认你的密码" />
						<span>{{upwd2Msg}}</span>
					</div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;
						<input class="shurukuang" type="text" v-model="tel" placeholder="请填写正确的手机号" />
						<span>{{telMsg}}</span>
					</div>
					<div class="username">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;
							<input class="yanzhengma" type="text" name="username" placeholder="验证码" v-model="code" />
						</div>
						<div class="right fl"><button class="btn btn-warning" @click="getTelCode" type="button">发送手机验证码</button></div>
						<span>{{codeMsg}}</span>
					</div>
				</div>
				<div class="regist_submit">
					<button class="submit" type="button" @click="submitValidate()">立即注册</button>
					<!-- <button @click="info">
						test
					</button> -->
				</div>
			</div>
		</div>
	</form>
</template>
<style scoped>
	.regist span {
		color: black;
	}
</style>

<script>
	export default {

		data() {
			return {
				uname: '',
				upwd: '',
				upwd2: '',
				tel: '',
				code: '',

				unameMsg: '用户名6-32位数字字母组合,不含中文',
				upwdMsg: '请输入6位以上数字字母',
				upwd2Msg: '两次密码要输入一致哦',
				telMsg: '填写下手机号吧，方便我们联系您！',
				codeMsg: '手机号码输入正确后才可发送验证码哦~',
				validate: [],


			};
		},
		mounted: function() {

		},
		created: function() {
		},
		methods: {
			pageChange(path) {
				this.$router.push(path);
			},
			checkCode() {
				this.$ajax.get('http://localhost:8080/users/checkTelCode?code=' + this.code).then((response) => {
					if ((response.data.status)) {
						this.codeMsg = '正确';
						this.validate[4] = true;
					} else {
						this.codeMsg = '您输入的验证码有误,点击验证码刷新';
						this.validate[4] = false;
					}
				})
			},
			submitValidate() {
				for (var i = 0; i < this.validate.length; i++) {
					if (!this.validate[i]) {
						this.$Message.error('注册失败:您的输入有误,请检查输入后重试');
						return;
					}
				}
				var json = {
					uname: this.uname,
					upwd: this.upwd,
					tel: this.tel
				}
				this.$ajax.post("http://localhost:8080/users", json).then((response) => {
					if (response.data.status == 200) {
						this.$Message.success('注册成功! 已为您跳转至登录页面.');
						this.$parent.isLogin();
						this.pageChange('/login');
					} else {
						this.$Message.error(response.data.message);
					}
				});
			},
			getTelCode() {
				if (this.validate[3]&&this.validate[0]) {
					this.$ajax.get('http://localhost:8080/users/getTelCode?uname=' + this.uname + '&tel=' + this.tel).then((response) => {

						if ((response.data.status) == 200) {
							this.$Message.success('验证码以发送至您的手机,请注意查收');
						} else {
							this.$Message.error(response.data.message);
						}


					})
				} else {
					this.codeMsg = '错误:您还未输入正确的手机号码 或 用户名输入非法,请检查后重试';
				}


			}

		},
		watch: {
			uname(val) {
				var unameReg = new RegExp("^[A-Za-z0-9]{6,10}$");
				var unameT = unameReg.test(val);
				if (unameT) {
					this.unameMsg = '正确';
					this.validate[0] = true;
				} else {
					this.unameMsg = '错误:用户名必须为6-10位字母数字组合';
					this.validate[0] = false;
				}
			},
			upwd(val) {
				var upwdReg = new RegExp("^[A-Za-z0-9]{6,32}$");
				var upwdT = upwdReg.test(val);
				if (upwdT) {
					this.upwdMsg = '正确';
					this.validate[1] = true;
				} else {
					this.upwdMsg = '错误:密码为6-32位字母数字组合';
					this.validate[1] = false;

				}
			},
			upwd2() {
				if (this.upwd2 == this.upwd) {
					this.upwd2Msg = '正确';
					this.validate[2] = true;
				} else {
					this.upwd2Msg = '错误:两次输入的密码不一致';
					this.validate[2] = false;
				}
			},
			tel(val) {
				var telReg = new RegExp("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$");
				var telT = telReg.test(val);
				if (telT) {
					this.telMsg = '正确';
					this.validate[3] = true;
				} else {
					this.telMsg = '错误:请输入中国大陆(11位)手机号码';
					this.validate[3] = false;
				}
			},
			code(val) {
				if (val.length == 5) {
					this.checkCode();
				} else if (val.length > 5) {
					this.codeMsg = '验证码长度为五位,请检查后再次输入';
				} else if (val.length < 5) {
					this.codeMsg = '';
				}
			}


		}
	}
</script>
