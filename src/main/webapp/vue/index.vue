<template>
	<div>
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><router-link to='/index'>商城首页</router-link></li>
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
							<li><a href="">消息通知</a></li>
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
			};
		},
		computed: {
			text() {
				return {
					id: this.number,
					val: this.announces[this.number]
				}
			}
		},
		methods: {
			enterUserCenter() {
				console.log("hahahahq23333");
				this.$router.push('userCenter');
			}
		}
	}
</script>
