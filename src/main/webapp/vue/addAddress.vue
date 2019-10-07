<template>

	<div>
  	 	 <!-- 模态框头部 -->
			        <div class="modal-header">
			          <h4 class="modal-title">增加地址</h4>
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			   
			        <!-- 模态框主体 -->
			        <div class="modal-body" text-aligh="center">
						<input type="hidden" width="17%" />
						请选择地址:
						<v-distpicker :province="select.province" :city="select.city" :area="select.area">
  	 					</v-distpicker>
						详细地址:<br><input type="text" class="form-control" width="17%" placeholder="请输入详细地址" v-model="ainfo" /><br />
						邮政编码:<br><input type="text" class="form-control" width="17%" placeholder="请输入邮编" v-model="apost" /><br />
						手机号码:<br><input type="text" class="form-control" width="17%" placeholder="请输入手机号码" v-model="aphone" /><br />
						
						
			        </div>
			   
			        <!-- 模态框底部 -->
			        <div class="modal-footer">
			       	<button class="btn btn-success" @click="save" data-dismiss="modal" >添加</button>
					<button type="reset" class="btn btn-info" @click="reset">重置</button>
			        </div>
	</div>
</template>

<style scoped>
	
</style>

<script>
	import VDistpicker from 'v-distpicker'

	export default {
	  components: { VDistpicker },
	  data() {
	    return {
	      	select: { province: '陕西省', city: '西安市', area: '莲湖区' },
	      	address:'',
	      	ainfo:"",
			apost:"",
			aphone:"",
	      	
	    }
	  },
		methods: {
			reset(){
				this.ainfo="";
				this.apost="";
				this.aphone="";
			},
			save(){
					var json = {"aid":null,"ainfo":this.ainfo,"apost":this.apost,"aphone":this.aphone};
					this.$ajax.post("http://localhost:8080/addresses",json).then(function(){
						this.find(this.address.p);
						this.ainfo="";
						this.apost="";
						this.aphone="";
					});
				},

		},
	}
</script>