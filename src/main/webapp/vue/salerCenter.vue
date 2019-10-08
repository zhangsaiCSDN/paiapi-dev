<template>
	<!-- userCenter -->
	<div>
			<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><router-link to="/salerOrder">卖家订单</router-link></li>
					<li><router-link to="/userGoods">卖家拍品</router-link></li>
					<li><router-link to="">我的竞价室</router-link></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><router-link to="/salerCenter/userInfo">个人中心</router-link></li>
					<li><router-link to="/salerCenter/deposit">我的押金</router-link></li>
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
