<template>
    <button @click="triggerEvent1">触发全局事件总线的event1事件</button>
    <button @click=clearAllEvent>解除全局事件总线上的所有绑定的事件</button>
</template>

<script>
	import emitter from '../utils/event-bus.js'
    export default {
        name: 'User',
        setup(){
            function triggerEvent1(){
                emitter.emit('event1', {name: 'zhangsan', age: 50})
            }
            function clearAllEvent(){
                // 清除总线上绑定的所有事件
                emitter.all.clear()

                // 清除指定的事件
                // emitter.off('event1)
            }
            return {triggerEvent1, clearAllEvent}
        }
    }
</script>
