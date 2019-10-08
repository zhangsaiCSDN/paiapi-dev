<template>
	<div>
		<!-- start header -->  
			<!-- 原来黑色的顶部导航 已移动到index.vue中 -->
		<!--end header -->  
 
		<!-- announce --> 
		<div class="announce">
			<transition name="slide">
				<p class="text" :key="text.id" style="color: #ec7259;">{{text.val}}</p>
			</transition>
		</div>

		<!-- start banner_x -->
		<div class="banner_x center">
			<router-link to="/index">
				<div class="logo fl"></div>
			</router-link>
			<div class="nav fl">
				<ul>
     <li>
      <router-link to="/hotProducts">热门拍品</router-link>
     </li>
     <li>
      <router-link to="/collection">我的收藏</router-link>
     </li>
     <li>
      <router-link to="/global">全球拍</router-link>
     </li>
     <li>
      <router-link to="/limiteTime">限时拍</router-link>
     </li>
     <li>
      <router-link to="/beforeSell">预展</router-link>
     </li>
     <li>
      <router-link to="/follow">一降到底</router-link>
     </li>
     <li>
      <router-link to="/help">帮助</router-link>
     </li>
     
    </ul>
			</div>
			<div class="search fr">
				<form >
					<div class="text fl">
						<input type="text" v-model="ga" class="shuru" placeholder="区域" id="searchId2" style="width:50%;float:left;"/>
						<input type="text" v-model="g" class="shuru" placeholder="拍品名称" id="searchId" style="width:50%;" />
					</div>
					<div class="submit fl">
						
							<input class="sousuo" type="button" value="搜索" @click="searchBtn"  />
						
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
		<!-- end banner_x -->

		<!--组件切换用-->

		<div>
			<router-view ref="xx"></router-view>
		</div>

		<footer class="mt20 center" style="clear:both;">  
			<div>违法和不良信息举报电话：110，本网站所列数据，除特殊说明，所有数据均出自蜗牛拍拍项目组测试</div>
		</footer>

	</div>
</template>

<style scoped>
</style>

<script>
	export default {
		data() {
			return {
				announces: [],
				number: 0,
				goods:[],
				search:'',
				g:"",
				ga:""
			};
		},
		computed: {
			text() {
				return {
					id: this.number,
					val: this.announces[this.number]
				}
			}
		},
		created: function() {
			var self = this;
			this.$ajax.get("http://localhost:8080/announces/findAll").then(function(response) {
				for (var i in response.data) {
					self.announces.push("拍拍网公告：" + response.data[i].ancontent);
				}
			})
		},
		mounted: function() {

			this.startMove()
		},
		methods: {
			enterUserCenter() {
				this.$router.push('userCenter');
			},
			startMove() {
				// eslint-disable-next-line
				let timer = setTimeout(() => {
					if (this.number === this.announces.length) {
						this.number = 0;
					} else {
						this.number += 1;
					}
					this.startMove();
				}, 5000); // 滚动不需要停顿则将2000改成动画持续时间
			},
			searchBtn(){
				
					// this.$router.replace("/list");
					var path=this.$route.path;
					var g=this.g;
					var ga=this.ga;
					if(path!="/list"){
						
						this.$router.replace("/list");
					}else{
					
						this.$refs.xx.goodsFind(g,ga);
					}
				
				
				
				
			}
		}
	}
</script>
