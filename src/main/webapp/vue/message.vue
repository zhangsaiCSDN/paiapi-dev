<template>
	<div>
		<form class="form-group">
			<div>
				<div>
					 <label>用户id: </label>
				</div>
				<div>
					<input type="text" class=" form-control" name="uid" v-model="uid" onfocus=this.blur() />
				</div>
			</div>
			<div>
				<label>商品id:</label>
				<input type="text" class=" form-control" name="gid" v-model="$route.params.gid" onfocus=this.blur() />
			</div>
			<div>
				<label>买家id:</label>
				<input type="text" class=" form-control" name="buyerid" v-model="uid" onfocus=this.blur() />
			</div>
			<div>
				<label>卖家id:</label>
				<input type="text" class=" form-control" name="salerid" v-model="goods.salerid" onfocus=this.blur() />
			</div>
			<div>
				<label>成交金额:</label>
				<input type="text" class=" form-control" name="odmoney" v-model="$route.params.money" onfocus=this.blur() />
			</div>
			<div>
				<label>成交时间:</label>
				<input type="text" class=" form-control" name="odtime" v-model="goods.gend" onfocus=this.blur() />
			</div>
			<div>
				<label>手续费:</label>
				<input type="text" class=" form-control" name="odfee" v-model="odfee" onfocus=this.blur() />
			</div>
			<label>地址id:</label>
			<select v-model="myaid" class="form-control">
				<option v-for="item in adds" :value="item.aid">{{item.aid}}.{{item.ainfo}},邮编{{item.apost}},电话{{item.aphone}}</option>
			</select>
			<label>未找到地址?<span @click="add(goods.gid,odmoney)">点击新增</span></label>
			<div>
				共{{sum}}元,<button type="button" class="btn btn-success btn-block" @click="pay()">付款</button>
			</div>
		</form>
	</div>
</template>

<style scoped>
	
</style>

<script>
	export default {
		data() {
			return {
				gid:'',
				goods:'',
				uid:'',
				myaid:'',
				odfee:'',
				sum:'',
				odmoney:'',
				adds:[]
			};
		},
		mounted() {
				// 初始化
				var self = this;
				this.$ajax.get("http://localhost:8080/goods/findOne?gid="+this.$route.params.gid).then(
					function(response){
						self.goods=response.data;
						self.odmoney=self.$route.params.money;
						self.odfee=self.$route.params.money*0.01>20?self.$route.params.money*0.01:20;
						self.sum=parseFloat(self.odmoney)+parseFloat(self.odfee);
						
					}
				);
				
				
				this.$ajax.get('http://localhost:8080/users/isLogin').then(function(response){
					self.uid = response.data.user.uid;
					self.$ajax.get('http://localhost:8080/addresses/findByUid?uid='+self.uid).then(function(response){
						self.adds = response.data.list;
					});
				});
		},
		methods:{
			
			pay: function() {
					var self = this;
					$.ajax({
				        type : 'post',
				        url : "http://localhost:8080/orders/pay",
				        data:{
				        	gid:self.$route.params.gid,
							odmoney:self.$route.params.money,
							buyerid:self.uid,
							salerid:self.goods.salerid,
							odfee:self.$route.params.money*0.01>20?self.$route.params.money*0.01:20,
							odtime:self.goods.gend,
							uid:self.goods.salerid,
							aid:self.myaid
				        },
				        traditional : true,
				        async : false,  
				        successs:function(){
				        	
				        }       
				    });
				   
				   window.location = 'http://47.111.31.86:8080/xapaipaipay?orderName='+self.goods.gname+'&&money='+self.sum+'&&ginfo='+self.goods.ginfo;
			},
			add(gid,odmoney){
				var self = this;
				this.$router.push({
					path:"/addAddress2/"+gid+"/"+odmoney
				});
			
			
			}
		}
	}
		
</script>