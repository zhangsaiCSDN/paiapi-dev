<template>
	<div>
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li>
							<router-link to='/index'></router-link>
						</li>
						<li>|</li>

						<li><a>问题反馈</a></li>
						<li>|</li>
						<li><a>切换商家版</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr" v-if="username!=null" @click="enterUserCenter"> <span>个人中心</span></div>
					<div class="fr">

						<ul v-if="username==null">
							<li>
								<router-link to="/login">登录</router-link>
							</li>
							<li>|</li>
							<li>
								<router-link to="/register">注册</router-link>
							</li>
						</ul>

						<ul v-if="username!=null">
							<li>
								欢迎您&nbsp;&nbsp;,{{username}}&nbsp;
							</li>
							<li>|</li>
							<li @click='logOut'>
								&nbsp;退出登录&nbsp;
							</li>
							<li>|</li>
							<li @click="showMsg">消息通知<span id="box" v-if="msg.length>0">{{msg.length}}</span>
								<select v-if="msg.length>0">
									<option v-for="(v,k,i) in msg"  :key='i'>{{(k+1)+'号'+v}}</option>
								</select>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<router-view></router-view>
	</div>
</template>

<style scoped>
	#box {
		border-radius: 10px;
		font-size: 15px;
		background-color: red;
		color: #000000;
		width: 20px;
	}
	select{
		background-color: #0e0e0e;
		border: #000000;
	}
</style>

<script>
	export default {
		data() {
			return {
				username: null,
				uid: null,
				path: "ws://localhost:8080/msg/",
				socket: '',
				msg: [],


			};
		},
		methods: {
			enterUserCenter() {
				this.$router.push('/salerCenter');
			},
			logOut() {
				this.username = null;
				this.$ajax.get('http://localhost:8080/users/logout');
				this.msg=[];
				
			},
			async isLogin() {
				var result = await this.$ajax.get('http://localhost:8080/users/isLogin');
				this.username = result.data.user.uname;
				this.uid = result.data.user.uid;
				this.msgInit();
			},
			msgInit() {
				if (this.uid != null) {
					this.socket = new WebSocket(this.path + this.uid);
					this.socket.onopen = this.msgOpen;
					this.socket.onerror = this.msgError;
					this.socket.onmessage = this.msgReceived;
					this.socket.onclose = this.msgClose;
				}
			},
			msgReceived(msg) {
				this.msg.push(msg.data);
			},
			msgOpen() {

			},
			msgClose() {

			},
			msgError() {

			},
			showMsg() {

			}
		},
		mounted: function() {
			this.isLogin();
			this.msgInit();

		},
		destoryed: function() {
			this.msgClose();
		}
	}
</script>
