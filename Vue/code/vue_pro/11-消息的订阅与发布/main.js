// 等同于引入vue.js文件
import Vue from 'vue'
// 导入App组件
import App from './App.vue'

// 关闭生产提示信息
Vue.config.productionTip = false

new Vue({
  el: '#app',
  render: h => h(App),
})


/*
	消息的订阅与发布机制：使用这种机制，也可以完成任意组件之间的数据传递。（能完成和全局事件总线一样的功能）

	1. 假设A组件订阅消息，B组件发布消息 （订阅方负责接收数据，发布方负责发送数据）
		A组件：
			订阅('2023年第五期英语周报',function(a, b){
				// 这个回调函数将来会被自动调用。
			})
			关于回调函数的两个参数：
				a参数：消息的题目
				b参数：是具体的数据(具体的消息)
		B组件：
			发布('2023年第五期英语周报','这里是周报的详情')

	2. 我们要使用消息的订阅与发布机制的话，需要借助第三方库，第三方库有很多，我们选择pubsub-js 这个库，
		这个库可以在任何前端框架中使用，使用这个库都是为了完成消息的订阅与发布，也就是数据的传递

	3. 装好pubsub-js库之后，就有一个pubsub对象(需要import导入),使用这个对象就能完成消息的订阅和发布

	4. 步骤
		第一步：在发送方和接收方导入pubsub对象：import pubsub from 'pubsub-js'
		第二步：接收方在组件挂载完毕之后订阅消息 (mounted函数)
			mounted(){
				// A组件挂载完毕之后订阅消息
				// 以下的函数最好使用箭头函数，可以保证this是vc组件实例
				// this.pid = pubsub.subscribe('2023年第五期英语周报', function(messageName, message){
				this.pid = pubsub.subscribe('2023年第五期英语周报', (messageName, message) => {
					// messageName就是消息的名字
					// message是具体的消息(数据)
					// 只要消息名字是'2023年第五期英语周报'的消息一发布，这个函数就会自动被调用
					// pid是订阅的id，取消的时候要用
					console.log('消息的名字: ', messageName);
					console.log('消息的内容', message);
				})
			}
		第三步：发送方发布消息
		    publishEnglish(){
                // 发布消息
                pubsub.publish('2023年第五期英语周报', '这是第五期英语周报的详细内容')
            }

	5. 注意：当前组件实例销毁之前，要取消之前订阅的所有消息。
		beforeDestroy(){
			pubsub.unsubscribe(this.pid)
		}
*/