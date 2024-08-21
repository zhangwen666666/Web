<template>
    <div>
        <User></User>
        <Vip></Vip>
    </div>
</template>

<script>

    // 导入组件
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