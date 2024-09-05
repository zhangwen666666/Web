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
    }
</script>
