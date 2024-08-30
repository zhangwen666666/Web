<template>
	<!-- 在模版语法中访问RefImpl对象的时候，不需要手动.value -->
	<h1>name: {{name}}</h1>
	<h1>age: {{age}}</h1>
	<button @click="modifyInfo">修改数据</button>
</template>

<script>
	import {ref} from 'vue'
	export default {
		name: 'App',
		// 使用ref函数实现data响应式
		setup(){
			// data
			let name = ref('张三')
			let age = ref(20)
			// 这里name，age已经不是普通对象了，
			// ref对'张三'这个数据进行包裹，然后返回了一个全新的对象：引用对象RefImpl
			// RefImpl对象中有value属性，这个value属性是具有响应式的，并且这个value底层使用了Object.defineProperty完成了响应式
			// 当读取RefImpl对象的value属性时，get执行
			// 当修改RefImpl对象的value属性时：set执行
			console.log(name);
			console.log(name.value);

			// methods
			function modifyInfo(){
				name.value = 'lisi'
				age.value = 10
			}

			// 返回一个对象
			return {name,age,modifyInfo}
		}
		
		// 以下代码没有响应式
		// setup(){
		// 	// 数据data
		// 	// 通过测试得知，如果当前的data这样写，是没有响应式。
		// 	// 
		// 	let name = '张三'
		// 	let age = 20

		// 	// 方法methods
		// 	function modifyInfo(){
		// 		// 修改这个数据data时，有没有响应式
		// 		name = '李四'
		// 		age = 30
		// 	}

		// 	// 返回一个对象
		// 	return {name, age, modifyInfo}
		// }

	}
</script>

<style>

</style>
