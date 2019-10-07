
<template>
  <div>
  	<!-- 展示已有地址-->
		<table id="LAY-user-manage" class="table table-striped" >
        	<tr>
        		<th>用户ID</th>  
        		<th>用户名</th>  
        		<th>地址信息</th>
        		<th>邮政编码</th>
        		<th>手机号码</th>
        		<th>操作</th>    
        	</tr>
        	<tr v-for = "item in list" >
        		<th>{{item.aid}}</th>
        		<th>{{item.user.uname}}</th>
        		<th>{{item.ainfo}}</th>
        		<th>{{item.apost}}</th>
        		<th>{{item.aphone}}</th>
        		<th>
        			<button class="btn btn-danger" @click="del(item.aid)" :key="item.aid">删除</button>
        			<button type="button" class="btn btn-success">
	        			<router-link to="/updateAddress">
							修改
						</router-link>
        			</button>
        		</th>
        	</tr>
        	</table>
        	<div class="rtcont fr">
			<div style="vertical-align: middle !important; text-align: center;" id="page">				
				<span id="page">
					<button class="btn btn-info" @click="find(1)">首页</button>
 					 <button class="btn btn-info" @click="find(address.prev)">上页</button>
 					 <span v-for="i in mypage">
 					 	<span v-if="i==address.p" class="btn"><font  color="red">{{i}}</font></span>
						<span @click='find(i)' v-if="!(i==address.p)" class="btn"><font >{{i}}</font></span>
 					 </span>
 					  <a>第{{address.p}}页 / 共{{address.maxPage}}页</a>
 					 <a >共{{address.rowCount}}条记录</a>
 					 <button class="btn btn-info" @click="find(address.next)">下页</button>
 					 <button class="btn btn-info" @click="find(address.maxPage)">末页</button>
				</span>		
			</div>
				<router-link to="/addAddress" class="btn btn-info">
					点击 添加地址
				</router-link>
		</div>
        
  </div>
</template>

<script>

	export default {
	  data() {
	    return {
	      	uid:"",
			u_aid:"",
			u_user:"",
			u_ainfo:"",
			u_apost:"",
			u_aphone:"",
			list:[],
			address:"",
			mypage:[],
	    }
	  },
	  mounted: function() {
		},
		created(){
				this.find(1);
			},
			methods:{
				find(page){
					var uid=this.$route.params.uid
			 		var self = this;
					this.$ajax.get("http://localhost:8080/addresses/findByUid",
							{params:{
									p:page,
									uid:uid
									}
						}).then(function(response){
						self.address = response.data;
						self.list = response.data.list;
						self.mypage = [];
						self.pages(self.address.startPage,self.address.endPage);
					});
				},
				
				del(aid){
					this.$ajax.post("http://localhost:8080/addresses",{"aid":aid,"_method":"delete"},{emulateJSON:true}).then(function(){
						this.find(this.address.p);
					});
				},
				pages(startPage,endPage){
					for(var i = startPage;i<=endPage;i++){
						this.mypage.push(i);
					}
					
				}
				
			}
	
	
	}
</script>

<style scoped>
#page{
		position:relative;
	}
</style>
