<template> 
	<div>
		<!-- start banner_y -->
		<div class="banner_y center" >
			<div class="nav" >				
				<ul >
					<li v-for="gt in goodsType">
						<a href="">{{gt.gtname}}</a>
						<div class="pop">
							<div class="left fl" v-for="g in gt.goods">
								<div class="xuangou_left fl" >
									<a href=""> 
										<div class="img fl"><img :src='g.images[0] ? "../admin/goods/goodsImg/"+g.images[0].img : "../image/733db5ee-2e56-41fe-8286-3a3f87193496.jpg" ' ></div>
										<span class="fl">{{g.gname}}</span>
									</a>
								</div> 
							</div>
							<br />
							<div class="right fl">
								<div class="xuangou_left fl">
									<div class="img fl" style="margin-left: 20px;"><img :src='"../admin/goods/goodsTypeImg/"+gt.img' alt=""></div>
								</div>
							</div>
						</div>
					</li>
					
				</ul>
			</div>
		</div>	
	
		<div class="sub_banner center">
			<div class="biaoti center">
				热门竞拍专场
				<router-link to="/biddingRoomList"><a class="biaoqian fl">查看更多></a></router-link>
			</div>
			<div class="datu fl" style="margin-left: 0px"><router-link to="/biddingRoom"><img src="https://img12.360buyimg.com/paimai/s840x283_jfs/t1/55998/32/789/395304/5ce80029E474146e2/ba1497caa6e31307.jpg!q90.webp"></router-link></div>
			<div class="datu fl"><router-link to="/biddingRoom"><img src="https://img12.360buyimg.com/paimai/s840x283_jfs/t1/55998/32/789/395304/5ce80029E474146e2/ba1497caa6e31307.jpg!q90.webp"></router-link></div>
			<div class="datu fl"><router-link to="/biddingRoom"><img src="https://img12.360buyimg.com/paimai/s840x283_jfs/t1/55998/32/789/395304/5ce80029E474146e2/ba1497caa6e31307.jpg!q90.webp"></router-link></div>
			<div class="datu fl"><router-link to="/biddingRoom"><img src="https://img12.360buyimg.com/paimai/s840x283_jfs/t1/55998/32/789/395304/5ce80029E474146e2/ba1497caa6e31307.jpg!q90.webp"></router-link></div>
		</div>
			
		<!-- start danpin -->
		<div id="danpin" class="danpin center">
			<div class="biaoti center">
				人气竞拍单品
				<router-link to="/list"><a class="biaoqian fl">查看更多></a></router-link>
			</div>
			<!-- slide -->
				<div class="main center">
			 	<swiper-slide  >
					<div class="mingxing fl" v-for="g in goods.slice(0,10)" @click="findOne(g.gid)" >
						<div class="sub_mingxing"><router-link to="/goodsOne"><img  :src='"../admin/goods/goodsImg/"+g.images[0].img' width="150px"/></router-link></div>
						<div class="biaoqian">&nbsp;浏览次数:{{g.gcount}}人</div>
						<div class="pinpai">{{g.gname}}</div>
						<div class="youhui">起拍时间:{{g.gstart}}</div>
						<div class="jiage">起拍价格:￥{{g.gprice}}起</div>
					</div>
				</swiper-slide>
				</div>
		</div>
		<!-- end danpin -->
	</div>

</template>

<style scoped>
</style>
	
<script>
export default{
	data(){
		return{
			goodsType:[],
			goods: [],
		};
	},
	mounted:function(){
		var self=this;
		this.$ajax.get("http://localhost:8080/goodsType/findAll").then(function(response){
			self.goodsType=response.data;
		});
	},
	created:function(){
		this.findHotGoods();
	},
	methods:{
		findHotGoods() {
			var self = this;
			self.$ajax.get("http://localhost:8080/goods/findHotGoods").then(function(response) {
				self.goods = response.data; 
			});
		},
		findOne(gid){
			this.$router.push({
				path: "goodsOne/" + gid
			});
		}
	}
}
</script>