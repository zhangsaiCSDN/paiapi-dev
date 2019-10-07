<template>
	<div>
		<div class="w2 fl">
			<font class="sub_content1">冠军:</font>
			<font class="sub_content1">{{name}};</font>
			<font class="sub_content1">金额:</font>
			<font class="sub_content1">{{money}}</font>
		</div>
		<div v-if="name=name">
			<button class='sub_content5'><router-link to="/message/2">去付款</router-link></button>
		</div>
		<div class="w2 fl">
			倒计时:{{hour}}小时{{minutes}}分{{seconds}}秒,结束时间{{goods.gend}}
		</div>
		
		<div class="jieshao mt20 w1">
			<div class="left1 fl">11</div>
			<div class="right1 fr">
				<div id=message class="banner_x2"></div>
				<div class="sub_content2 fr">每次加价幅度:{{goods.ggap}},<button class="sub_content3" type="button" @click="send">竞价</button></div>
				
			</div>
		</div>
	</div>
</template>
<style scoped>
	.banner_x2 {height:500px;border:1px solid #999;overflow-y:auto;}
	.w1{width: 978px;margin: 0 auto;}
	.w2{width: 900px;height:50px}
	.left1{width:330px;height:500px;border:1px solid #ccc;}
	.right1{width:648px;background:rgb(248,248,248);height:500px}
	.sub_content1{width:50px;color:red;font-size:30px;align:center}
	.sub_content2{color:#1E90FF;font-size:20px;align:center}
	.sub_content3{width: 80px;height: 40px;border-width: 0px;border-radius: 3px;background: #1E90FF;cursor: pointer;outline: none;font-family: Microsoft YaHei;color: white;font-size: 20px;}
	.sub_content5{width: 78px;height: 40px;border-width: 0px;border-radius: 3px;background: #1E90FF;cursor: pointer;outline: none;font-family: Microsoft YaHei;color: white;font-size: 20px;}
</style>
<script>
	export default {
		data() {
				return {
					path: "ws://localhost:8080/chat/"+this.$route.params.gid,
					socket: "",
					gid:'',
					goods:'',
					hour:'',
					minutes:'',
					seconds:'',
					name:'无',
					money:0,
					username:'',
					uid1:'',
					flaga:'',
					odmoney:'',
					buyerid:'',
					salerid:0,
					odfee:'',
					odtime:'',
					uid:''
					
				}
			},
			mounted() {
				// 初始化
				var self = this;
				self.init(),
				self.timer(),
				
				this.$ajax.get("http://localhost:8080/goods/findOne?gid="+this.$route.params.gid).then(
					function(response){
						self.goods=response.data;
						self.money = self.goods.gprice;
						var date1 = Date.parse(self.goods.gend);
						var date2 = Date.parse(new Date());
						var time = (date1-date2)/1000;
						self.hour = parseInt(time/60/60);
						self.minutes = parseInt((time-self.hour*60*60)/60);
						self.seconds = time%60;
					}
				);
				
				
				this.$ajax.get('http://localhost:8080/users/isLogin').then(function(response){
					self.uid1 = response.data.uid;
					
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
					console.log("连接错误")
				},
				getMessage: function(msg) {
					var message = document.getElementById("message");
					this.name = msg.data;
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
				timer() {
					var _this = this;
						// 创建一个定时器
					var time = window.setInterval(function() {
						// 如果秒数为0 && 分钟数还没有为0
						if (_this.seconds == 0 && _this.minutes != 0) {
					// 秒数变为59  分钟数--
							_this.seconds = 59
							_this.minutes -= 1
						// 都为0的时候 清除定时器
						} else if (_this.minutes === 0 && _this.seconds === 0 && _this.hour === 0) {
							window.clearInterval(time)
							_this.close();
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
</script>