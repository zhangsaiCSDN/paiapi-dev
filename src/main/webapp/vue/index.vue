<template>
	<div>
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li>
							<router-link to='/index'>商城首页</router-link>
						</li>
						<li>|</li>
						<li @click="back">
							<a>网站后台</a>
						</li>
						<li>|</li>

						<li @click="modal2=true"><a>问题反馈</a></li>
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
								欢迎您&nbsp;,&nbsp;{{username}}&nbsp;
							</li>
							<li>|</li>
							<li @click='logOut'>
								&nbsp;退出登录&nbsp;
							</li>
							<li>|</li>
							<li @click="showMsg">消息通知<span id="box" v-if="msg.length>0">{{msg.length}}</span>
								<!-- <select v-if="msg.length>0">
									<option v-for="(v,k,i) in msg" :key='i'>{{(k+1)+'号'+v}}</option>
								</select> -->
							</li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<router-view></router-view>
		<!-- <Modal v-model="modal1" title="Common Modal dialog box title" @on-ok="ok" @on-cancel="cancel"> -->
		<Modal v-model="modal1" title="消息列表">
			<div>
				<div class="msgBox" v-for="(v,k,i) in msg" :key='i'>
					<p>{{v}}</p>
				</div>
			</div>


		</Modal>
		<Modal v-model="modal2" title="您的反馈和建议">
			<div class="fankui">
				项目开发时间紧急,有很多不尽完善的地方,我们愿意倾听您的建议和意见.</br>
				问题反馈联系:QQ 35534574 注明 蜗牛拍拍</br>
			</div>

		</Modal>
		<Modal v-model="modal3" title="您关注的以下下拍品有竞拍活动">
			<div class="fankui">
				<div class="msgBox" v-for="(v,k,i) in msgAlert" :key='i'>
					<p>{{(k+1)+'号消息:'+v}}</p>
				</div>
			</div>

		</Modal>
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

	.fankui {
		font-size: 15px;
		font-family: "微软雅黑";
	}

	.msgBox {
		height: 30px;
		margin-left: 30px;
		font-size: 15px;
		font-family: "微软雅黑";
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
				msgAlert:[],
				modal1: false,
				modal2: false,
				modal3: false
			};
		},
		methods: {
			enterUserCenter() {
				this.$router.push('/userCenter');
			},
			logOut() {
				this.username = null;
				this.$ajax.get('http://localhost:8080/users/logout');
				this.msg = [];
				this.$router.push('/index');
			},
			async isLogin() {
				var result = await this.$ajax.get('http://localhost:8080/users/isLogin');
				if (result.data.status == 200) {
					this.username = result.data.user.uname;
					this.uid = result.data.user.uid;
				}
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
				var message = msg.data;
				var msgArray = message.split("###")
				if (msgArray[0] == 'alert') {
					this.msgAlert.push(msgArray[1]);
					this.msg.push(msgArray[1]);
					this.modal3=true;
				} else {
					this.msg.push(msg.data);
				}
			},
			msgOpen() {

			},
			msgClose() {

			},
			msgError() {

			},
			showMsg() {
				this.modal1 = true;
			},
			fankui() {

			},
			back() {
				location.href = 'http://localhost:8080/admin/admin.html';
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
