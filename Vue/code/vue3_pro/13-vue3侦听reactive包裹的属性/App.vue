<template>
	<h2>计数器：{{data.counter}}</h2>
	<button @click="data.counter++">plus one</button>
	<h2>计数器2: {{data.a.b.c.d.counter2}}</h2>
	<button @click="data.a.b.c.d.counter2++">plus one</button>
</template>

<script>
	// 总结vue3中监视reactive包裹的属性
	// 如果watch中写的是一个对象,则拿不到oldValue, 
	// 如果watch中写的是一个普通属性,且前边是写的箭头函数，oldvalue能拿到

	// 监视响应式对象中的某个属性，且该属性是基本类型的，要写成函数式
	// 监视响应式对象中的某个属性，且该属性是对象类型的，可以直接写，也能写函数，更推荐写函数

	import { reactive, watch } from 'vue'
	export default {
		name: 'App',
		// vue3中的监视属性 组合式API：watch
		setup(){
			let data = reactive({
				counter : 1,
				a : {
					b: {
						c:{
							d:{
								counter2: 100
							}
						}
					}
				}
			})

			// watch
			// 对于reactive函数获取的代理对象，在进行侦听的时候，只能获取到newValue，oldValue无法获取
			// 对于reactive函数获取的代理对象来说，默认就是开启深度监视的。
			// 配置deep:false 可以关闭深度监视
			// watch(data, (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// },{deep: false})

			// 如果只想监视data中的counter这个属性
			// 注意点：第一个需要侦听的数据，必须是一个函数。
			// 这里可以拿到oldValue
			// watch(() => {return data.counter}, (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// })
			
			// 以下不使用箭头函数，报错
			// watch(data.counter, (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// })

			// 如果不是基本数据类型，就可以这样写
			// 这里拿不到oldValue
			// 这里配置deep是生效的
			watch(data.a.b, (newValue, oldValue) => {
				console.log(newValue, oldValue);
			}, {deep: false})

			// 箭头函数，这里的deep配置也是生效的
			// watch(() => data.a.b, (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// }, {deep: false})

			// 如果是基本数据类型，必须采用以下写法
			// 这里能拿到oldValue
			// watch(() => data.a.b.c.d.counter2, (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// })

			// 数组形式
			// 这里能拿到oldValue
			// watch([() => data.counter, () => data.a.b.c.d.counter2], (newValue, oldValue) => {
			// 	console.log(newValue, oldValue);
			// })
			return {data}
		}
	}
</script>
