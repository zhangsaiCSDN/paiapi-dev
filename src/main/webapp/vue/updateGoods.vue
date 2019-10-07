<template>
	<div >
		<!-- 模态框 -->
		<div  id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<!-- 模态框头部 -->
					<div class="modal-header">
						<h4 class="modal-title">修改拍品页面</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- 模态框主体 -->
					<div class="modal-body">
						<div >
							<label for="pwd">拍品id:</label> <input type="text" class="form-control" v-model="u_gid"  disabled="disabled"/>
						</div>
						<div>
							<label for="pwd">拍品名称:</label> <input type="text" class="form-control" v-model="u_gname" />
						</div>
						<div>
							<label for="pwd">拍品价格:</label> <input type="text" class="form-control" v-model="u_gprice" />
						</div>
						<div>
							<label for="pwd">起拍时间:</label> <input type="text" class="form-control" v-model="u_gstart" />
						</div>
						<div>
							<label for="pwd">结束时间:</label> <input type="text" class="form-control" v-model="u_gend" />
						</div>
						<div>
							<label for="pwd">围观次数:</label> <input type="text" class="form-control" v-model="u_gcount" />
						</div>
						<div>
							<label for="pwd">加价幅度:</label> <input type="text" class="form-control" v-model="u_ggap" />
						</div>
						<div>
							<label for="pwd">审核通过时间:</label> <input type="text" class="form-control" v-model="u_gpasstime" />
						</div>
						<div>
							<label for="pwd">状态:</label> 
							<select class="form-control" v-model="u_gstate">
								<option value="0">待审核</option>
								<option value="1">未通过审核</option>
								<option value="2">公告期</option>
								<option value="3">拍卖期</option>
								<option value="4">无效</option>
								<option value="5">等待竞价</option>
								<option value="6">竞价失败</option>
								<option value="7">已成交</option>
							</select>
						</div>
						<div>
							<label for="pwd">区域:</label> 
							<select class="form-control" v-model="u_garea">
								<option value="北京">北京</option>
								<option value="上海">上海</option>
								<option value="广东">广东</option>
								<option value="深圳">深圳</option>
								<option value="西安">西安</option>
								<option value="成都">成都</option>
							</select>
						</div>
						<div>
							<label for="pwd">详细信息:</label> <input type="text" class="form-control" v-model="u_ginfo" />
						</div>
						<div>
							<label for="pwd">卖家id:</label> <input type="text" class="form-control" v-model="u_salerid" />
						</div>
						<div>
							<label for="pwd" >拍品类型id:</label>
										<select class="form-control" v-model="u_gtid">
											<option v-for="gt in goodsType" :value="gt.gtid">{{gt.gtname}}</option>
										</select>
						</div>
					</div>
					<!-- 模态框底部 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal"  @click='update()'>提交</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				gname:'',
				gprice:'',
				gstart:'2019-09-12 20:56:27',
				gend:'2019-09-12 20:56:27',
				gcount:'',
				ggap:'',
				gpasstime:'2019-09-12 20:56:27',
				gstate:'',
				garea:'',
				ginfo:'',
				salerid:'',
				gtid:'',
				u_gid:'',
				u_gname:'',
				u_gprice:'',
				u_gstart:'',
				u_gend:'',
				u_gcount:'',
				u_ggap:'',
				u_gpasstime:'',
				u_gstate:'',
				u_garea:'',
				u_ginfo:'',
				u_salerid:'',
				u_gtid:'',
				goods: [],
				goodsType:[],
				da:[]
			};
		},
		created: function(){ 
			this.getEdit(this.$route.params.gid)
			this.getGoodsType();
			},
		mounted:function(){
			
		},
		
		methods:{
			getGoodsType(){
					var self = this;
					this.$ajax.get("http://localhost:8080/goods/getGoodsType").then(function(response) {
						self.goodsType = response.data; 
		
					})
				},
				/* 编辑时的数据回显 */
				getEdit(gid){
					var self = this;
					this.$ajax.get("http://localhost:8080/goods/findOne?gid="+gid).then(function(response) {
						var g = response.data; 
					
						self.u_gid=g.gid,
						self.u_gname=g.gname,
						self.u_gprice=g.gprice,
						self.u_gstart=g.gstart,
						self.u_gend=g.gend,
						self.u_gcount=g.gcount,
						self.u_ggap=g.ggap,
						self.u_gpasstime=g.gpasstime,
						self.u_gstate=g.gstate,
						self.u_garea=g.garea,
						self.u_ginfo=g.ginfo,
						self.u_salerid=g.salerid,
						self.u_gtid=g.gtid
					});
					
				},
				update() {
					
					var self = this; 
					this.$ajax.put("http://localhost:8080/goods", {
						gid:this.u_gid,
						gname:this.u_gname,
						gprice:this.u_gprice,
						gstart:this.u_gstart,
						gend:this.u_gend,
						gcount:this.u_gcount,
						ggap:this.u_ggap,
						gpasstime:this.u_gpasstime,
						gstate:this.u_gstate,
						garea:this.u_garea,
						ginfo:this.u_ginfo,
						salerid:this.u_salerid,
						gtid:this.u_gtid 

	
					}).then(function(response) {
						self.$router.push({path:"/userGoods"});
						alert('更改成功!');
					})

				}
		}
	}
</script>

<style>
</style>
