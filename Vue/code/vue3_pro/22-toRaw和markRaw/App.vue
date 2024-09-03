<template>
	<h2>{{data}}</h2><br>
	<h2>计数器1: {{data.counter1}}</h2>
	<button @click="data.counter1++">计数器加1</button><br>
	<h2>计数器2: {{data.x}}</h2>
	<button @click="data.x.counter2++">计数器加1</button><br><hr>
	<button @click="getRawObject">获取data的原始对象</button><br>
	<button @click="addX">给data扩展一个x属性</button>
</template>

<script>
	import { markRaw, reactive, toRaw } from 'vue'
	export default {
		name: 'App',
		setup(){
			// data (具备响应式的)
			let data = reactive({
				counter1: 1
			})

			// 获取data这个响应式对象的原始对象
			// 操作原始对象的时候，没有响应式处理的。
			function getRawObject(){
				// rawObj就是一个原始对象。是data的原始对象
				let rawObj = toRaw(data)
				// 修改原始对象，不会具有响应式
				rawObj.counter1++
				console.log('原始对象', rawObj);
			}

			function addX(){
				// 给data扩展一个x属性
				// 这里扩展的x属性也是响应式的
				// data.x = {counter2: 100}
				
				// 使用markRaw标记的属性不具有响应式 
				data.x = markRaw({counter2: 100})
			}

			// 返回一个对象
			return {data, getRawObject, addX}
		}
	}
</script>
