<template>
    <h1>User组件</h1>
    <h2>{{counter}}</h2>
    <button @click="counter++">计数器加1</button>
</template>

<script>
    // 在Vue3当中，生命周期钩子函数有两种写法：
    // 第一种：选项式API
    // 第二种：组合式API (在setup函数体中编写)
	import {ref, onBeforeMount, onMounted, onBeforeUpdate, onUpdated, onUnmounted, onBeforeUnmount} from 'vue'
    export default {
        name: 'User',
        setup(){
            //data
            console.log('setup: 安装组合式API');
            let counter =  ref(0)

            // 生命周期钩子 
            // 如果使用了组合式API，就没有beforeCreate和created了
            onBeforeMount(() => {
                console.log('onBeforeMount');
            })
            onMounted(() => {
                console.log('onMounted');
            })
            onBeforeUpdate(() => {
                console.log('onBeforeUpdate');
            })
            onUpdated(() => {
                console.log('onUpdated');
            })
            onBeforeUnmount(() => {
                console.log('onBeforeUnMount');
            })
            onUnmounted(() => {
                console.log('onUnmounted');
            })
            return {counter}
        },

        // 选项式API
        beforeCreate(){
			console.log('beforeCreate: 正在初始化选项式API....');
		},
		created(){
			console.log('created: 选项式API初始化完成...');
		},
        // beforeMount(){
        //     console.log('beforeMount');
        // },
        // mounted(){
        //     console.log('mounted');
        // },
        // beforeUpdate(){
        //     console.log('beforeUpdate');
        // },
        // updated(){
        //     console.log('updated');
        // },
        // beforeUnmount(){
        //     console.log('beforeUnmount');
        // },
        // unmounted(){
        //     console.log('unmounted');
        // }
    }
</script>
