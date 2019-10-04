<template>
	<div>
		<form action="post" method="">
			<div class="w">
				倒计时:{{hour}}小时{{minutes}}分{{seconds}}秒,结束时间{{goods.gend}}
			</div>
			<div class="jieshao mt20 w">
				<div class="left fl">11</div>
				<div class="right fr">
					<div id=message class="banner_x2"></div>
					<input id="text" type="text" />
					<button type="button" @click="send">发消息</button>
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>
</template>
<style scoped>
	.banner_x2 {height:540px;border:1px solid #999;overflow-y:auto;}
</style>
<script>
	export default {
		data() {
				return {
					path: "ws://localhost:8080/chat",
					socket: "",
					gid:'',
					goods:'',
					hour:'',
					minutes:'',
					seconds:''
				
				}
			},
			mounted() {
				// 初始化
				var self = this;
				self.init(),
				self.timer(),
				this.$axios.get("http://localhost:8080/goods/findOne?gid="+this.$route.params.gid).then(
					function(response){
						self.goods=response.data;
						var date1 = Date.parse(self.goods.gend);
						var date2 = Date.parse(new Date());
						var time = (date1-date2)/1000;
						self.hour = parseInt(time/60/60);
						self.minutes = parseInt((time-self.hour*60*60)/60);
						self.seconds = time%60;
					}
				);
				
				
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
					message.innerHTML += msg.data + "<br />";
                    message.innerHTML = message.innerHTML + '<br />';
                    message.scrollTop = message.scrollHeight;
				},
				send: function() {
					var text = document.getElementById("text");
					this.socket.send(text.value);
				},
				close: function() {
					console.log("socket已经关闭")
				},destroyed() {
				// 销毁监听
				this.socket.onclose = this.close
				},
				timer() {
					var _this = this
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
								// 分钟数和秒数同时为0  小时数--  分钟数和秒数都变为59
						} else if (_this.minutes === 0 && _this.seconds === 0) {
							_this.seconds = 59
							_this.minutes = 59
							_this.hour -= 1
						} else {
							_this.seconds -= 1
						}
					}, 1000)
				},
			}
			
	}
</script>