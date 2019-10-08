<template>
	<!-- userCenter -->
	<div>
			<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><router-link to="/order">我的订单</router-link></li>
					<li><router-link to="/goodsHistory">拍品记录</router-link></li>
					<li><router-link to="/myRooms">我的竞价室</router-link></li>
					<li><router-link to="/wushuang">我的收藏</router-link></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><router-link to="/userCenter/userInfo">我的信息</router-link></li>
					<li><router-link to="/address">我的地址</router-link></li>
					<li><router-link to="/deposit">我的押金</router-link></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr" id="userCenter">
		<!--
			用户中心展示
		-->
			<router-view></router-view>
			
		</div>
		<div class="clear"></div>
		</div>
	</div>
	</div>
</template>
	

<style scoped>

</style>

<script>
	export default {
		data() {
			return {
				uid:'', 
				roles: [],
				user:''
			};
		},
		methods: {
			async isLogin() {
			var self = this;
				var result = await this.$ajax.get('http://localhost:8080/users/isLogin');
				self.username = result.data.username;
				self.uid = result.data.user.uid;
				self.getRoleId();
			},
			enterToSalerCenter(){
			this.$router.push("/salerCenter");
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
					for(var i=0;i<self.roles.length;i++){
						if(self.roles[i].rname == "卖家"){
							self.enterToSalerCenter();
							return;
						};
					}
					
					}
				});
			}
		},
		created: function() {
			this.isLogin();
		
		}
	}
</script>
