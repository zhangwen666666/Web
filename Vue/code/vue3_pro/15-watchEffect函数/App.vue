<template>
	<h2>计数器1: {{data.counter1}}</h2>
	<button @click="data.counter1++">点我加1</button><br>
	<h2>计数器2: {{data.counter2}}</h2>
	<button @click="data.counter2++">点我加1</button><br>
	<h2>计数器3: {{data.counter3}}</h2>
	<button @click="data.counter3++">点我加1</button><br>
</template>

<script>
	import { reactive, watch, watchEffect } from 'vue'
	export default {
		name: 'App',
		setup(){
			let data = reactive({
				counter1: 1,
				counter2: 10,
				counter3: 100,
			})

			// 使用watchEffect这个组合的API。作用也是用来监视的
			// watchEffect函数中直接跟一个回调函数即可。
			// 这个回调函数中用到的某个数据发生变化的时候，回调函数就会执行。
			// 这个回调函数一开始就会先执行一次
			watchEffect(() => {
				// 这个回调函数当中使用了data.counter1和data.counter2
				// 只要这两个数据发生了变化，这个回调函数就会执行。
				const a = data.counter1
				const b = data.counter3
				console.log(a, b);
			})

			return {data}
		}
		
	}
</script>
