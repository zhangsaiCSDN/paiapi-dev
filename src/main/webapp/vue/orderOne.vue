<template>
	<div>

	<div class="jieshao mt20 w">
		<!-- 图片 -->
		<div class="left fl">		
			<div class="imgs" v-for="(item,index) in imgList" v-if="index==num">
				 <img :src='"../admin/goods/goodsImg/"+item.img'/>
			</div>
			<div class="btns">
				<button @click="prev">上一张</button>
				<button @click="next">下一张</button>
			</div>		
		</div>
		<div class="right fr">
			<div class="h3 ml20 mt20">订单详情</div>
			<div class="ft20 ml20 mt20">订单id:{{order.odid}}</div>
			<div class="ft20 ml20 mt20">用户id:{{order.uid}} </div>
			<div class="ft20 ml20 mt20">拍品id:{{order.gid}} 拍品名：{{gname}}</div>
			<div class="ft20 ml20 mt20">成交时间:{{order.odtime}}</div>
			<div class="ft20 ml20 mt20">买家id:{{order.buyerid}}</div>
			<div class="ft20 ml20 mt20">卖家id:{{order.salerid}}</div>
			<div class="ft20 ml20 mt20">手续费:{{order.odfee}}</div>			
			<div class="ft20 ml20 mt20">地址id:{{order.aid}}</div>

			<div class="xqxq mt20 ml20">
				<div class="bot mt20 ft20 ftbc">成交金额：	{{order.odmoney}}</div>
			</div>
			<div class="xiadan ml20 mt20">
					<input class="jrgwc"  type="button" name="jrgwc" value="查看物流" />
					<input class="jrgwc" type="button" name="jrgwc" value="联系卖家" />
					<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=307081517&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1075930808:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	</div>
</template>
	

<style scoped>
			*{
				margin: 0;
				padding: 0;
			}
			.imgs{
				width: 400px;
				height: 600px;
				margin-left: 0 auto;
			}
			.imgs img{
				width: 500px;
				height: 400px;
			}
			.btns{
				width: 500px;
				margin: 20px auto;
			}
</style>
<script>

	//	 <img :src='"./vue/image/"+goodsImg'/>
	export default {
		data() {
			return {
				order:'',
				gname:'',
				imgList:[],
				num:0
			};
		},
		created:function(){
			this.getGoodsImg();
			this.getOrder();
		},
		methods: {
				//根据gid 返回图片
				getGoodsImg() { 
					//order传过来的参数					
					var gid=this.$route.params.gid;
			 		var self = this;
					this.$ajax.get("http://localhost:8080/goods/image",{
						params:{
							gid:gid
						}
					}).then(function(response) {					
						self.imgList=response.data.list[0].images;
						self.gname=response.data.list[0].gname;

					})
				},
				getOrder(){
					var self=this;
					var odid=this.$route.params.odid;
					this.$ajax.get("http://localhost:8080/orders/order",{
						params:{
							odid:odid
						}
					}).then(function(response) {					
						self.order=response.data;
					})
				},
				next:function(){
						this.num++
						if(this.num>this.imgList.length-1){
							this.num = 0
						}
					},
				prev:function(){
					this.num--
					if(this.num<0){
						this.num = this.imgList.length-1
					}
				}
			
				
		}
	}
	
</script>