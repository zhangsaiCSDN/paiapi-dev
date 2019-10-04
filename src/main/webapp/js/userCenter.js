import Vue from 'vue';
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import indexBox from '../vue/indexBox.vue'
import indexTop from '../vue/indexTop.vue'
import userCenter from '../vue/userCenter.vue'
import goodsHistory from '../vue/goodsHistory.vue'


var myCenter = new VueRouter({
	routes:[
		{path:"/userCenter",component:userCenter},
		{path:"/goodsHistory",component:goodsHistory}
			]
});



export default myCenter; 
