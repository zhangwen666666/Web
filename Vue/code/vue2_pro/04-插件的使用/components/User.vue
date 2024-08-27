<template>
    <div>
        <h1>{{msg}}</h1>
        <h3>姓名：{{name}}</h3>
        <h3>年龄：{{age}}</h3>
        <button @click="printInfo">打印用户信息</button>
        <button @click="a">用户a</button>
    </div>
</template>

<script>
    // 局部混入
    // import {mix1} from '../mixin.js'
    // import {mix2} from '../mixin.js'
    // import {mix3} from '../mixin.js'
    export default {
        name: 'User',
        data(){
            return {
                msg: '用户信息',
                name: '张三',
                age: 20,
            }
        },
        mounted(){
            console.log('user mounted...');
        },
        // methods:{
        //     printInfo(){
        //         console.log(this.name, ',', this.age);
        //     }
        // }
        
        // 混入不是覆盖
        // 这里本身有一个a方法，又混入了一个a方法，会走本身的a方法
        // 如果本身没有a方法，才会走混入的a方法
        // methods: {
        //     a(){
        //         console.log('user a ...');
        //     }
        // },
        // mixins: [mix1,mix2,mix3],
    }
</script>
