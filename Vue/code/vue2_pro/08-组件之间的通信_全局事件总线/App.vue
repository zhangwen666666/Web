<template>
    <div>
        <button @click.once="hello">内置事件的实现步骤</button>
        <User v-on:event1="dosome" @event2="doOther"></User>
        <User @event1="dosome" @event2="doOther"></User>
        <User ref="user"></User>
    </div>
</template>

<script>
    import User from './components/User.vue'
    export default {
        name:'App',
        mounted(){
            // this.$refs.user.$on('event1', this.dosome)
            this.$refs.user.$once('event1', this.dosome)
            this.$refs.user.$once('event2',this.doOther)

            // 绑定事件
            this.$bus.$on('eventx', this.test)
        },
        components:{User},
        methods:{
            hello(){
                console.log('hello Vue');
            },
            // ES6新语法， ...params可以看做是一个数组，以数组的形式接收多个参数。
            dosome(name, ...params){
                // console.log(666);
                console.log(name, params);
            },
            doOther(){
                console.log('doOther....');
            },
            test(name){
                console.log('#########',name);
            }
        }
    }
</script>
