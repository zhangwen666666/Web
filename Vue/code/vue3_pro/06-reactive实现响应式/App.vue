<template>
	<h2>姓名：{{userProxy.name}}</h2>
	<h2>年龄：{{userProxy.age}}</h2>
	<h2>城市：{{userProxy.addr.city}}</h2>
	<h2>街道：{{userProxy.addr.street}}</h2>
	<h2>性别：{{userProxy.sex}}</h2>
	<button @click="modifyUser">修改</button>
	<button @click="addSex">添加性别属性</button>
	<button @click="delSex">删除性别属性</button>
	<br>
	<ul>
		<li v-for="c,index in userProxy.courses" :key="index">
			{{index}} , {{c}}
		</li>
	</ul>
	<br>
	<button @click="modifyCourse">修改课程</button>
</template>

<script>
	import {reactive, ref} from 'vue'
	export default {
		name: 'App',
		setup(){
			// data
			// 基本数据类型不能使用reactive包裹。只能使用ref包裹
			// let counter = reactive(100)
			// reactive函数，可以将一个对象直接包裹。实现响应式。底层是生成一个Proxy对象。
			// reactive包裹的不用.value
			let userProxy = reactive({
				name : '张三',
				age: 30,
				addr: {
					city: '北京',
					street: '大兴区'
				},
				courses: ['语文', '数学', '英语']
			})
			// methods
			function modifyUser(){
				userProxy.name = '李四'
				userProxy.age = 50
				userProxy.addr.city = '天津'
				userProxy.addr.street = '西青区'
			}
			function addSex(){
				userProxy.sex = '男'
			}
			function delSex(){
				delete userProxy.sex
			}
			function modifyCourse(){
				userProxy.courses[2] = '政治'
			}

			// 返回对象
			return {userProxy, modifyUser, addSex, delSex,modifyCourse}
		}
	}
</script>

<style>

</style>
