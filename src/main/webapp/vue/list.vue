<template>
	<div>
		<div class="danpin center">
			<div class="biaoti center">商品列表</div>
			<hr/>
			<div class="main center">
			<swiper-slide  >
				<div class="mingxing fl"  v-for="good in goods.list">
					
					<div class="sub_mingxing">
						<a><img :src="'../admin/goods/goodsImg/'+good.images[0].img" @click="goodsOne(good.gid)" alt="" /></a>
					</div>
					<div class="biaoqian">&nbsp;浏览次数:{{good.gcount}}人</div>
					<div class="pinpai"><span @click="goodsOne(good.gid)">{{good.gname}}</span></div>
					<div class="youhui">{{good.gstart}}竞拍</div>
					<div style="font-size: 16px;text-align: center;color:#ff6709;">{{good.gprice}}元</div>
				</div>
				</swiper-slide  >
			</div>
		</div>
		<div class="danpin center" style="clear: both;text-align: center">
			{{goods.p}}/{{goods.maxPage}}
			<span @click="findAll(1)" style="cursor:pointer;">首页</span>
			<span @click="findAll(goods.prev)"  style="cursor:pointer;">上一页</span>
			<span @click="findAll(goods.next)"  style="cursor:pointer;">下一页</span>
			<span @click="findAll(goods.maxPage)"  style="cursor:pointer;">末页</span>
		</div>
	</div>
</template>

<style scoped>

</style>


<script>
export default {
		data() {
			return {
				goods: [],
			};
		},
		mounted: function() {
			this.findAll(1);
		},
		methods: {
			findAll(p) {
				var self = this;
				this.$ajax.get("http://localhost:8080/goods/image?p="+p).then(
					function(response) {
						self.goods = response.data;

					});
			},
			goodsOne(gid) {
				this.$router.push({
					path: "goodsOne/" + gid
				});
			},
			search(g,ga) {
				
				var self = this;
				this.$ajax.get("http://localhost:8080/goods/image", {
					params: {
						p: 1,
						gname: g.value,
						garea: ga.value
					}
				}).then(
					function(response) {
						self.goods = response.data;
						g.value = "";
						ga.value = "";
					});
			}
		}
	}
	
</script>