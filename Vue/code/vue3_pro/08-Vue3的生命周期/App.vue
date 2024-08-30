<template>
	<button @click="isDisplay = !isDisplay">显示或隐藏</button>
	<User v-if="isDisplay"/>
</template>

<script>
	import User from './components/User.vue'
	import {ref} from 'vue'
	export default {
		name: 'App',
		components: {User},
		setup(){
			// console.log('setup: 安装组合式API');
			let isDisplay = ref(true)
			return {isDisplay}
		},
	}
</script>

<style>

</style>
