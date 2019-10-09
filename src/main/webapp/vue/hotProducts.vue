<template>
	<div class="danpin center">
			<div class=" biaoti center">
				<span class="glyphicon glyphicon-hand-down"> 爆款拍品</span>
			</div>
			<div class="main center">
			 	<swiper-slide  >
					<div class="mingxing fl" v-for="g in goods.slice(0,10)" @click="findOne(g.gid)" >
						<div class="sub_mingxing"><router-link to="/goodsOne"><img  :src='"admin/goods/goodsImg/"+g.images[0].img' width="150px"/></router-link></div>
						<div class="biaoqian">&nbsp;浏览次数:{{g.gcount}}人</div>
						<div class="pinpai">{{g.gname}}</div>
						<div class="youhui">起拍时间:{{g.gstart}}</div>
						<div class="jiage">起拍价格:￥{{g.gprice}}起</div>
					</div>
				</swiper-slide>
			</div>
	</div>

</template>

<style scoped>
	div {
		
	}
</style>


<script>
	export default {
		data() {
			return {
				goods: [],
				gname:'',
				gstart:'',
				gend:'',
				gcount:'',
				gprice:'',
				img:'',
			};
		},
		
		mounted(){
			var self = this;
			self.$ajax.get("http://localhost:8080/goods/findHotGoods")
			.then(function(response) {
				self.goods = response.data; 
			});
		},
		
		methods: {
			findOne(gid){	
				this.$router.push({
					path: "goodsOne/" + gid
				});
			}
		}
	}
	
</script>