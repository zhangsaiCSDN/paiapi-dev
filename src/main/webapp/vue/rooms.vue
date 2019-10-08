<template>
	<div>
		<div class="w2 fl">
			<div class="sub_content1 ff fl">我的id:{{myName}}</div>
			<div>
				<font class="sub_content1">获得者:</font>
				<font class="sub_content1">{{name}};</font>
				<font class="sub_content1">金额:</font>
				<font class="sub_content1">{{money}}</font>
			</div>
		</div>
		<div v-if="flag">
			<button class='sub_content5'><scan @click="message(goods.gid,money)">去付款</scan></button>
		</div>
		<div class="w3 fl">
			<div class="fl">
				<font class="sub_content4">倒计时:{{hour}}小时{{minutes}}分{{seconds}}秒</font>
			</div>
			<div class="fr">
				<font class="sub_content4">结束时间{{goods.gend}}</font>
			</div>
		</div>
		
		<div class="jieshao1 mt20 w1">
			<div class="left1 fl"><img :src="image" style="width:100%;height:100%;"></div>
			<div class="right1 fr">
				<div id=message class="banner_x2 sub_content6"></div>
			</div>
			<div class="jieshao1">
				<div class="sub_content2 fl"><button class="sub_content3" type="button" @click="close11()">退出房间</button></div>
				<div  class="sub_content2 fr">每次加价幅度:{{goods.ggap}}<button class="sub_content3" type="button" @click="send">竞价</button></div>
			</div>
		</div>
	</div>
</template>
<style scoped>
	.jieshao1{height: 400px; }
	.banner_x2 {height:350px;border:1px solid #999;overflow-y:auto;}
	.w1{width: 978px;margin: 0 auto;}
	.w2{width: 900px;height:50px}
	.w3{width: 978px;height:50px}
	.left1{width:330px;height:350px;border:1px solid #ccc;}
	.right1{width:648px;background:rgb(248,248,248);height:350px}
	.sub_content1{width:50px;color:red;font-size:30px;align:right}
	.sub_content4{width:50px;color:blue;font-size:30px;align:center}
	.sub_content2{color:#1E90FF;font-size:30px;align:center}
	.sub_content3{width: 80px;height: 40px;border-width: 0px;border-radius: 3px;background: #1E90FF;cursor: pointer;outline: none;font-family: Microsoft YaHei;color: white;font-size: 20px;}
	.sub_content5{width: 78px;height: 40px;border-width: 0px;border-radius: 3px;background: #1E90FF;cursor: pointer;outline: none;font-family: Microsoft YaHei;color: white;font-size: 20px;}
	.ff{width:375px;height:50px;}
	.sub_content6{color:#6C3365;font-size:30px;align:center}
</style>
<script> 
	var bb = {
		data() {
				return {
					uid1:'',
					path: "ws://localhost:8080/chat11/"+this.$route.params.gid,
					socket: "",
					gid:'',
					goods:'',
					hour:'',
					minutes:'',
					seconds:'',
					name:'无',
					myName:'',
					money:0,
					username:'',
					flaga:'',
					odmoney:'',
					buyerid:'',
					salerid:0,
					odfee:'',
					odtime:'',
					uid:'',
					flag:false,
					flags:'',
					image:''
				}
			},
			mounted() {
				// 初始化
				var self = this;
				self.init();
				self.timer();
				
				
				
				if (window.history && window.history.pushState) {
		            $(window).on('popstate', function () {
		              self.socket.close();
		            });
		        }
				
				
				var gid = self.$route.params.gid;
				
				this.$ajax.get('http://localhost:8080/users/isLogin').then(function(response){
					self.uid1 = response.data.user.uid;
					self.$ajax.get("http://localhost:8080/goods/findOne?gid="+gid).then(
						function(response){
						
							self.goods=response.data;
							self.money = self.goods.gprice;
							var date1 = Date.parse(self.goods.gend);
							var date2 = Date.parse(new Date());
							var time = (date1-date2)/1000;
							self.hour = parseInt(time/60/60);
							self.minutes = parseInt((time-self.hour*60*60)/60);
							self.seconds = time%60;
							self.flags = self.uid1==self.goods.salerid;
							self.$ajax.get("http://localhost:8080/images/findOne?gid="+gid).then(function(response){
								self.image ="../admin/goods/goodsImg/"+ response.data.img;
							});
							
						}
					);
					
				});
				
			},
			methods: {
				init: function() {
					if (typeof(WebSocket) === "undefined") {
						alert("您的浏览器不支持socket")
					} else {
						// 实例化socket
						this.socket = new WebSocket(this.path)
							// 监听socket连接
						this.socket.onopen = this.open
							// 监听socket错误信息
						this.socket.onerror = this.error
							// 监听socket消息
						this.socket.onmessage = this.getMessage
					}
				},
				open: function() {
					console.log("socket连接成功")
				},
				error: function() {
					alert("链接已失效!!");
					this.$router.push({
						path:"/salerRooms/"
					});
				},
				getMessage: function(msg) {
					var message = document.getElementById("message");
					this.name = msg.data;
					this.myName = msg.data;
					this.money = this.money + this.goods.ggap;
					message.innerHTML += msg.data + "出价" + this.money + "<br />";
                    message.innerHTML = message.innerHTML + '<br />';
                    message.scrollTop = message.scrollHeight;
				},
				send: function() {
					this.socket.send(this.money);
				},
				close: function() {
					console.log("链接关闭");
				},
				destroyed() {
					// 销毁监听
					this.socket.onclose = this.close
				},
				message(gid,money){
					this.$router.push({
						path:"/message/"+gid+"/"+money
					});
				
				},
				close11(){
					this.$router.push({
						path:"/myRooms/"
					});
					this.socket.close();
				},
				timer() {
				
					var _this = this;
				
						// 创建一个定时器
					var time = window.setInterval(function() {
					
						// 如果秒数为0 && 分钟数还没有为0
						if (_this.seconds == 0 && _this.minutes != 0) {
					// 秒数变为59  分钟数--
							_this.seconds = 59
							_this.minutes -= 1
						// 都为_this0的时候 清除定时器
						} else if (_this.minutes <= 0 && _this.seconds <= 0 && _this.hour <= 0) {
							window.clearInterval(time)
							_this.flag = _this.myName==_this.name;
							alert("竞价结束,获得者为"+_this.name);
							_this.socket.close();
						// 分钟数和秒数同时为0  小时数--  分钟数和秒数都变为59
						} else if (_this.minutes === 0 && _this.seconds === 0) {
							_this.seconds = 59
							_this.minutes = 59
							_this.hour -= 1
						} else {
							_this.seconds -= 1
						}
					}, 1000)
				}
				
			}
			
	}
	export default bb; 
	

</script>