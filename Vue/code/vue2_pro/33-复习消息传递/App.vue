<template>
    <div>
        <Car brand="大众" color="黑色" :price="20000" @getCount="getCount"/>
        <Car :price="1000" ref="car"/>
        <Car brand="宝马" color="蓝色" :price="50000"/>
    </div>
</template>

<script>
    import pubsub from 'pubsub-js'
    import Car from './components/Car.vue'
    export default {
        name: 'App',
        components:{Car},
        mounted(){
            this.$refs.car.$on('getCount', this.getCount)

            this.$bus.$on('getInfo', this.getInfo)

            this.pid = pubsub.subscribe('第四期数学学报', (messageName, message) => {
                console.log(messageName);
                console.log(message);
            })
        },
        beforeDestroy(){
            pusub.unsubscribe(this.pid)
        },
        methods: {
            getCount(count){
                console.log(count);
            },
            unbinding(){
                this.$off(['getCount'])
            },
            getInfo(info){
                console.log('Info.....', info);
            },
        }
    }
</script>