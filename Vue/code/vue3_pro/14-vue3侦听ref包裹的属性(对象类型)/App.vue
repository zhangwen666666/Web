<template>
	<h2>计数器: {{counterRefImpl}}</h2>
	<button @click="counterRefImpl++">点我加1</button>
	<h2>计数器2：{{data.a.b.c.counter}}</h2>
	<button @click="data.a.b.c.counter++">加1</button>
</template>

<script>
	// 如果ref里是一个基本数据类型，监视时不能使用.value。如果使用.value，需要使用箭头函数
	// 如果ref里是一个对象，不使用.value默认是不开启深度监视, 使用.value默认是开启深度监视

	import { ref, watch } from 'vue'
	export default {
		name: 'App',
		setup(){
			// data
			let counterRefImpl = ref(1)
			// watch
			// 以下这种是错误的，counterRefImpl.value就是一个普通的数字1
			// watch(counterRefImpl.value, (newValue,oldValue) => {
			// 	console.log(newValue, oldValue);
			// })

			// 以下这种是可以监视的。
			watch(() => counterRefImpl.value, (newValue,oldValue) => {
				console.log(newValue, oldValue);
			})

			let data = ref({
				a:{
					b: {
						c: {
							counter:100
						}
					}
				}
			})

			// 监视data
			// 这种监视不到，因为这里默认是没有开始深度监视的
			watch(data, (newValue, oldValue) => {
				console.log(newValue, oldValue);
			}, {deep: true})

			// 可以监视的到，但是oldValue拿不到,deep配置是有效的
			// watch(data.value, (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// }, {deep: false})

			// 返回一个对象
			return {counterRefImpl, data}
		}
		
	}
</script>
