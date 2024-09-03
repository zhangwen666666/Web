<template>
	<h2>计数器：{{counter}}</h2>
	<button @click="counter++">plus one</button>
	<h2>计数器2: {{counter2}}</h2>
	<button @click="counter2++">plus one</button>
</template>

<script>
	import { ref, watch } from 'vue'
	export default {
		name: 'App',
		// vue3中的监视属性 组合式API：watch
		setup(){
			let counter = ref(0)
			let counter2 = ref(100)

			// watch(哪个数据，(newValue, oldValue) => {}, 配置对象)
			// 注意：配置对象不是必须的，可以不写
			/* watch(counter, (newValue,oldValue) => {
				console.log(newValue, oldValue);
			}, {immediate: true, deep: true}) */

			// 监视另一个属性
			/* watch(counter2, (newValue, oldValue) => {
				console.log(newValue, oldValue);
			}) */

			// watch也可以一次性监视多个，采用数组的方式
			// 前提是被监视的属性执行的逻辑相同
			// 注意：同时监视多个数据，newValue和oldValue都是一个数组
			watch([counter,counter2], (newValue, oldValue) => {
				console.log(newValue, oldValue);
			})
			
			return {counter, counter2}
		}
	}
</script>
