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
				<input type="text" class=" form-control" name="odfee" v-model="$route.params.money*0.01>20?$route.params.money*0.01:20.0" onfocus=this.blur() />
			</div>
			<label>地址id:</label>
			<select v-model="myaid" class="form-control">
				<option v-for="item in adds" :value="item.aid">{{item.aid}}.{{item.ainfo}},邮编{{item.apost}},电话{{item.aphone}}</option>
			</select>
			<label>未找到地址?<router-link to="">点击新增</router-link></label>
			<div>
				共1000元,<button type="button" class="btn btn-success btn-block" @click="pay()">付款</button>
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
				adds:[]
			};
		},
		mounted() {
				// 初始化
				var self = this;
				this.$ajax.get("http://localhost:8080/goods/findOne?gid="+this.$route.params.gid).then(
					function(response){
						self.goods=response.data;
					}
				);
				
				
				this.$ajax.get('http://localhost:8080/users/isLogin').then(function(response){
					self.uid = response.data.user.uid;
					self.$ajax.get('http://localhost:8080/addresses/findByUid?uid='+self.uid).then(function(response){
						self.adds = response.data;
					});
				});
		},
		methods:{
			
			pay: function() {
					var self = this;
					alert(self.myaid);
					$.ajax({
				        type : 'post',
				        url : "http://localhost:8080/orders/pay",
				        data:{
				        	gid:self.$route.params.gid,
							odmoney:self.money,
							buyerid:self.uid,
							salerid:self.goods.salerid,
							odfee:self.money*0.01>20?self.money*0.01:20,
							odtime:self.goods.gend,
							uid:self.goods.salerid,
							aid:self.myaid
				        },
				        traditional : true,
				        async : false,         
				    });    
				}
		}
	}
		
</script>