<template>
    <div>
        <h1 ref="hh">{{msg}}</h1>
        <!-- 
        使用组件 
            1. 在App这个父组件中，找到了子组件Car，然后给Car这个子组件传数据：通过属性的形式传数据
                如果不使用v-bind指令，传过去的就是一个字符串，使用v-bind指令，传过去的就是一个数字
            2. 在父组件中获取子组件：
                第一步：打标记，在子组件标签中使用ref来打标记
                第二步：获取子组件 this.$refs.car1
                    vc.$refs (this.$refs) 可以获取页面中的所有组件，包括真实的DOM元素
            3. 注意，在父组件中也可以通过document.getElementById()来获取子组件。
                但是不建议在Vue中写原生DOM操作
        -->
        <Car brand="宝马520" color="黑色" v-bind:price="10" ref="car1"></Car>
        <hr>
        <Car brand="比亚迪汉" color="白色" :price="20"></Car>
        <hr>
        <Car :price="30"></Car>
        <hr>
        <button @click="printCarInfo">打印汽车信息</button>
    </div>
</template>

<script>
    // 导入组件
    import Car from './components/Car.vue'

    export default {
        //注册组件
        name: 'App',
        methods:{
            printCarInfo(){
                // 获取子组件
                // console.log(this.$refs.car1);
                console.log(this.$refs.car1.brand);
                console.log(this.$refs.car1.price);
                console.log(this.$refs.car1.color);

                // 获取DOM元素
                console.log(this.$refs.hh);
                console.log(this.$refs.hh.innerText);
            }
        },
        data() {
            return {
                msg: '汽车信息'
            }
        },
        components: {
            Car
        }
    }
</script>