<template>
		<div class="danpin center">
			<div class="biaoti center">我的竞价室</div>
			<div class="main center">
					<div v-for="item in myRooms" class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
						<div class="sub_mingxing"><router-link to="/rooms">11</router-link></div>
						<div class="pinpai2"><router-link to="/rooms/2">拍品名称:{{item.goods.gname}}</router-link></div>
						<div class="pinpai1"><router-link to="/rooms">起拍价格:{{item.goods.gprice}}</router-link></div>
						<div class="pinpai1"><router-link to="/rooms">围观次数:{{item.goods.gcount}}</router-link></div>
						<div class="pinpai1"><router-link to="/rooms">加价幅度:{{item.goods.ggap}}</router-link></div>
						<div class="pinpai1"><router-link to="/rooms">起拍时间:{{item.goods.gstart}}</router-link></div>
						<div class="pinpai1"><router-link to="/rooms">起拍时间:{{item.goods.gend}}</router-link></div>
						<div class="pinpai1"><router-link to=""><span class="pinpai3">拍品详情</span></router-link></div>
					</div>
				<div class="clear"></div>
			</div>
		</div>
</template>
	
<script>
	export default {
		data() {
			return {
				myRooms:[],
				uid:""
			};
		},
		mounted:function(){
			var self = this;
			var uid = this.$route.params.uid;
				this.$ajax.get("http://localhost:8080/rooms/state?uid="+uid
				).then(
						function(response) {
							self.myRooms = response.data;
							console.log(self.myRooms)
				});
			
		},
		methods: {
			
		}
	}
</script>

<style scoped>
	.danpin .main .mingxing .pinpai1{width: 234px;height: 14px;line-height: 14px;text-align: center;margin-top: 5px;}
	.danpin .main .mingxing .pinpai2{width: 234px;height: 14px;line-height: 14px;text-align: center;margin-top: -25px;}
	.danpin .main .mingxing .pinpai3{color:#ff6709;}
</style>