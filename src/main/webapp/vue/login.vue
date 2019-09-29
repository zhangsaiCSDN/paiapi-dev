<template>
	<div>
		登录界面<br />
		<router-link to="/register">去注册界面!!</router-link><br />
		<router-link to="/index">去首页!!</router-link>
	</div>

</template>

<style scoped>
	div {
		width:100%;
		height:300px;
		background-color:rgb(250,250,250);
		font-size: 30px;
		line-height: 300px;
		text-align: center;
	}
</style>


<script>
	export default {
		data() {
			return {
			};
		},
		methods: {
		}
	}
	
</script>