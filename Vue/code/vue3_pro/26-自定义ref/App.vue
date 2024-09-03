<template>
	<input type="text" v-model="name"><br>
	<!-- 使用自定义的ref完成隔一秒 -->
	{{name}}
</template>

<script>
	import { customRef, ref } from "vue";
	export default {
		name: 'App',
		setup(){
			// data
			// let name = ref('test')

			// 创建一个防抖的ref
			// 以下这个代码就是真正的属于自己定义的ref了。
			// ref是一个函数，那么我们自己定义的ref同样是一个函数。
			function useDebouncedRef(value){
				let t
				// 自定义的ref这个函数体当中的代码不能随便写，必须符合ref规范。
				// 通过调用customRef函数来获取一个自定义的ref对象。
				// 注意：调用customRef函数的时候必须给该函数传递一个回调：这个回调可以叫做factory
				// 对于这个回调函数来说，有两个非常重要的参数：track是追踪，trigger是出发
				const x = customRef((track, trigger) => {
					// 对于factory这个回调来说，必须返回一个对象，并且对象中要有get
					return {
						// 模版语句中只要使用到该数据，get会自动调用
						get(){
							console.log('get调用了');
							// 告诉vue去追踪这个value的变化
							track()
							return value
						},
						// 当模版语句中修改该数据的时候，set会自动调用
						set(newValue){
							// 这种设置setTimeout会出现抖动的情况(当输入速度较快时)
							// setTimeout(() => {
							// 	console.log('set调用了', newValue);
							// 	value = newValue
							// 	// 触发(通知去调用get方法)
							// 	trigger()
							// },1000)

							// 解决方法
							clearTimeout(t)
							t = setTimeout(() => {
								console.log('set调用了', newValue);
								value = newValue
								// 触发(通知去调用get方法)
								trigger()
							},1000)
						}
					}
				})
				
				// 返回自定义的ref对象实例。
				return x
			}

			// 使用自定义的ref同样具备响应式
			let name = useDebouncedRef('test')

			// 返回一个对象
			return {name}
		}
	}
</script>

