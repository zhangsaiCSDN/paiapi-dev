<template>
	<!-- userInfo -->
	<div>
		<div class="rtcont fr">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>name</span><span>{{user.username}}</span></div>
			<div class="subgrzl ml40"><span>cellphone</span><span>{{user.user.tel}}</span></div>
			<div class="subgrzl ml40"><span>regTime</span><span>{{user.user.regtime}}</span></div>
			<div class="subgrzl ml40"><span>status</span><span>{{user.user.ustate==1?"可出价用户":(user.user.ustate==2?"冻结":"正常")}}</span></div>
			
			
			
			
		</div>
	</div>
</template>
	

<style scoped>

</style>

<script>
	export default{
	data(){
		return{
		user:""
		};
	},
	mounted:function(){
		this.isLogin();
		
	},
	methods:{
			async isLogin() {
				var self = this;
				var result = await this.$ajax.get('http://localhost:8080/users/isLogin');
				self.user = result.data;
				
				
			}
			
	}
}
</script>
