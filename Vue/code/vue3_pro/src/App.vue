<template>
	<h2>计数器:  {{counter}}</h2>
	<button @click="add">计数器加1</button>
	<User/>
</template>


<script setup>
	// 语法糖：在script标签中加一个setup
	// 这个语法糖会自动将script标签体中定义的一级的数据，函数，计算属性...交出去
	// 组件也不需要注册了，只需要引入即可
	import { ref } from "vue";
	import User from './components/User.vue'

	// data
	let counter = ref(100)
	// methods
	function add(){
		counter.value++;
	}
	// watch
	// computed
	// ...

	// export default {
	// 	name: 'App',
	// 	setup(){
	// 		// data
	// 		let counter = ref(100)

	// 		// methods
	// 		function add(){
	// 			counter.value++;
	// 		}
	// 		// watch
	// 		// computed
	// 		// ...

	// 		// 返回一个对象
	// 		return {counter, add}
	// 	}
	// }
</script>

