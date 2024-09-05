<template>
    <div>
        <h1>{{msg}}</h1>
        <h3>姓名：{{name}}</h3>
        <h3>年龄：{{age}}</h3>
        <button @click="printInfo">打印会员信息</button>
        <button @click="a">会员a</button>
    </div>
</template>

<script>
    
    export default {
        name: 'Vip',
        data(){
            return {
                msg: '会员信息',
                name: '李四',
                age: 30,
            }
        },
        methods: {
            a(){
                console.log('vip a ...');
            }
        }
    }
</script>
