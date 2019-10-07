<template>
	<div>
		<table class="table table-hover table-striped table-bordered table-dark">
			<tr>
				<td>拍品id</td>
				<td>名称</td>
				<td>拍品图片</td>
				<td>起拍价格</td>
				<td>起拍时间</td>
				<td>结束时间</td>
				<td>围观次数</td>
				<td>加价幅度</td>
				<td>审核通过时间</td>
				<td>状态</td>
				<!--<td>详细信息</td>-->
				<td>拍品类型</td>
	
				<td>操作</td>
			</tr>
			
			
			<tr v-for="item in list">
				<td>{{item.gid}}</td>
				<td>{{item.gname}}</td>
				<td colspan="1">
					<img width="100px" height="100px" v-for=" imge in item.images"  :src="imge.img"/>
				</td>
				<td>{{item.gprice}}</td>
				<td>{{item.gstart.substring(5)}}</td>
				<td>{{item.gend.substring(5)}}</td>
				<td>{{item.gcount}}</td>
				<td>{{item.ggap}}</td>
				<td>{{item.gpasstime.substring(5)}}</td>
				<td>{{item.gstate}}</td>
			<!--	<td>{{item.ginfo}}</td>-->
				<td>{{item.goodstype.gtname}}</td>
				<td>
					<button class="btn btn-warning" @click='edit(item.gid)' >修改</button>
				</td>
					
				
			</tr>
			
			
		
			
		</table>
		<div>
			<div>
				<RouterLink to="/addGoods">
					<button class="btn btn-info">添加拍品</button>
				</RouterLink>
				
			</div>
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
	export default{
		data(){
			return{
				page:[],
				list:[],
				vpages:[],
		
			};
		},
		
		methods:{
			find(p){
				var self = this;
				var t = self.pp;
						
				this.$ajax.get("http://localhost:8080/goods/findUserGoods?p="+p+"&uid=1"
							).then(
								function(response){
									self.list = response.data.list;
									self.page = response.data;
									for(var i in self.list){
										for(var j in self.list[i].images){
											self.list[i].images[j].img = "../image/"+self.list[i].images[j].img;
											self.vpages=[];
											self.pages(self.page.startPage , self.page.endPage);
											
										}
									};
									
					});
				},
			
				/*分页页码数据  */
			pages(startPage,endPage){
				var self=this;
				for(var i=startPage;i<=endPage;i++){
					self.vpages.push(i);
				};
			},
			edit(gid){
				this.$router.push({path:"updateGoods/"+gid});
			}
			
			
		},
				
		mounted:function() {
				this.find(1);
		}
		
		
		
	}
</script>

<style>
	
</style>
