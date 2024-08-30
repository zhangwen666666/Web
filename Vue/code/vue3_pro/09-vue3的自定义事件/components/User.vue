<template>
    <button @click="triggerEvent1">触发event1事件</button>
</template>

<script>
    export default {
        name: 'User',
        // setup还有一个参数context，代表组件上下文对象
        setup(props, context){
            function triggerEvent1(){
                context.emit('event1', 'zhangsan', 50)
            }
            return {triggerEvent1}
        }
    }
</script>
