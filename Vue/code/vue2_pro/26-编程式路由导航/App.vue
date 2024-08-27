<template>
    <div>
        <MyHeader/>
        <div>
            <h1>省份</h1>
            <button @click="forward">前进</button>
            <button @click="back">后退</button>
            <button @click="forwardTwo">前进两步</button>
            <button @click="backTwo">后退两步</button>
            <ul>
                <li><router-link to="/hebei" active-class="selected">河北省</router-link></li>
                <li><router-link to="/henan" active-class="selected">河南省</router-link></li>
            </ul>
        </div>

        <router-view></router-view>
    </div>
</template>

<script>
    import MyHeader from './components/MyHeader.vue'
    export default {
        name: 'App',
        components: {MyHeader},
        methods: {
            // 前进
            forward(){
                this.$router.forward()
            },
            // 后退
            back(){
                this.$router.back()
            },
            // 前进两步
            forwardTwo(){
                this.$router.go(2)
            },
            // 后退两步
            backTwo(){
                this.$router.go(-2)
            },
        }
    }
</script>

<style lang="css">
    .s1{
        margin-left: 100px;
    }
    .s2{
        margin-left: 100px;
    }
    .selected{
        background-color: aqua;
    }
</style>