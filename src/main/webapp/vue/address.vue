
<template>
  <div>
  	<!-- 展示已有地址-->
		<table class="table table-striped" >
        	 <thead>
	        	<tr>
	        		<th>地址ID</th>  
	        		<th>用户名</th>  
	        		<th>地址信息</th>
	        		<th>邮政编码</th>
	        		<th>手机号码</th>
	        		<th>操作</th>    
	        	</tr>
	        </thead>
	        <tbody>
	        	<tr v-for = "item in list" >
	        		<th>{{item.aid}}</th>
	        		<th>{{uname}}</th>
	        		<th>{{item.ainfo}}</th>
	        		<th>{{item.apost}}</th>
	        		<th>{{item.aphone}}</th>
	        		<th>
	        			<button class="btn" @click="del(item.aid)" :key="item.aid">删除</button>
	        			<button type="button" class="btn">
		        			<router-link to="/updateAddress/">
								修改
							</router-link>
	        			</button>
	        		</th>
	        	</tr>    
	        </tbody> 
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
	      	aid:"",
			u_aid:"",
			u_user:"",
			u_ainfo:"",
			u_apost:"",
			u_aphone:"",
			uname:"",
			list:[],
			address:"",
			mypage:[],
	    }
	  },
	created(){
			this.getUid();
		},
		methods:{
		    getUid(){
			    var self=this;
			   	this.$ajax.get("http://localhost:8080/users/isLogin").then(function(response) { 
			    	 self.uid=response.data.user.uid;
			    	 self.uname=response.data.user.uname;     
			    	 self.find(1);  
			     })
			    
			  },
			
			find(page){
		 		var self = this;
		 		var uid = self.uid;
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
				var self=this;
				self.$ajax.post("http://localhost:8080/addresses/"+aid)
				.then(function(){
					self.find(self.address.p);
				});
			},
			
			 
			pages(startPage,endPage){
				for(var i = startPage;i<=endPage;i++){
					this.mypage.push(i);
				}
				
			},
			edit(aid){
				this.$router.push({path:"updateAddress/"+aid});
			}
			
		}
	
	
	}
</script>

<style scoped>
#page{
		position:relative;
	}
</style>
