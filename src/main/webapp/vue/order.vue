<template>

<div>
	<!-- self_info -->
	<div>
		<div >

		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			
			<div class="ddxq" v-for="order in orders.list"> 
				<div class="ddspt fl"><img src="./image/gwc_xiaomi6.jpg" alt=""></div>
				<div class="ddbh fl">交易ID:{{order.odid}}</div>
				<div class="ztxx fr">
					<ul>
						<li>价格：￥{{order.odmoney}}</li>
						<li>卖家id：{{order.salerid}}</li>
						<li>{{order.odtime}}</li>									
						<li><a @click="orderOne(order.goods.gid,order.odid)">订单详情</a></li>															
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
				<span >
					{{orders.p}}/{{orders.maxPage}}
					<button @click='find(1)'>首页</button>
					<button @click='find(orders.prev)' >上一页</button>
					<span v-for="i in v_pages"> <span v-if="i==orders.p"
						><font color="red">{{i}}</font></span> <span
						@click='find(i)' v-if="!(i==orders.p)" 
						style="cursor: pointer"><font>{{i}}</font></span>
					</span>
					<button @click='find(orders.next)' >下一页</button>
					<button @click='find(orders.maxPage)'>末页</button>
				</span>		
		</div>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
</div>
</template>

<style scoped>

</style>

<script>
	export default {
		data() {
			return {
				"orders":[],
				v_pages:[],
			};
		},
		created:function(){
			this.find(1);  
		},
		methods: {
				//分页展示
				find(page) { 
			 		var self = this;
					this.$axios.get("http://localhost:8080/orders/findByUid",{
						params:{
							p:page
						}
					}).then(function(response) {
						self.orders = response.data; 
						self.v_pages=[];
						self.pages(self.orders.startPage,self.orders.endPage);
					})
				},
				
				/*分页页码数据  */
				pages(startPage,endPage){
					var self=this;
					for(var i=startPage;i<=endPage;i++){
						self.v_pages.push(i);
					};
				},
				orderOne(gid,odid){
					this.$router.push({
						path:"orderOne/"+gid+"/"+odid
					});
				}
		}
	}
	
</script>