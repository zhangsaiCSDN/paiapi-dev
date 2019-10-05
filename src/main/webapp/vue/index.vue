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
					<div class="gouwuche fr"> <span @click="enterUserCenter">个人中心</span></div>
					<div class="fr">
						<ul>
							<li>
								<router-link to="/login">登录</router-link>
							</li>
							<li>|</li>
							<li>
								<router-link to="/register">注册</router-link>
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
				username: ''
			};
		},
		computed: {
			text() {
				return {
					id: this.number,
					val: this.announces[this.number],
				}
			}
		},
		methods: {
			enterUserCenter() {
				this.$router.push('/userCenter');
			},
			isLogin() {
				this.$ajax.get('http://localhost:8080/users/isLogin').then((resp) => {
					if (resp.data.status == 200) {
						this.username == resp.data.username;
					}
				});
			}
		},
		mounted: function() {
			this.isLogin();
		}
	}
</script>
