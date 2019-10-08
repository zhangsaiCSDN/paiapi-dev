<template>
	<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center" >
					<div class="sub_top fl">
						批量操作
					</div>
					<div class="sub_top fl">收藏时间</div>
					<div class="sub_top fl " >藏品价格</div>
					<div class="sub_top fl">用户名称</div>
					<div class="sub_top fl">藏品名称</div>
					<div class="sub_top fr" style="margin-right: 88px;">操作</div>
					<div class="clear"></div>
				</div>
				<div v-for="collect in collects.list" class="content2 center" >
					<div class="sub_content fl ">
						<input  type="checkbox" v-model="checkedNames" :value="collect" class="quanxuan" />
					</div>
					<div class="sub_content fl"><img src=""></div>
					<div class="sub_content fl ">{{collect.cltime}}</div>
					<div class="sub_content fl m-le" >{{collect.goods.gprice}}元</div>
					
					<div class="sub_content fl" >{{collect.user.uname}}</div>
						<div class="sub_content fl" >{{collect.goods.gname}}</div>
					
					<div class="sub_content fl">
						<button type="button" @click="del(collect.clid)" class="btn btn-warning">
							删除
						</button>
					</div>
					
					<div class="clear"></div>
				</div>
				
			</div>
			
			
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li>
							<input type="checkbox" v-model="checked" @change="changeAllChecked()" class="quanxuan" />全选
						</li>
						<li>|</li>
						<li>共{{count}}条记录</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">共计：<span>{{countMoney}}元</span></div>
					<div class="jsanniu fr">
							<button @click="qx()" class="jsan btn btn-danger">
								支付
							</button>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
			
			
			
			<div class="ok">
			
				<button @click='find(1)' class="btn btn-outline-primary">首页</button>
									<button @click='find(collects.prev)' class="btn btn-warning">上一页</button>
									<span v-for="i in v_pages">
									<span v-if="i==collects.p" class="btn"><font color="red">{{i}}</font></span>
									<span @click='find(i)' v-if="!(i==collects.p)" class="btn"><font>{{i}}</font></span>
									</span>
									<button @click='find(collects.next)'  class="btn btn-outline-primary">下一页</button>
									<button @click='find(collects.maxPage)'
										class="btn btn-outline-primary">末页</button>
				
				</div>
				
		</div>
	
</template>

<script>
	 
	export default {
			data() {
				return {
					v_pages:[],
					collects:[],
					sun:'',
					checkedNames:[],
					checked:false,
					count:'',
					countMoney:0
					
				};
			},
			watch: {
				"checkedNames": function() {
					this.count = this.checkedNames.length;
					
					this.countMoney=0;
					
					
					for(var i in this.checkedNames){
					console.log(this.checkedNames[i]);
						this.countMoney =+this.countMoney  + +this.checkedNames[i].goods.gprice+'';
					}
					
					if (this.checkedNames.length == this.collects.length) {
						this.checked = true
					} else {
						this.checked = false
					}
				}
			},
			methods:{
				
			find(page){
				var self=this;
				this.$ajax.get("http://localhost:8080/collects",{
					params:{
						p:page
					}
				}).then(function(response){
					self.collects =response.data;
					self.v_pages=[];
					self.pages(self.collects.startPage,self.collects.endPage);
				})
			},
				
					/*分页页码数据  */
				pages(startPage,endPage){
					var self=this;
					for(var i=startPage;i<=endPage;i++){
						self.v_pages.push(i);
					};
				},
				
				
				//全选方法
				changeAllChecked: function() {
							if (this.checked) {
								this.checkedNames = this.collects.list
							} else {
								this.checkedNames = []
							}
						},
				
					/*删除  */
				del(clid){
				
				
				
				var self=this;
				this.$ajax.delete("http://localhost:8080/collects?clid=" + clid).then(function(response){
					alert('删除成功!'); 
					self.find(self.collects.p)
				})
				
				
				
				
			},
				qx(){
					var self=this
					this.$ajax.put("http://localhost:8080/deposits/updateList",{
							'list':self.checkedNames
						}).then(function(response){
							self.find(self.page.p);
							alert(response.data);
					})
					
				},
				
				edit(item){
					 var self=this;
					
					 this.$ajax.put("http://localhost:8080/deposits",{
					 		did:item.did,
							gid:item.gid,
					 		uid:item.uid,
					 		dmoney:0,
					 		gstate:4
					 		
					 	
					 	}).then(function(response){
					 		self.find(self.page.p);
					 		alert(response.data);
					 })
				}
				
				
			},	
			del(clid){
			var self=this;
				this.$ajax.delete("http://localhost:8080/collects?clid=" + clid).then(function(response){
					alert('删除成功!'); 
					self.find(self.collects.p)
				})
			
			
			
			},
				
			mounted:function(){
				this.find(1)
			},
			
		}
	
	
	
	
	
</script>

<style scoped>
	
/*我的购物车*/
.banner_x .wdgwc{height: 100px;line-height: 100px;font-weight:bold;font-size: 24px;}
.banner_x .wxts{height: 90px;line-height: 105px;font-size: 12px;color:#777;}
.banner_x .dlzc{height: 100px;line-height: 100px;}
.banner_x .dlzc ul li{float: left;font-size: 12px;}
.banner_x .dlzc ul li a{display:block;padding:0 8px;font-size: 12px;font-family: Times New Roman;color: #777;}
.banner_x .dlzc ul li a:hover{color:#ff6700; }
.xiantiao{width: 100%;height: 2px;background:#ff6700; }
/*购物车详单*/
.gwcxqbj{width: 100%;height:400px;background: rgb(245,245,245);padding-bottom: 20px;}
.gwcxqbj .gwcxd{background: #fff;width: 1226px;height: auto;padding-top: 30px;}
.gwcxqbj .gwcxd .top2{width:1226px;height: 70px;}
.gwcxqbj .gwcxd .top2 .sub_top{width: 100px;height: 70px;line-height:36px;margin-right: 0px;margin-top:0px;margin-left: 30px;}
.gwcxqbj .gwcxd .top2 .sub_top:nth-of-type(2){margin-left: 100px;}
.gwcxqbj .gwcxd .top2 .sub_top:nth-of-type(3){margin-left: 100px;}
.gwcxqbj .gwcxd .top2 .sub_top:nth-of-type(4){margin-left: 100px;}
.gwcxqbj .gwcxd .top2 .sub_top:nth-of-type(5){margin-left: 79px;}
.gwcxqbj .gwcxd .top2 .sub_top .quanxuan{width:18px;height:18px;border:1px solid #ccc;background: none;}
.gwcxqbj .gwcxd .content2{width:1226px;height: 120px;border-top: 1px solid #ccc;}
.gwcxqbj .gwcxd .content2 .sub_content{width:50px;height: 120px;line-height:120px;margin-right: 0px;}
.gwcxqbj .gwcxd .sub_content .quanxuan{width:18px;height:18px;border:1px solid #ccc;background: none;}
.gwcxqbj .gwcxd .content2 .sub_content img{vertical-align: middle;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(1){margin-left: 30px;} 
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(2){margin-left: 35px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(3){margin-left: 78px;width: 100px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(4){margin-left: 85px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(5){margin-left: 140px;width: 90px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(6){margin-left: 100px;width: 80px;color:#ff6700;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(7){margin-left: 156px;font-size: 25px;}
.gwcxqbj .gwcxd .content2 .sub_content .shuliang{width: 70px;height: 35px;border:2px solid #ccc;text-align: center;font-size:16px;color:#ff6700;}
.gwcxqbj .gwcxd .content2 .sub_content a{display: block;width: 20px;height: 20px;border-radius: 10px;color:#000;}
.gwcxqbj .gwcxd .content2 .sub_content a:hover{color:#ff6700;}
.gwcxqbj .gwcxd .content2 .sub_content[data-v-e7bd4f56]:nth-of-type(3){width:150px;}
.gwcxqbj .gwcxd .content2 .sub_content[data-v-e7bd4f56]{width:60px;}
.gwcxqbj .gwcxd .top2 .sub_top[data-v-e7bd4f56]:nth-of-type(2){margin-left:153px;}
.gwcxqbj .gwcxd .top2 .sub_top[data-v-e7bd4f56]:nth-of-type(4){margin-left:109px;}
.gwcxqbj .gwcxd .top2 .sub_top[data-v-e7bd4f56]:nth-of-type(5){margin-left:64px;}
.ok{margin-left:300px;}
.11{margin-left:750px;}
footer{width: 100%;height: 120px;line-height: 30px;text-align: center;font-size: 12px;background: rgb(250,250,250);padding:30px 0;}
.gwcxqbj .gwcxd .content2 .sub_content[data-v-3f001def]:nth-of-type(3){width:120px;margin-left:41px;}
.gwcxqbj .gwcxd .content2 .sub_content[data-v-3f001def]:nth-of-type(5){width:50px;margin-left:}
.gwcxqbj .gwcxd .content2 .sub_content[data-v-3f001def]:nth-of-type(4){margin-left:108px;}
.gwcxqbj .gwcxd .top2 .sub_top[data-v-3f001def]:nth-of-type(4){margin-left:90px;}
.gwcxqbj .gwcxd .content2 .sub_content[data-v-3f001def]:nth-of-type(6){margin-left:135px;}
</style>
