<template>
	<!-- <h2>姓名: {{a}}</h2>
	<h2>年龄：{{b}}</h2>
	<button @click="sH">SAY HI</button> -->

	<h2>姓名: {{name}}</h2>
	<h2>年龄：{{age}}</h2>
	<button @click="sayHi">SAY HI</button>
	<button @click="sayHello('jack', 20, $event)">SAY Hello</button>
</template>

<script>
	// 导入一个渲染函数
	import {h} from 'vue'
	export default {
		name: 'App',
		// 1.setup是Vue3新增的一个配置项
		// 2.setup是一个函数。
		// 3.在setup函数体当中编写 data、methods、computed、watch、生命周期钩子函数...
		// 		注意：如果你把data、methods、computed...还是配置到这里的话，表示使用的还是vue2的语法规则。
		// 		     如果你使用了vue3，建议不要在出现Vue2的语法，不建议vue3+vue2混合使用。
		// 
		setup(){
			// setup函数没有this
			console.log(this);
			// 数据(在setup函数体当中定义的这个变量，可以看做是之前的data)
			let name = '张三'
			let age = 10

			// 函数体当中的函数必须加function
			function sayHi(){
				// alert('hi vue3')
				alert(`姓名：${name}，年龄：${age}`)
			}

			function sayHello(a, b, event){
				alert(a + ',' + b)
				alert(event.target.innerText)
			}

			// 如果你想在模版语法中使用name和age
			// 就必须将name和age封装成一个对象，然后做为setup函数的返回值返回即可。
			// 当然这个对象当中也可以有函数。
			// return {
			// 	a : name,
			// 	b : age,
			// 	sH : sayHi
			// }
			/* return {
				name: name,
				age: age,
				sayHi: sayHi
			} */
			// 简写形式
			return {name, age, sayHi, sayHello}

			// 可以返回一个渲染函数
			// return function(){
			// 	// return h('标签名', '标签体内容')
			// 	return h('h1', 'welcome to study vue3')
			// }
			// 简写
			// return () => h('h2', 'welcome to learn vue3')
		}
	}
</script>

<style>

</style>
