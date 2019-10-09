<template>
	<!-- goodsHistory -->
	<div>
		<div>
		<div class="rtcont fr">
			<div class="ddzxbt">我的拍品记录</div>
			
			<!--循环获取数据-->
			<div class="ddxq" v-for="item in ghistoryList">
				
				<div class="ddbh fl">《{{item.goods.gname}}》{{item.ghdes}}</div>
				<div class="ztxx fr">
					<ul>
						<li>
							<a v-if="item.paystate==0" @click="pay(item)">待付款</a>
							<a v-if="item.paystate==1" >已付款</a>
							</li>
						<li>¥{{item.ghmoney}}</li>
						<li>{{item.ghdeadline.substring(5)}}</li>
						<li><router-link :to='"goodsOne/"+item.gid'>订单详情></router-link></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
				
			</div>
			
			
			<div>
			<span >
					{{v_page.p}}/{{v_page.maxPage}}
					<button @click='findAll(1)'>首页</button>
					<button @click='findAll(v_page.prev)' >上一页</button>
					<span v-for="i in v_pages"> <span v-if="i==v_page.p"
						><font color="red">{{i}}</font></span> <span
						@click='findAll(i)' v-if="!(i==v_page.p)" 
						style="cursor: pointer"><font>{{i}}</font></span>
					</span>
					<button @click='findAll(v_page.next)' >下一页</button>
					<button @click='findAll(v_page.maxPage)'>末页</button>
				</span>		
			</div>
		</div>
		<div class="clear"></div>
		</div>
		
		
	</div>
</template>
	

<style scoped>

</style>

<script>
	export default{
	data(){
		return{
			"ghistoryList":[],
			"v_page":"",
			"username":"",
			"user":"",
			"uid":"",
		};
	},
	mounted:function(){
		this.isLogin();
	},
	methods:{
		pay(gh){
			var self = this;
			this.$router.push("/message/"+gh.gid+"/"+gh.ghmoney);
		},
		async isLogin() {
			var self = this;
				var result = await this.$ajax.get('http://localhost:8080/users/isLogin');
				self.username = result.data.username;
				self.uid = result.data.user.uid;
				self.findAll(1);
			},
		findAll(page){
			var self = this;
			this.$ajax.get("http://localhost:8080/ghistorys/findByUserCenter",{
			params:{
					p:page,
					buyerid:self.uid
				}
			}).then(function(response) {
				self.ghistoryList = response.data.list;
				self.v_page = response.data;
			})
		}
	}
}
</script>
