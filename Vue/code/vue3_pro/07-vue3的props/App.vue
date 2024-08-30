<template>
	<User name="张三" age="30" :sex="sex"></User>
</template>

<script>
	import User from './components/User.vue'
	import {ref} from 'vue'
	export default {
		name: 'App',
		setup(){
			// data
			let sex = ref('男')
			// methods

			// 返回对象
			return {sex}
		},
		components: {User}
	}
</script>

<style>

</style>
