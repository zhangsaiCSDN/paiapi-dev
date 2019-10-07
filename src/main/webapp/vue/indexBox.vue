<template>
	<div>
		<!-- start banner_y -->
		<div class="banner_y center">
			<div class="nav">
				<ul>
					<li v-for="gt in goodsType">
						<a >{{gt.gtname}}</a>
						<div class="pop">
							<div class="left fl" v-for="g in gt.goods">
								<div class="xuangou_left fl">
									<a >
										<div class="img fl"><img :src='g.images[0] ? "../admin/goods/goodsImg/"+g.images[0].img : "../image/733db5ee-2e56-41fe-8286-3a3f87193496.jpg" '></div>
										<span class="fl">{{g.gname}}</span>
									</a>
								</div>
								<div class="xuangou_right fr"><a href="./xiangqing.html" target="_blank">查看</a></div>
							</div>

							<div class="right fl">
								<div class="xuangou_left fl">
									<a>
										<div class="img fl" style="margin-left: 20px;"><img :src='"../admin/goods/goodsTypeImg/"+gt.img' alt=""></div>
									</a>
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
			<div class="datu fl" style="margin-left: 0px">
				<router-link to="/biddingRoom"><img src="https://img12.360buyimg.com/paimai/s840x283_jfs/t1/55998/32/789/395304/5ce80029E474146e2/ba1497caa6e31307.jpg!q90.webp"></router-link>
			</div>
			<div class="datu fl">竞拍专场2</div>
			<div class="datu fl">竞拍专场3</div>
			<div class="datu fl">竞拍专场4</div>
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
					<div class="mingxing fl" v-for="g in goods" @click="findOne(g.gid)" >
						<div class="biaoqian">围观次数<br />{{g.gcount}}人</div>
						<div class="sub_mingxing"><router-link to="/goodsOne"><img  :src='"../admin/goods/goodsImg/"+g.img' width="150px"/></router-link></div>
						<div class="pinpai"><a>{{g.gname}}</a></div>
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
	export default {
		data() {
			return {
				goodsType: [],
				goods: [],
				gname:'',
				gstart:'',
				gend:'',
				gcount:'',
				gprice:'',
				img:'',
				swiperOption: {
		            autoplay: 3000,
		            pagination: '.swiper-pagination',
		            autoplayDisableOnInteraction: false,
		            loop: true
		        },
             	swipers:[]
			};
		},
		mounted: function() {
			var self = this;
			this.$ajax.get("http://localhost:8080/goodsType").then(function(response) {
				self.goodsType = response.data;
			});
		},
		created:function(){
			this.findHotGoods();
		},
		methods:{
			findHotGoods() {
				var self = this;
				self.$ajax.get("http://localhost:8080/goods/findHotGoods")
				.then(function(response) {
					self.goods = response.data; 
				});
			},
			slide() {
				setTimeout(() => {
               		this.asyncCount = 5
            	}, 1000)
			},
			findOne(gid){
				this.$router.push({
					path: "goodsOne/" + gid
				});
			}
			
		}
	}
</script>
