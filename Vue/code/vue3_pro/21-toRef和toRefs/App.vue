<template>
	<h2>{{data}}</h2><hr>
	<h2>计数器1：{{counter1}}</h2>
	<button @click="counter1++">计数器加1</button><hr>
	<h2>计数器2：{{counter2}}</h2>
	<button @click="counter2++">计数器加1</button><hr>
	<h2>计数器3：{{a.b.counter3}}</h2>
	<button @click="a.b.counter3++">计数器加1</button><hr>
</template>

<script>
	import { reactive, ref, toRef, toRefs } from 'vue'
	export default {
		name: 'App',
		setup(){
			// data
			let data = reactive({
				counter1 : 1,
				counter2 : 100,
				a: {
					b: {
						counter3: 1000
					}
				}
			})

			// 返回一个对象
			// return {data}

			// 这种方法不行，因为这种方法不具备响应式，这个数据与data无关了
			// return {
			// 	counter1: data.counter1,
			// 	counter2: data.counter2,
			// 	counter3: data.a.b.counter3,
			// }

			// 这种方法功能能实现，但是相当于
			// counter1: ref(1)
			// counter2: ref(100)
			// counter3: ref(1000)
			// 这里与data还是没有关系，点击使计数器加1时，不会让data中的数据发生改变
			// return {
			// 	data,
			// 	counter1: ref(data.counter1),
			// 	counter2: ref(data.counter2),
			// 	counter3: ref(data.a.b.counter3),
			// }
			
			// toRef(对象, '该对象中的属性名')
			// 
			// console.log(toRef(data, 'counter1'));
			// return {
			// 	data,
			// 	counter1: toRef(data, 'counter1'),
			// 	counter2: toRef(data, 'counter2'),
			// 	counter3: toRef(data.a.b, 'counter3'),
			// }

			// toRefs
			console.log(toRefs(data));
			// 
			return {data, ...toRefs(data)}
		}
	}
</script>
