<template>
		<div class="danpin center">
			<div class="biaoti center">我的竞价室</div>
			<div class="main center">
					<div v-for="item in myRooms" class="mingxing1 fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
						<div class="sub_mingxing"><span @click="rooms(item.gid)"><img :src="'../admin/goods/goodsImg/'+item.image.img" style="width:100%;height:80%;"></span></div>
						<div class="pinpai2"><span @click="rooms(item.gid)">拍品名称:{{item.goods.gname}}</span></div>
						<div class="pinpai1"><span @click="rooms(item.gid)">起拍价格:{{item.goods.gprice}}</span></div>
						<div class="pinpai1">
							<span @click="rooms(item.gid)">围观次数:{{item.goods.gcount}}</span>
						</div>
						<div class="pinpai1"><span @click="rooms(item.gid)">加价幅度:{{item.goods.ggap}}</span></div>
						<div class="pinpai1"><span @click="rooms(item.gid)">起拍时间:{{item.goods.gstart}}</span></div>
						<div class="pinpai1"><span @click="rooms(item.gid)">起拍时间:{{item.goods.gend}}</span></div>
						<div class="pinpai1"><span class="pinpai3"  @click="details(item.gid)">拍品详情</span></div>
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
			this.$ajax.get('http://localhost:8080/users/isLogin').then(function(response){
				self.uid = response.data.user.uid;
				self.$ajax.get("http://localhost:8080/rooms/state",{
						params:{
							uid:self.uid
						}
				}).then(
						function(response) {
							self.myRooms = response.data;
							console.log(self.myRooms[0].image.img);
				});
			});
			
			
			
			
		},
		methods: {
			rooms(gid){
				this.$router.push({
					path: "/rooms/" + gid
				});
			},
			details(gid){
				this.$router.push({
					path:"goodsOne/"+gid
				});
			}
		}
	}
</script>

<style scoped>
	.mingxing1{width: 234px;height: 400px;background: rgb(250,250,250);margin-bottom: 20px;border: 2px solid white;}
	.pinpai1{width: 234px;height: 14px;line-height: 14px;text-align: center;margin-top: 5px;}
	.pinpai2{width: 234px;height: 14px;line-height: 14px;text-align: center;margin-top: 5px;}
	.pinpai3{color:#ff6709;text-decoration:underline}
</style>