<template>
	<User/>
</template>

<script>
	import { onMounted } from 'vue'
	import User from './components/User.vue'
	import emitter from './utils/event-bus.js'
	export default {
		name: 'App',
		components: {User},
		setup(){
			// data
			// methods
			onMounted(() => {
				// 给全局事件总线绑定事件
				emitter.on('event1', showInfo)
			})
			
			function showInfo(user){
				alert(`姓名：${user.name},年龄：${user.age}`)
			}
			return {showInfo}
		},
	}
</script>
