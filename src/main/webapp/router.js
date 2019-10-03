import Vue from 'vue';
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import index from './vue/index.vue'
import indexBox from './vue/indexBox.vue'
import indexTop from './vue/indexTop.vue'
import hotProducts from './vue/hotProducts.vue'
import beforeSell from './vue/beforeSell.vue'
import collection from './vue/collection.vue'
import follow from './vue/follow.vue'
import global from './vue/global.vue'
import help from './vue/help.vue'
import limiteTime from './vue/limiteTime.vue'
import login from'./vue/login.vue'
import register from './vue/register.vue'

import list from'./vue/list.vue'
import biddingRoom from'./vue/biddingRoom.vue'
import biddingRoomList from'./vue/biddingRoomList.vue'


var router = new VueRouter({
	routes:[
		{path:"/",component:indexTop,redirect:"/index"},
		{path:"/login",component:login},
		{path:"/register",component:register},
		{
			path:"/indexTop", component: indexTop,
			children:[
				{path:"/index",component:indexBox},
				{path:"/hotProducts",component:hotProducts},
				{path:"/beforeSell",component:beforeSell},
				{path:"/follow",component:follow},
				{path:"/collection",component:collection},
				{path:"/limiteTime",component:limiteTime},
				{path:"/global",component:global},
				{path:"/help",component:help},
				{path:"/list",component:list},
				{path:"/biddingRoom",component:biddingRoom},
				{path:"/biddingRoomList",component:biddingRoomList}
			]
		}
	]
});


export default router; 