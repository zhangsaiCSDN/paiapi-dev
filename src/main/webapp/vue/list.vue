<template>
	<div>
		<!-- start danpin -->
		<div class="danpin center">
			<div class="biaoti center">小米手机</div>
			<div class="main center" >
				<div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'" v-for="good in goods.list">
					<div class="sub_mingxing"><a><img src="./image/liebiao_xiaomi5s.jpg" @click="goodsOne(good.gid)" alt="" /></a></div>
					<div class="pinpai"><span @click="goodsOne(good.gid)">{{good.gname}}</span></div>
					<div class="youhui">{{good.gstart}}竞拍</div>
					<div class="jiage">{{good.gprice}}元</div>
				</div>
			</div>
		</div>
		<div class="danpin center" style="clear: both;text-align: center">
			{{goods.p}}/{{goods.maxPage}}
			<span @click="finAll(1)">首页</span>
			<span @click="findAll(goods.prev)" >上一页</span>
			<span @click="findAll(goods.next)">下一页</span>
			<span @click="finAll(goods.maxPage)">末页</span>
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
			this.findAll(1);
		},
		methods: {
			findAll(p){
				var self = this;
				this.$ajax.get("http://localhost:8080/goods/image?p="+p
				).then(
						function(response) {
							self.goods = response.data; 
							
				});
			},
			goodsOne(gid){
				this.$router.push({
					path:"goodsOne/"+gid
				});
			}
		}
	}
	
</script>