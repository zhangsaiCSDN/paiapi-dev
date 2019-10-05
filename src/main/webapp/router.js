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
import userCenter from './vue/userCenter.vue'
import goodsHistory from './vue/goodsHistory.vue'
import order from './vue/order.vue'
import orderOne from './vue/orderOne.vue'
import deposit from './vue/deposit.vue'
import rooms from './vue/rooms.vue'
import myRooms from './vue/myRooms.vue'

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
				{path:"/biddingRoomList",component:biddingRoomList},
				{path:"/userCenter",component:userCenter,children:[
					{path:"/goodsHistory",component:goodsHistory},
					{path:"/order",component:order},
					{path:"/orderOne",component:orderOne},
					{path:"/deposit",component:deposit},
					{path:"/rooms/:2",component:rooms},
					{path:"/myRooms/:1",component:myRooms}
				]}
				 
			]
		}
	]
});


export default router; 