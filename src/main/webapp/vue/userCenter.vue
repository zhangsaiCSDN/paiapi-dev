<template>
	<!-- userCenter -->
	<div>
			<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><router-link to="/order/:1">我的订单</router-link></li>
					<li><router-link to="/goodsHistory">拍品记录</router-link></li>
					<li><router-link to="">我的参与</router-link></li>
					<li><router-link to="/myRooms/:1">我的竞价室</router-link></li>
					<li><router-link to="">我的消息</router-link></li>
					<li><router-link to="">我的收藏</router-link></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><router-link to="">个人中心</router-link></li>
					<li><router-link to="">我的信息</router-link></li>
					<li><router-link to="">我的地址</router-link></li>
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
	
</script>
