<template>
	<!-- 给User组件绑定自定义事件 -->
	<User @event1="showInfo"/>
</template>

<script>
	import User from './components/User.vue'
	import {ref} from 'vue'
	export default {
		name: 'App',
		components: {User},
		setup(){
			// data
			// methods
			function showInfo(name, age){
				alert(`name: ${name}, age: ${age}`)
			}
			return {showInfo}
		},
	}
</script>
