<template>
    <div>
        <button @click="showInfo">打印汽车信息</button>
        <button @click="getCount">打印汽车余量</button>
        <button @click="getInfo">打印信息</button>
        <button @click="publish">点击发布消息</button>
    </div>
</template>

<script>
    import pubsub from 'pubsub-js'
    export default {
        name: 'Car',
        props: {
            brand:{
                type: String,
                required:false
            },
            price:{
                type: Number,
                required:true,
            },
            color:{
                type: String,
                default: '白色'
            }
        },
        data(){
            return {
                count: 200,
            }
        },
        methods:{
            showInfo(){
                console.log('brand:',this.brand, 'price:', this.price, 'color:',this.color)
            },
            getCount(){
                this.$emit('getCount',this.count)
                // console.log(666);
            },
            getInfo(){
                this.$bus.$emit('getInfo', '这是一段汽车的相关介绍')
            },
            publish(){
                pubsub.publish('第四期数学学报', {brand:this.brand, price:this.price, color:this.color})
            }
        },
    }
</script>

<style>

</style>