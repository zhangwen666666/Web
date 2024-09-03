<template>
	<h2>计数器：{{data.a.b.c.counter}}</h2>
	<button @click="data.a.b.c.counter++">点我加1</button><hr>
	<h2>计数器：{{data.counter2}}</h2>
	<button @click="data.counter2++">点我加1</button>
</template>

<script>
	import { reactive, shallowReactive } from 'vue'
	export default {
		name: 'App',
		setup(){
			// reactive包裹的数据是有响应式的
			// let data = reactive({
			// 	a: {
			// 		b: {
			// 			c: {
			// 				counter: 1
			// 			}
			// 		}
			// 	}
			// })

			// shallowReactive只会给第一层数据做响应式，深层次的不具有响应式
			let data = shallowReactive({
				counter2: 1000,
				a: {
					b: {
						c: {
							counter: 1
						}
					}
				}
			})
			return {data}
		}
	}
</script>
