<template>
	姓名：<input type="text" v-model.lazy="name"><br>
	反转后的姓名：<input type="text" v-model.lazy="reversedName">
</template>

<script>
	import {ref, computed} from 'vue'
	export default {
		name: 'App',
		// vue3的计算属性，computed是一个组合式API
		setup(){
			let name = ref('')

			// 计算属性简写形式
			/* let reversedName = computed(() => {
				// 只需要get方法就可以使用简写形式
				return name.value.split('').reverse().join('')
			}) */

			// 完整写法
			let reversedName = computed({
				get(){
					return name.value.split('').reverse().join('')
				},
				set(val){
					// console.log(666);
					name.value = val.split('').reverse().join('')
				}
			})

			return {name, reversedName}
		},
	}
</script>
