<template>
</template>

<script>
	import { isProxy, isReactive, isReadonly, isRef, reactive, readonly, ref } from 'vue'
	export default {
		name: 'App',
		setup(){
			// 这里可能会定义很多个变量。
			// 这些变量哪个是具有响应式的，哪个是没有响应式的。
			// 这个数据可能是别的组件传递过来的。

			// 判断某个数据是否是ref的。
			let counter = 1
			console.log(isRef(counter));	// false
			let counter1 = ref(2)
			console.log(isRef(counter1));	// true

			// 判断某个对象是否通过 reactive或者shallowReactive获取的代理
			let data = reactive({
				counter: 1
			})
			console.log(isReactive(data));	// true
			let data1 = {
				counter: 1
			}
			console.log(isReactive(data1));	// false

			// 判断某个对象是否为代理对象
			console.log(isProxy(data));		// true
			console.log(isProxy(data1));	// false

			// 判断某个对象是否是只读对象
			console.log(isReadonly(data));	// false
			data = readonly(data)
			console.log(isReadonly(data));	// true

			// 采用isProxy判断是否是只读的，只读的返回true
			console.log(isProxy(data1));	// false
			data1 = readonly(data1)
			console.log(isProxy(data1));
		}
	}
</script>
