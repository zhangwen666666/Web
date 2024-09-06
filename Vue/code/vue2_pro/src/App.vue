<template>
    <div>
        <MyHeader/>
        <router-link to="/shanxi" active-class="selected">山西省</router-link><br>
        <router-link to="/hebei" active-class="selected">河北省</router-link><br>

        <button @click="forward">前进一步</button>
        <button @click="forwardTwo">前进两步</button>
        <button @click="back">后退一步</button>
        <button @click="backTwo">后退两步</button>

        <router-view></router-view>
    </div>
</template>

<script>
    import MyHeader from './components/MyHeader.vue'
    export default {
        name: 'App',
        components: {MyHeader},
        methods:{
            forward(){
                this.$router.forward()
            },
            forwardTwo(){
                this.$router.go(2)
            },
            back(){
                this.$router.back()
            },
            backTwo(){
                this.$router.go(-2)
            }
        }
    }
</script>

<style>
    .s1{
        margin-left: 50px;
    }
    .selected{
        background-color: aqua;
    }
    .s2{
        margin-left: 100px;
    }
</style>