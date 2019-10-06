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
						<div class="right fl"><img :src="src" @click="codeRefresh()"></div>
						<span>&nbsp;{{codeMsg}}</span>
					</div>
				</div>
				<div class="regist_submit">
					<button class="submit" type="button" @click="submitValidate()">立即注册</button>
				</div>
			</div>
		</div>
	</form>
</template>
<style scoped>

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

				unameMsg: '请不要输入汉字',
				upwdMsg: '请输入6位以上字符',
				upwd2Msg: '两次密码要输入一致哦',
				telMsg: '填写下手机号吧，方便我们联系您！',
				codeMsg: '单击验证码可以刷新哦~',
				validate: [],

				src: 'http://localhost:8080/users/getCode',

			};
		},
		mounted: function() {

		},
		created: function() {
			this.codeRefresh();
		},
		methods: {
			pageChange(path) {
				this.$router.push(path);
			},
			checkCode() {
				this.$ajax.get('http://localhost:8080/users/checkCode?code=' + this.code).then((response) => {
					if ((response.data.status)) {
						this.codeMsg = '正确';
						this.validate[4] = true;
					} else {
						this.codeMsg = '您输入的验证码有误,点击验证码刷新';
						this.validate[4] = false;
					}
				})
			},
			codeRefresh() {
				this.src = 'http://localhost:8080/users/getCode?aa' + new Date();
			},
			submitValidate() {
				for (var i = 0; i < this.validate.length; i++) {
					if (!this.validate[i]) {
						return;
					}
				}
				var json = {
					uname: this.uname,
					upwd: this.upwd,
					tel: this.tel
				}
				this.$ajax.post("http://localhost:8080/users", json).then((response) => {
					if (response.status == 200) {
						this.$parent.isLogin();
						this.pageChange('/login');
					}
				});
			},
			pageChange(path) {
				this.$router.push(path);
			},

		},
		watch: {
			uname(val) {
				var unameReg = new RegExp("^[A-Za-z0-9]{6,32}$");
				var unameT = unameReg.test(val);
				if (unameT) {
					this.unameMsg = '正确';
					this.validate[0] = true;
				} else {
					this.unameMsg = '错误:用户名为6-32位字母数字组合';
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
					this.telMsg = '请输入中国大陆(11位)手机号码';
					this.validate[3] = false;
				}
			},
			code(val) {
				if (val.length == 4) {
					this.checkCode();
				} else if (val.length > 4) {
					this.codeMsg = '验证码长度为四位,请检查后再次输入';
				} else if (val.length < 4) {
					this.codeMsg = '';
				}
			}


		}
	}
</script>
