<template>

<div>
	<!-- self_info -->
	<div>
		<div >
	<table class="table table-striped" >
	  <thead>
	    <tr>
	      <th>交易id</th>
	      <th>拍品名</th>
	      <th>价格</th>
	      <th>交易时间</th>
	      <th>详细信息</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr v-for="order in orders.list">
	      <td>{{order.odid}}</td>
	      <td>{{order.goods.gname}}</td>
	      <td>￥{{order.odmoney}}</td>
	      <td>{{order.odtime}}</td>
	      <td><a @click="orderOne(order.goods.gid,order.odid)">订单详情</a></td>
	    </tr>
	    <tr>

	    </tr>
	  </tbody>
	</table>
	
		<div class="rtcont fr">
			<div style="vertical-align: middle !important; text-align: center;" id="page">				
				<span id="page">
					{{orders.p}}/{{orders.maxPage}}
					<button @click='find(1)' class='btn'>首页</button>
					<button @click='find(orders.prev)'class='btn' >上一页</button>
					<span v-for="i in v_pages" > <span v-if="i==orders.p"
						><font color="red" >{{i}}</font></span> <span
						@click='find(i)' v-if="!(i==orders.p)" 
						style="cursor: pointer"><font>{{i}}</font></span>
					</span>
					<button @click='find(orders.next)' class='btn'>下一页</button>
					<button @click='find(orders.maxPage)' class='btn'>末页</button>
				</span>		
			</div>
		</div>
		</div>
	</div>
<!-- self_info -->
</div>
</template>

<style scoped>
	#page{
		position:relative;
	}
</style>

<script>
	export default {
		data() {
			return {
				"orders":[],
				v_pages:[],
				uid:''
			};
		},
		created:function(){
			this.getUid();
		},
		methods: {
				async getUid(){
			     var self=this;
			   	await this.$ajax.get("http://localhost:8080/users/isLogin").then(function(response) { 
			    	 self.uid=response.data.user.uid;   
			    	 self.find(1);  
			     })
			    
			    },
				//分页展示 uid是传入的买家id
				find(page) { 
					//var uid=this.$route.params.uid
			 		var self = this;
					var uid=self.uid;
					this.$ajax.get("http://localhost:8080/orders/findByUid",{
						params:{
							p:page,
							uid:uid
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
						path:"/orderOne/"+gid+"/"+odid
					});
				}
		}
	}
	
</script>