<template>
	<div>
		

			<div class="jieshao mt20 w">
				<div class="left fl"><img src="./image/liebiao_xiaomi6.jpg"></div>
				<div class="right fr">
					<div class="h3 ml20 mt20">{{goods.gname}}</div>
					<div class="ft20 ml20 mt20">详情描述:<br/>{{goods.ginfo}}</div>

					<div class="xqxq mt20 ml20">
						<div class="jiage ml20 mt10">开始结束时间</div>
						<div class="banben fl">
							<a>
								<span>竞拍开始时间 </span>
								<span>{{goods.gstart}}</span>
							</a>
						</div> 
						<div class="banben fr">
							<a>
								<span>竞拍结束时间</span>
								<span>{{goods.gend}}</span>
							</a>
						</div>
						<div class="clear"></div>
					</div>
					<div class="xqxq mt20 ml20">
						<div class="top1 mt10">
							<div class="left1 fl">每次加价幅度</div>
							<div class="right1 fr">{{goods.ggap}}元</div>
							<div class="clear"></div>
						</div>
						<div class="bot mt20 ft20 ftbc">起拍价格：{{goods.gprice}}元</div>
					</div>
					<div class="xiadan ml20 mt20">
						<input class="jrgwc" type="button" name="jrgwc" value="加入竞拍" @click="joinRoom(goods.gid)" />
						<input class="jrgwc" type="button" name="jrgwc" value="加入收藏" @click="myCollect(goods.gid)" />
					</div>
					<div class="xiadan ml20 mt20">
						<div class="bshare-custom icon-medium">
							<a title="分享到" href="http://www.bShare.cn/" id="bshare-shareto" class="bshare-more">分享到</a>
							<a title="分享到QQ空间" class="bshare-qzone"></a>
							<a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
							<a title="分享到人人网" class="bshare-renren"></a>
							<a title="分享到腾讯微博" class="bshare-qqmb"></a>
							<a title="分享到网易微博" class="bshare-neteasemb"></a>
							<a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a><span class="BSHARE_COUNT bshare-share-count">0</span></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</form>
		
	</div>
</template>
<script>
	export default {
		data() {
			return {
				goods: [],
				gid: ""
			};
		},
		mounted: function() {
			var self = this;
			this.$ajax.get("http://localhost:8080/goods/image?gid=" + this.$route.params.gid).then(
				function(response) {
					self.goods = response.data.list[0];
				});
		},
		methods: {
			myCollect(gid) {
				this.$ajax.post("http://localhost:8080/collects", {
					gid: gid
				}).then(
					function(response) {
						var resp = response.data;
						if(resp.status == "200") {
							alert(resp.message);
						} else if(resp.status == "500") {
							alert(resp.message);
						}
					});
			},
			joinRoom(gid) {
				alert(gid);
			}
		}
	}
</script>

<style scoped>

</style>