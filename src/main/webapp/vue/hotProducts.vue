<template>
	<div class="danpin center">
			<div class=" biaoti center">
				<span class="glyphicon glyphicon-hand-down"> 爆款拍品</span>
			</div>
			<div class="main center">
				<div class="mingxing fl" v-for="g in goods" @click="findOne(g.gid)">
					<div class="biaoqian">围观次数<br />{{g.gcount}}人</div>
					<div class="sub_mingxing"><router-link to="/goodsOne"><img  :src='"../admin/goods/goodsImg/"+g.img' width="150px"/></router-link></div>
					<div class="pinpai"><a>{{g.gname}}</a></div>
					<div class="youhui">起拍时间:{{g.gstart}}</div>
					<div class="jiage">起拍价格:￥{{g.gprice}}起</div>
				</div>
	
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
				img:''
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