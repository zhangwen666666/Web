<template>
    <div>
        <h1>A组件</h1>
        <button @click="doA1">doA1 BUTTON</button>
        <button @click="doA2">doA2 BUTTON</button>

        <!-- 访问模块数据 -->
        <h3>state: {{$store.state.aModule.a}}</h3>
        <!-- 属性名有特殊符号的，要采用中括号的方式来访问 -->
        <h3>getters: {{$store.getters['aModule/computedA']}}</h3>
    </div>
</template>

<script>
    export default {
        name: 'A',
        mounted(){
            console.log(this.$store);
        },
        methods: {
            doA1(){
                // 模块化开发会想尽一切办法找doA1方法
                // 会从所有的模块中找doA1方法
                // 由于aModule和cModule中都有doA1()方法，就都会执行
                // this.$store.dispatch('doA1')

                // 开启命名空间之后
                // 以下这种写法就只会在aModule中找doA1
                this.$store.dispatch('aModule/doA1')
            },
            doA2(){
                this.$store.commit('aModule/doA2')
            },
        },
    }
</script>
