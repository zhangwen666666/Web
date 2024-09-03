<template>
	<input type="text" v-model="name"><br>
	<!-- 采用watch完成间隔一秒显示 -->
	{{newName}}
</template>

<script>
	import { ref, watch } from "vue";
	export default {
		name: 'App',
		setup(){
			let name = ref('')
			let newName = ref(name.value)

			// 侦听属性
			watch(name, (newValue) => {
				// console.log(newValue);
				// newName.value = newValue

				// 隔一秒
				setTimeout(() => {
					newName.value = newValue
				}, 1000)
			})

			return {name, newName}
		}
	}
</script>

