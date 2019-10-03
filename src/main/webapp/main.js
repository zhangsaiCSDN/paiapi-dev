import $ from 'jquery'
import "./css/login.css"
import "./css/style.css"
import 'bootstrap3/dist/css/bootstrap.min.css'
import Vue from 'vue'
import ajax from 'ajax'
import axios from 'axios'
axios.defaults.withCredentials = true
import index from './vue/index.vue'
import indexBox from './vue/indexBox.vue'
import router from './router.js';

Vue.prototype.$axios = axios

var app=new Vue({
	el:"#app",
	render(c){
		return c(index);
	},
	router
})



