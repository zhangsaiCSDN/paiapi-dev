<template>

	<div>
        <div class="modal-header">
          <h4 class="modal-title">增加地址</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
     
        <div class="modal-body" text-aligh="center">
			<input type="hidden" width="17%" />
			<input type="hidden" class="form-control" width="17%" v-model="uid" /><br />
			请选择地址:
			<v-distpicker @selected="onSelected" :province="select.province" :city="select.city" :area="select.area" v-model="select">
			</v-distpicker>
			详细地址:<br><input type="text" class="form-control" width="17%" placeholder="请输入详细地址" v-model="ainfo" /><br />
			邮政编码:<br><input type="text" class="form-control" width="17%" placeholder="请输入邮编" v-model="apost" /><br />
			收件人:<br><input type="text" class="form-control" width="17%" placeholder="请输入收件人姓名" v-model="name" /><br />
			手机号码:<br><input type="text" class="form-control" width="17%" placeholder="请输入手机号码" v-model="aphone" /><br />
			   
        </div>
   
        <div class="modal-footer">
       	<button class="btn btn-success" @click="save" >添加</button>
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
			placeholders: {
	              province: '------- 省 --------',
	              city: '--- 市 ---',
	              area: '--- 区 ---',
	         },
	      	
	      	address:'',
	      	ainfo:"",
			apost:"",
			aphone:"",
	      	name:"",
	      	uid:""
	    }
	  },
		methods: {
			reset(){
				this.ainfo="";
				this.apost="";
				this.aphone="";
				this.name="";
			},
			
			save(){
				var self = this; 
				this.$ajax.post("http://localhost:8080/addresses", {
					ainfo: self.select.province+self.select.city+self.select.area+self.ainfo+",收件人:"+self.name,
					apost: self.apost,
					aphone: self.aphone,
					select: self.select,
			
				}).then(function(response) {
					self.$router.push({
						path:"/message/"+self.$route.params.gid+"/"+self.$route.params.money
					});
					self.$Message.success('添加成功! 已为您跳转至地址页面.');
				})
			},　
			onSelected: function (data) {
		       this.select.province = data.province.value;
		       this.select.city = data.city.value;
		       this.select.area = data.area.value;
    		 }, 
		},
	}
</script>