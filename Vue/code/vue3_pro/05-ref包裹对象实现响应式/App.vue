<template>
	<h2>姓名：{{user.name}}</h2>
	<h2>年龄：{{user.age}}</h2>
	<h2>城市：{{user.addr.city}}</h2>
	<h2>街道：{{user.addr.street}}</h2>
	<h2>计数器：{{counterRefImpl}}</h2>
	<button @click="modifyUser">修改用户信息</button>
</template>

<script>
	// 如果ref包裹的是一个基本数据类型，响应式是通过Object.defineProperty实现的
	// 如果ref包裹的是一个对象，响应式是通过Object.defineProperty + Proxy实现的
	import {ref} from 'vue'
	export default {
		name: 'App',
		setup(){
			// data
			let counterRefImpl = ref(100)
			console.log(counterRefImpl);

			let userRefImpl = ref({
				name: 'jack',
				age: 20,
				addr: {
					city: '北京',
					street: '大兴区'
				}
			})
			console.log(userRefImpl);
			console.log(userRefImpl.value);

			// methods
			function modifyUser(){
				counterRefImpl.value = 200

				// 这种方式使用的Object.defineProperty实现的
				// userRefImpl.value = {
				// 	name: '张三',
				// 	age: 50
				// }

				// userRefImpl.value是一个Proxy对象
				// 可以直接使用这个对象访问他的属性
				userRefImpl.value.name = 'lucy'
				userRefImpl.value.age = 30
				userRefImpl.value.addr.city = '天津'
				userRefImpl.value.addr.street = '西青区'
			}

			// 返回对象
			return {user:userRefImpl, modifyUser, counterRefImpl}
		}

		// setup(){
		// 	// data
		// 	// 如果这里是一个对象的话，默认也是没有响应式处理的。
		// 	let user = {
		// 		name: 'jack',
		// 		age: 20
		// 	}

		// 	// methods
		// 	function modifyUser(){
		// 		user.name = 'lucy'
		// 		user.age = 30
		// 	}

		// 	// 返回对象
		// 	return {user, modifyUser}
		// }
	}
</script>

<style>

</style>
