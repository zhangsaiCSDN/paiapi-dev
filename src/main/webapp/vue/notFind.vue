<template>
<div>
	<div class="search-reuslt">
		抱歉，没有找到与“{{search}}”相关的商品
	</div>
	<div class="search-reuslt">
		<span class="glyphicon glyphicon-star-empty">
			 <router-link to="/hotGoods"> 猜你喜欢</router-link>
			 <span class="glyphicon glyphicon-star-empty">
			</span>
		</span>
		
		<router-view></router-view>
	</div>
	<div id="danpin" class="danpin center">
			<div class="main center">
				<div class="mingxing fl" v-for="g in goods" @click="findOne(g.gid)">
					<div class="biaoqian">围观次数<br />{{g.gcount}}人</div>
					<div class="sub_mingxing"><router-link to="/goodsOne"><img  :src='"image/"+g.img' width="150px"/></router-link></div>
					<div class="pinpai"><a>{{g.gname}}</a></div>
					<div class="youhui">起拍时间:{{g.gstart}}</div>
					<div class="jiage">起拍价格:￥{{g.gprice}}起</div>
				</div>
	
			</div>
		</div>
</div>
</template>

<script>
	export default {
		data() {
			return {
				search: [],
				goods: [],
				gname:'',
				gstart:'',
				gend:'',
				gcount:'',
				gprice:'',
				img:''
				
			};
		},
		
		created(){
			this.getMessage();
		},
		
		methods:{
			getMessage(){
				this.search = this.$route.params.search;
			},
			likeGoods(){
				
			},
			
		methods:{
			findHotGoods() {
				var self = this;
				self.$ajax.get("http://localhost:8080/goods/findHotGoods")
				.then(function(response) {
					self.goods = response.data; 
				});
			},
			findOne(gid){
				this.$router.push({
					path: "goodsOne/" + gid
				});
			}
			
		}
		
		}
	}
</script>

<style scoped>
	.search-reuslt {
		padding: 20px 0 100px;	
		background: #f5f5f5;
		font-size:20px;
		text-align:center;
			
	}
	div {
		display: block;
	}
</style><template>
<div>
	<div class="search-reuslt">
		抱歉，没有找到与“{{search}}”相关的商品
	</div>
	<div class="search-reuslt">
		<span class="glyphicon glyphicon-star-empty">
			 <router-link to="/hotGoods"> 猜你喜欢</router-link>
			 <span class="glyphicon glyphicon-star-empty">
			</span>
		</span>
		
		<router-view></router-view>
	</div>
	<div id="danpin" class="danpin center">
			<div class="main center">
				<div class="mingxing fl" v-for="g in goods" @click="findOne(g.gid)">
					<div class="biaoqian">围观次数<br />{{g.gcount}}人</div>
					<div class="sub_mingxing"><router-link to="/goodsOne"><img  :src='"image/"+g.img' width="150px"/></router-link></div>
					<div class="pinpai"><a>{{g.gname}}</a></div>
					<div class="youhui">起拍时间:{{g.gstart}}</div>
					<div class="jiage">起拍价格:￥{{g.gprice}}起</div>
				</div>
	
			</div>
		</div>
</div>
</template>

<script>
	export default {
		data() {
			return {
				search: [],
				goods: [],
				gname:'',
				gstart:'',
				gend:'',
				gcount:'',
				gprice:'',
				img:''
				
			};
		},
		
		created(){
			this.getMessage();
		},
		
		methods:{
			getMessage(){
				this.search = this.$route.params.search;
			},
			likeGoods(){
				
			},
			
		methods:{
			findHotGoods() {
				var self = this;
				self.$ajax.get("http://localhost:8080/goods/findHotGoods")
				.then(function(response) {
					self.goods = response.data; 
				});
			},
			findOne(gid){
				this.$router.push({
					path: "goodsOne/" + gid
				});
			}
			
		}
		
		}
	}
</script>

<style scoped>
	.search-reuslt {
		padding: 20px 0 100px;	
		background: #f5f5f5;
		font-size:20px;
		text-align:center;
			
	}
	div {
		display: block;
	}
</style>