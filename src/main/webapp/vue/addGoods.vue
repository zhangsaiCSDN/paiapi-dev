<template>
		<div>
			<div class="modal-body">
			
						<div >
							<label for="pwd">拍品id:</label> <input type="text" class="form-control" v-model="gid"  disabled="disabled"/>
						</div>
						<div>
							<label for="pwd">拍品名称:</label> <input type="text" class="form-control" v-model="gname" />
						</div>
						<div>
							<label for="pwd">拍品价格:</label> <input type="text" class="form-control" v-model="gprice" />
						</div>
						<div>
							<label for="pwd">起拍时间:</label> <input type="text" class="form-control" v-model="gstart" />
						</div>
						<div>
							<label for="pwd">结束时间:</label> <input type="text" class="form-control" v-model="gend" />
						</div>
						<div>
							<label for="pwd">围观次数:</label> <input type="text" class="form-control" v-model="gcount" />
						</div>
						<div>
							<label for="pwd">加价幅度:</label> <input type="text" class="form-control" v-model="ggap" />
						</div>
						<div>
							<label for="pwd">审核通过时间:</label> <input type="text" class="form-control" v-model="gpasstime" />
						</div>
						<div>
							<label for="pwd">状态:</label> 
							<select class="form-control" v-model="gstate">
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
							<select class="form-control" v-model="garea">
								<option value="北京">北京</option>
								<option value="上海">上海</option>
								<option value="广东">广东</option>
								<option value="深圳">深圳</option>
								<option value="西安">西安</option>
								<option value="成都">成都</option>
							</select>
						</div>
						<div>
							<label for="pwd">详细信息:</label> <input type="text" class="form-control" v-model="ginfo" />
						</div>
						<div>
							<label for="pwd">卖家id:</label> <input type="text" class="form-control" v-model="salerid" />
						</div>
						<div>
							<label for="pwd" >拍品类型id:</label>
										<select class="form-control" v-model="gtid">
											<option v-for="gt in goodsType" :value="gt.gtid">{{gt.gtname}}</option>
										</select>
						</div>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal"  @click='save'>提交</button>
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
				goodsType:[]
			};
		},
		created: function(){ 
				this.getGoodsType();
			},
		
		methods:{
			getGoodsType(){
					var self = this;
					this.$ajax.get("http://localhost:8080/goods/getGoodsType").then(function(response) {
						self.goodsType = response.data; 
		
					})
				},
				save() {
					var self = this; 
					this.$ajax.post("http://localhost:8080/goods", {
						gname:self.gname,
						gprice: self.gprice,
						gstart: self.gstart,
						gend: self.gend,
						gcount: self.gcount,
						ggap: self.ggap,
						gpasstime: self.gpasstime,
						gstate: self.gstate,
						garea: self.garea,
						ginfo: self.ginfo,
						salerid: self.salerid,
						gtid: self.gtid

				
					}).then(function(response) {
						self.$router.push({path:"/userGoods"});
						alert('添加成功!');
					})
				}
		
		
		}
	}
	
</script>

<style>
</style>
