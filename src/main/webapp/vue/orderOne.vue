<template>
	<div>

	<div class="jieshao mt20 w">
		<!-- 图片 -->
		<div class="left fl">		
			<div class="imgs" v-for="(item,index) in imgList" v-if="index==num">
				 <img :src='"../admin/goods/goodsImg/"+item.img' @click="prev"/>
				<button @click="prev"  class="btn btn-success">上一张</button>
				<button @click="next"   class="btn btn-success">下一张</button>
			</div>
	
		</div>
		<!-- 右侧 -->
		<div class="right fr" >
		<table class="table table-striped" id="tab">
		  <thead>
		    <tr >
		      <th colspan="2"><h3>订单详情</h3></th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>订单id</td>
		      <td>{{order.odid}}</td>
		    </tr>
		    <tr>
		      <td>用户id</td>
		      <td>{{order.uid}}</td>
		    </tr>
		    <tr>
		      <td>拍品名</td>
		      <td>{{gname}}</td>
		    </tr>
		    <tr>
		      <td>成交时间</td>
		      <td>{{order.odtime}}</td>
		    </tr>
		    <tr>
		      <td>买家id</td>
		      <td>{{order.buyerid}}</td>
		    </tr>
		    <tr>
		      <td>卖家id</td>
		      <td>{{order.salerid}}</td>
		    </tr>
		    <tr>
		      <td>手续费</td>
		      <td>{{order.odfee}}</td>
		    </tr>
		    <tr>
		      <td>地址</td>
		      <td>{{address}}</td>
		    </tr>
		    <tr>
		      <td class="bot mt20 ft20 ftbc">成交金额</td>
		      <td><span class="bot mt20 ft20 ftbc">{{order.odmoney}}</span></td>
		    </tr>
		  </tbody>
		</table>
			
			<div class="xiadan ml20 mt20">
					<input class="jrgwc" type="button" name="jrgwc" value="联系卖家"  @click="touch"/>
					<input class="jrgwc" type="button" name="jrgwc" value="查看物流"  @click="logistics"/>
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
				width: 550px;
				height: 530px;
			}
			.jieshao .left {
			    width: 550px;
			    height: 530px;
			}

			.jieshao .right {
			    width: 650px;
			    background: rgb(255,255,255);
			    height: 600px;
			}
			#tab td{
				height:52px
			}
			button{
				width:100px
			}
			.xiadan .jrgwc {
			    height: 54px;
			    width: 207px;
			    border: none;
			    background: FF0036;
			    color: #fff;
			    font-size: 25px;
			    font-weight: bold;
			    cursor: pointer;
			    margin-right: 50px;
			    border-radius:15px;
			}
			
</style>
<script>

	export default {
		data() {
			return {
				order:'',
				gname:'',
				imgList:[],
				num:0,
				tel:'',
				address:''
			};
		},
		created:function(){
			this.getGoodsImg();
			this.getOrder();
			this.getUser();			
		},
		beforeUpdate:function(){
			this.getAddress();
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
				getUser(){
					var self=this;
					var uid=1; //传过来的
					this.$ajax.get("http://localhost:8080/users/"+uid).then(function(response) {	
						self.tel=response.data.tel;			
					})
					
				},
				touch(){
					location.href="http://localhost:8080/talk/talk.html";
				},
				logistics(){
					alert("等待卖家发货");
				},
				getAddress(){
					var self=this;
					var aid=self.order.aid;
					this.$ajax.get("http://localhost:8080/addresses/"+aid).then(function(response) {	
						self.address=response.data.ainfo;			
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