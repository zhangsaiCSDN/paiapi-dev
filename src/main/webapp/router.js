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
import salerCenter from './vue/salerCenter.vue'
import goodsHistory from './vue/goodsHistory.vue'
import order from './vue/order.vue'
import orderOne from './vue/orderOne.vue'
import salerOrder from './vue/salerOrder.vue'
import salerOrderOne from './vue/salerOrderOne.vue'
import deposit from './vue/deposit.vue'
import rooms from './vue/rooms.vue'
import myRooms from './vue/myRooms.vue'

import list from'./vue/list.vue'
import goodsOne from'./vue/goodsOne.vue'
import biddingRoom from'./vue/biddingRoom.vue'
import biddingRoomList from'./vue/biddingRoomList.vue'


import userGoods from'./vue/userGoods.vue'
import addGoods from'./vue/addGoods.vue'
import updateGoods from'./vue/updateGoods.vue'

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
				{path:"/goodsOne/:gid",component:goodsOne},
				{path:"/biddingRoom",component:biddingRoom},
				{path:"/biddingRoomList",component:biddingRoomList},
				{path:"/userCenter",component:userCenter,children:[
					{path:"/goodsHistory",component:goodsHistory},
					{path:"/order/:1",component:order},
					{path:"/orderOne/:gid/:odid", component: orderOne},
					{path:"/deposit",component:deposit},
					{path:"/rooms/:gid",component:rooms},
					{path:"/myRooms/:uid",component:myRooms}
				]},
				{path:"/salerCenter",component:salerCenter,children:[
					{path:"/salerOrder/:1",component:salerOrder},
					{path:"/salerOrderOne/:gid/:odid", component: salerOrderOne},
					{ path:'/userGoods', component:userGoods },
					{ path:'/addGoods', component:addGoods },
					{ path:'/updateGoods/:gid', component:updateGoods },
				]},
				 
			]
		}
	]
});


export default router; 