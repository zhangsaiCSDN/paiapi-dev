import $ from 'jquery'
import boot from 'bootstrap3/dist/css/bootstrap.min.css'
import './css/all.css'
import Vue from 'vue/dist/vue'
$(function() {
	$("li:even").css("color", "red");
	$("li:odd").css("color", "blue");
	
	$("#btn").click(function(){
		alert('哥哥好帅!!');
	});
});


var vue = new Vue({
	
	el:"#app",
	data:{
		msg:"hahah"
	}
	
});


	
