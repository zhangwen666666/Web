<template>
    <div>
        <MyHeader/>
        <div>
            <h1>省份</h1>
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
        components: {MyHeader}
    }
</script>

<style lang="css">
    .s1{
        margin-left: 100px;
    }
    .s2{
        margin-left: 200px;
    }
    .selected{
        background-color: aqua;
    }
</style>