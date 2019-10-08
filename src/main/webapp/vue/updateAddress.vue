<template>

	<div>
		<input type="hidden" width="17%" v-model="this.addr.aid"/>
		详细地址:<br><input type="text" class="form-control" width="17%" v-model="this.addr.ainfo" /><br />
		邮政编码:<br><input type="text" class="form-control" width="17%"  v-model="this.addr.apost"/><br />
		手机号码:<br><input type="text" class="form-control" width="17%" v-model="this.addr.aphone" /><br />
		<button class="btn btn-success btn-block" @click="update" >更新</button>
	</div>
</template>

<style scoped>
	
</style>

<script>

	export default {
		data() {
			return {
				aid:this.$route.query.aid,
				addr:'123'
			};
		},
		created(){
		var self =  this;
			$.ajax({
				type:"get",
				url:"http://localhost:8080/addresses/"+this.aid,
				async:false,
				success:function(data){
					self.addr = data;
				}
			});
		},
		methods: {
			update(){
			var json={"aid":self.aid,"ainfo":self.addr.ainfo,"apost":self.addr.apost,"aphone":self.addr.aphone,"_method":"put"};
					$.ajax({
					type:"post",
					url:"http://localhost:8080/addresses/",
					data:json,
					async:false,
					success:function(){
						alert("修改成功")
						this.$router.push("/address");
					}
			});
			}
		}
	}
</script>