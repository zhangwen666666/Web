<template>
    <div>
        <button @click="triggerEvent1">触发event1事件</button>
        <button @click="unbinding">解绑事件</button>
        <button @click="triggerEvent2">触发event2事件</button>
        <button @click="goodbye">再见</button>
        <Vip></Vip>
    </div>
</template>

<script>
    import Vip from './Vip.vue'
    export default {
        name:'App',
        data(){
            return {
                name: '张三',
                age: 20,
                gender: '男',
            }
        },
        components:{Vip},
        methods:{
            triggerEvent1(){
                // 编写触发事件event1的事件
                // 用vc的$emit()方法, 以下this就是组件对象vc
                // 触发事件的同时，可以给这个事件event1绑定的回调函数dosome传数据
                this.$emit('event1', this.name, this.age, this.gender)
            },
            triggerEvent2(){
                this.$emit('event2')
            },
            unbinding(){
                // this.$off('event1')
                // this.$off(['event1', 'event2'])
                this.$off()
            },
            goodbye(){
                this.$destroy()
            }
        }
    }
</script>