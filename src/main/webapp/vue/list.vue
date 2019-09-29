<template>
	<div>
		<!-- start danpin -->
		<div class="danpin center">
			<div class="biaoti center">小米手机</div>
			<div class="main center" >
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'" v-for="good in goods.list">
					<div class="sub_mingxing"><a><img src="../image/liebiao_xiaomi5s.jpg" @click="goodsOne(good.gid)" alt="" /></a></div>
					<div class="pinpai"><span @click="goodsOne(good.gid)">{{good.gname}}</span></div>
					<div class="youhui">{{good.gstart}}竞拍</div>
					<div class="jiage">{{good.gprice}}元</div>
				</div>
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
			goods:[],
		};
	},
	mounted:function(){
		var self = this;
			this.$axios.get("http://localhost:8080/goods/image"
			).then(
					function(response) {
						self.goods = response.data; 
						
			});
	},
	methods: {
	}
}
	
</script>