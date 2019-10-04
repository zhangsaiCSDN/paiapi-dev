<template>
	<div>
	<!-- start header -->
	<header>
		<div class="top center">
			<div class="left fl">
				<ul>
					<li><a href="http://www.mi.com/" target="_blank">拍拍商城</a></li>
					<li>|</li>
					<li><a href="">MIUI</a></li>
					<li>|</li>
					<li><a href="">游戏</a></li>
					<li>|</li>
					<li><a href="">多看阅读</a></li>
					<li>|</li>
					<li><a href="">云服务</a></li>
					<li>|</li>
					<li><a href="">金融</a></li>
					<li>|</li>
					<li><a href="">拍拍网移动版</a></li>
					<li>|</li>
					<li><a href="">问题反馈</a></li>
					<li>|</li>
					<li><a href="">切换商家版</a></li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="right fr">
				<div class="gouwuche fr"> <span @click="enterUserCenter">个人中心</span></div>
				<div class="fr">
					<ul>
						<li><router-link to="/login">登录</router-link></li>
						<li>|</li>
						<li><a href="./register.html" target="_blank" >注册</a></li>
						<li>|</li>
						<li><a href="">消息通知</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<!--end header -->
	
	<!-- announce -->
	<div class="announce">
		<transition name="slide">
       		<p class="text" :key="text.id">{{text.val}}</p>
      	</transition>	
	</div>
	
	<!-- start banner_x -->
	<div class="banner_x center">
		<router-link to="/index"><div class="logo fl"></div></router-link>
		<div class="nav fl">
			<ul>
				<li><router-link to="/hotProducts">热门拍品</router-link></li>
				<li><router-link to="/beforeSell">即将开拍</router-link></li>
				<li><router-link to="/follow">我的关注</router-link></li>
				<li><router-link to="/collection">我的收藏</router-link></li>
				<li><router-link to="/limiteTime">限时拍</router-link></li>
				<li><router-link to="/global">全球拍</router-link></li>
				<li><router-link to="/help">帮助</router-link></li>
			</ul>
		</div>
		<div class="search fr">
			<form action="" method="post">
				<div class="text fl">
					<input type="text" class="shuru"  placeholder="瓷器专场">
				</div>
				<div class="submit fl">
					<router-link to="/list"><input class="sousuo" value="搜索"/></router-link>
				</div>
				<div class="clear"></div>
			</form>
			<div class="clear"></div>
		</div>
	</div>
	<!-- end banner_x -->
	
	<!--组件切换用-->
	
	<div >
		<router-view></router-view>
	</div>	
	
	<footer class="mt20 center">			
		<div>?mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
		<div>违法和不良信息举报电话：110，本网站所列数据，除特殊说明，所有数据均出自蜗牛拍拍项目组测试</div>
	</footer>
	
</div>
</template>

<style scoped>
</style>
	
<script>

export default{
	data(){
		return{
			textArr:[
				'第一条公告：距离清乾隆花瓶开拍还有一个小时~~~~~~~~~~~~~~~~~~~~~~',
				'第二条公告：距离清乾隆花瓶开拍还有一个小时~~~~~~~~~~~~~~~~~~~~~~',
				'第三条公告：距离清乾隆花瓶开拍还有一个小时~~~~~~~~~~~~~~~~~~~~~~',
				'第四条公告：距离清乾隆花瓶开拍还有一个小时~~~~~~~~~~~~~~~~~~~~~~',
				'第五条公告：距离清乾隆花瓶开拍还有一个小时~~~~~~~~~~~~~~~~~~~~~~',
			],
			announces:[],
			number:0
		};
	},
	computed: {
    	text () {
       		return {
	        	id: this.number,
	        	val: this.announces[this.number]
     		}
   		}
  	},
  	created:function(){
  		var self=this;
		this.$axios.get("http://localhost:8080/announces/findAll").then(function(response){
			for(var i in response.data){
				self.announces.push("拍拍网公告："+response.data[i].ancontent);
			}
		})
  	},
	mounted:function(){
		
		this.startMove()
	},
	methods:{
		enterUserCenter(){
			console.log("hahahahq23333");
			this.$router.push('userCenter');
		},
		startMove () {
	      	// eslint-disable-next-line
	     	let timer = setTimeout(() => {
		        if (this.number === this.announces.length) {
		          this.number = 0;
		        } else {
		          this.number += 1;
		        }
		        this.startMove();
		      }, 2000); // 滚动不需要停顿则将2000改成动画持续时间
	    }
	}
}


</script>