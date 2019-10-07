<template>
			<div>
			   
			        <!-- 模态框主体 -->
			        <div class="modal-body" text-aligh="center">
						<input type="file"  id="file"  multiple="multiple" />
						图片<br>
						
						
			        </div>
			   
			        <!-- 模态框底部 -->
			        <div class="modal-footer">
			       	<button class="btn btn-success" @click="upload" data-dismiss="modal" >添加</button>
					<button type="reset" class="btn btn-info" @click="">重置</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
			        </div>
		
			</div>
</template>

<script>
	export default{
		data(){
			return{
				
			};  
		}, 
		 
		methods:{
			upload(){
				var filess = new FormData();
			
				var photo = document.getElementById("file").files;
				
				filess.append("gid",1);
				filess.append("photo",photo);
				
				console.log(photo);
				
				var self = this; 
				this.$ajax.post("http://localhost:8080/images/all", filess).then(function(response) {
					self.$router.push({path:"/userGoods"});
					alert('添加成功!');
				})   
				
			}
		}
	}
	
</script>

<style>
</style>
