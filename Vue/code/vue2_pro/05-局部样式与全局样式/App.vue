<template>
    <div>
        <User></User>
        <Vip></Vip>
    </div>
</template>

<script>

    // 导入组件
    // 这里User.vue和Vip.vue的样式重名了，最终起作用的是后引入的样式，即Vip的样式会覆盖掉User的样式
    // 把样式设置为局部样式，就不会出现覆盖现象 (在style 标签中添加scoped)
    import User from './components/User.vue'
    import Vip from './components/Vip.vue'

    export default {
        //注册组件
        name: 'App',
        components: {
            User,Vip
        }
    }
</script>

<style>
    /* 一般在App根组件中样式不会添加scoped，因为根组件的样式希望采用全局的方式处理 */
</style>