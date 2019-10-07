import index from './vue/index.vue'
import indexBox from './vue/indexBox.vue'
import userCenter from './vue/userCenter.vue'

import $ from 'jquery'
import "./css/login.css"
import "./css/style.css";
import 'bootstrap3/dist/css/bootstrap.min.css';
import Vue from 'vue';
import ajax from 'ajax';
import axios from 'axios';
axios.defaults.withCredentials = true
import router from './router.js';
import myCenter from './js/userCenter.js';

import Router from 'vue-router'
 
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.prototype.$ajax = axios;


var app=new Vue({
	el:"#app",
	render(c){
		return c(index);
	},
	router
})
//	监控用户中心中左侧所有列表的样式，选中为绿色，其他未被选中则无样式

$(function(){
	$('ul li').click(function(){
		$(this).css("background-color","rgba(32, 178, 170, .6)");
		$("ul li").not(this).css("background-color","");
	});
})




