<template>
    <div>

    </div>
</template>

<script>
    import pubsub from 'pubsub-js'
    export default {
        name: 'A',
        mounted(){
            // A组件挂载完毕之后订阅消息
            // this.pid = pubsub.subscribe('2023年第五期英语周报', function(messageName, message){
            //     // messageName就是消息的名字
            //     // message是具体的消息(数据)
            //     // 只要消息名字是'2023年第五期英语周报'的消息一发布，这个函数就会自动被调用
            //     console.log('消息的名字: ', messageName);
            //     console.log('消息的内容', message);
            // }) 
            
            this.pid = pubsub.subscribe('2023年第五期英语周报', (messageName, message) => {
                // messageName就是消息的名字
                // message是具体的消息(数据)
                // 只要消息名字是'2023年第五期英语周报'的消息一发布，这个函数就会自动被调用
                console.log('消息的名字: ', messageName);
                console.log('消息的内容', message);
                console.log(this);
            }) 
        },
        beforeDestroy(){
			pubsub.unsubscribe(this.pid)
		}
    }
</script>
