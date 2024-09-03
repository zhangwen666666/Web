<template>
	数字1：<input type="number" v-model="data.num1"><br><br>
	数字2: <input type="number" v-model="data.num2"><br><br>
	求和结果: {{data.result}} <br><br>
	<button @click="sum">求和</button>

</template>

<script>
	import sum from './hooks/sum.js'
	// import { reactive } from 'vue'
	export default {
		name: 'App',
		setup(){
			// let data = reactive({
			// 	num1: 0,
			// 	num2: 0,
			// 	result: 0,
			// })

			// function sum(){
			// 	data.result = data.num1 + data.num2
			// }

			// return {data, sum}

			// 以上的代码都不用写了，直接把钩子导进来
			// 调用钩子函数并返回
			// 注意这里不需要{}
			return sum()

		}
		
	}
</script>
