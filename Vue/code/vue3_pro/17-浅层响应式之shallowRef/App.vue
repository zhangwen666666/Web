<template>
	<!-- <h2>计数器：{{counter}}</h2>
	<button @click="counter++">求和</button> -->
	<h2>计数器：{{data.counter}}</h2>
	<button @click="data.counter++">求和</button>
</template>

<script>
	// 1.对于基本数据来说，ref和shallowRef效果相同
	// 2.当shallowRef和ref都用在对象上的时候，ref是有响应式的，底层会创建Proxy代理对象
	// 		shallowRef是没有响应式的，底层也不会创建Proxy对象。
	// 3.有的时候，这个对象中的属性可能永远都不会修改，即使修改也是更换对象。显然这个时候可以使用shallowRef，进行优化
	// 注意：shallowRef更换对象是有响应式的，即data.value={counter:100}
	import { ref, shallowRef } from 'vue'
	export default {
		name: 'App',
		setup(){
			// let counter = ref(1)
			// 效果相同
			// let counter = shallowRef(1)
			// return {counter}

			// let data = ref({
			// 	counter: 1
			// })
			// 当shallowRef
			let data = shallowRef({
				counter: 1
			})
			console.log(data);
			return {data}
		}
	}
</script>
