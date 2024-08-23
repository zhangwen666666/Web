<template>
    <div>
        <User></User>
        <hr>
        <Vip></Vip>  
        <hr>
        <Name></Name>
    </div>
</template>

<script>
    import Name from './components/Name.vue'
    import User from './components/User.vue'
    import Vip from './components/Vip.vue'
    export default {
        name: 'App',
        components:{User, Vip, Name}
    }
</script>