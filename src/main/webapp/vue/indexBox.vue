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
			<div class="main center">
				<div class="mingxing fl">
					<div class="biaoqian">围观次数<br />122人</div>
					<div class="sub_mingxing">
						<router-link to="/list"><img></router-link>
					</div>
					<div class="pinpai"><a href="">元代青花彩釉纹龙小瓶</a></div>
					<div class="youhui">反正就是贵</div>
					<div class="jiage">￥10000000.00起</div>
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
				goodsType: [],
			};
		},
		mounted: function() {
			var self = this;
			this.$ajax.get("http://localhost:8080/goodsType").then(function(response) {
				self.goodsType = response.data;
			});
		},
		methods: {}
	}
</script>
