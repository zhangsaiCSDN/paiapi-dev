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
							<li><a>消息通知</a></li>
						</ul>


					</div>
				</div>
			</div>
		</header>
		<router-view></router-view>
	</div>
</template>

<style scoped>
</style>

<script>
	export default {
		data() {
			return {
				username: null,
				uid: '',
				roles: [],
				user:''
			};
		},
		methods: {
			enterUserCenter() {
				this.getRoleId();
				for(var i= 0; i<this.roles.length;i++){
				//如果有卖家身份就直接进入到卖家中心，否则就进入买家中心
					if(this.roles[i].rname == "卖家"){
						this.$router.push('/salerCenter');
						return;
					};
				}
				this.$router.push('/userCenter');
			},
			logOut() {
				this.username = null;
				this.$ajax.get('http://localhost:8080/users/logout');
				this.$router.push("/index");
			},
			async isLogin() {
				var result = await this.$ajax.get('http://localhost:8080/users/isLogin');
				this.username = result.data.username;
				this.uid = result.data.uid;
			},
			getRoleId() {
				var uid = this.uid;
				var self = this;
				$.ajax({
					type: "get",
					url: "http://localhost:8080/users/" + uid,
					async:false,
					success: function(data) { //ajax请求成功后触发的方法
					self.roles = data.roles;
					self.user = data;
					}
				});
			}
		},
		mounted: function() {
			this.isLogin();
		}
	}
</script>
