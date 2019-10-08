<template>
	<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center" >
					<div class="sub_top fl">
						批量退还
					</div>
					<div class="sub_top fl">拍品名称</div>
					<div class="sub_top fl " >保证金</div>
					<div class="sub_top fl">拍品状态</div>
					<div class="sub_top fl">押金状态</div>
					<div class="sub_top fr" style="margin-right: 100px;">退押金</div>
					<div class="clear"></div>
				</div>
				<div v-for="item in list" class="content2 center" >
					<div class="sub_content fl ">
						<input  type="checkbox" v-model="checkedNames" :value="item" class="quanxuan" />
					</div>
					<div class="sub_content fl"></div>
					<div class="sub_content fl ">{{item.goods.gname}}</div>
					<div class="sub_content fl m-le" >{{item.dmoney}}元</div>
					
					<div class="sub_content fl" >
						<div v-if="item.goods.gstate==3">
							拍品正在拍卖
						</div>
						<div v-if="item.goods.gstate==5">
							拍品等待竞价
						</div>
						<div v-if="item.goods.gstate==6">
							拍品竞价失败
						</div>
						<div v-if="item.goods.gstate==7">
							拍品竞拍成功
						</div>
					</div>
					<div class="sub_content fl" v-if="item.gstate==0">
						扣除押金
					</div>
					<div class="sub_content fl" v-if="item.gstate==1">
						退还押金中
					</div>
					<div class="sub_content fl" v-if="item.gstate==2">
						正在抵押中
					</div>
					<div class="sub_content fl" v-if="item.gstate==3">
						抵充货款
					</div>
					<div class="sub_content fl" v-if="item.gstate==4">
						退款成功
					</div>
					<div class="sub_content fl">
						<button type="button" @click="edit(item)" class="btn btn-warning">
							退押金
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
					<div class="jiesuanjiage fl">批量退还押金：<span>{{countMoney}}元</span></div>
					<div class="jsanniu fr">
							<button @click="qx()" class="jsan btn btn-danger" style="margin-right:130px ; width:170px;">
								申请退押金
							</button>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
			
			<div class="jiesuandan mt20 center">
				<div colspan="5" style="vertical-align: middle !important; text-align: center;">
					{{page.p}}/{{page.maxPage}}
					<button @click='find(1)' class="btn btn-outline-info">
						首页
					</button>
					
					<button @click='find(page.prev)'class="btn btn-outline-info">
						上一页
					</button>
					
					<span v-for="i in vpages"> <span v-if="i==page.p"class="btn">
						<font color="red">{{i}}</font>
					</span>
					 
					<span @click='find(i)' v-if="!(i==page.p)" class="btn" style="cursor: pointer">
						<font>{{i}}</font>
					</span>
				</span>
					
				<button @click='find(page.next)'
					class="btn btn-outline-info">下一页
				</button>
				<button @click='find(page.maxPage)'
					class="btn btn-outline-info">末页
				</button>
				</div>
			</div>
			
		</div>
	
</template>

<script>
	 
	export default {
			data() {
				return {
					page:[],
					list:[],
					vpages:[],
					sun:'',
					checkedNames:[],
					checked:false,
					count:'',
					countMoney:0,
					uid:''
					
				};
			},
			methods:{
				find(p,uid){
					var self = this;
					var id = self.uid;
					this.$ajax.get("http://localhost:8080/deposits/findDepo?p="+p+"&uid="+id).then(
							function(response){
								self.list = response.data.list;
								self.page = response.data;
								self.vpages=[];
								self.pages(self.page.startPage , self.page.endPage);
							});
				},
				
					/*分页页码数据  */
				pages(startPage,endPage){
					var self=this;
					for(var i=startPage;i<=endPage;i++){
						self.vpages.push(i);
					};
				},
				
				
				//全选方法
				changeAllChecked: function() {
							if (this.checked) {
								this.checkedNames = this.list
							} else {
								this.checkedNames = []
							}
						},
				
					/*删除  */
				del(did1){
					var self=this
					this.$ajax.delete("http://localhost:8080/deposits",{
						params:{
							did:did1
						}
					}).then(function(){
						self.find(self.deposits.p)
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
			watch: {
				"checkedNames": function() {
					this.count = this.checkedNames.length;
					
					this.countMoney=0;
					for(var p in this.checkedNames){
						this.countMoney =+this.countMoney  + +this.checkedNames[p].dmoney +'';
					}
					
					if (this.checkedNames.length == this.list.length) {
						this.checked = true
					} else {
						this.checked = false
					}
				}
			},
				
			mounted:function(){
			 var self = this;
				this.$ajax.get('http://localhost:8080/users/isLogin').then(function(response){
			    	self.uid = response.data.user.uid;
			     	self.find(1)
			    });
			    
				
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
.gwcxqbj .gwcxd .content2{width:1226px;height: 70px;border-top: 1px solid #ccc;}
.gwcxqbj .gwcxd .content2 .sub_content{width:50px;height: 70px;line-height:70px;margin-right: 0px;}
.gwcxqbj .gwcxd .sub_content .quanxuan{width:18px;height:18px;border:1px solid #ccc;background: none;}
.gwcxqbj .gwcxd .content2 .sub_content img{vertical-align: middle;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(1){margin-left: 30px;} 
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(2){margin-left: 35px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(3){margin-left: 78px;width: 100px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(4){margin-left: 85px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(5){margin-left: 140px;width: 90px;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(6){margin-left: 100px;width: 80px;color:#ff6700;}
.gwcxqbj .gwcxd .content2 .sub_content:nth-of-type(7){margin-left: 123px;font-size: 25px;}
.gwcxqbj .gwcxd .content2 .sub_content .shuliang{width: 70px;height: 35px;border:2px solid #ccc;text-align: center;font-size:16px;color:#ff6700;}
.gwcxqbj .gwcxd .content2 .sub_content a{display: block;width: 20px;height: 20px;border-radius: 10px;color:#000;}
.gwcxqbj .gwcxd .content2 .sub_content a:hover{color:#ff6700;}


</style>
