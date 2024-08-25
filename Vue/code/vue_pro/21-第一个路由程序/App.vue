<template>
    <div>
        <div>
            <h1>省份</h1>
            <ul>
                <!-- 如果使用的是路由方式，就不能使用超链接a标签了，需要使用vue-router插件提供的一个标签 -->
                <!-- router-link 将来会被自动编译为a标签 to中写的是index.js文件中路由配置的路径 -->
                <!-- active-class表示当激活的时候使用"selected"样式 -->
                <li><router-link to="/hebei" active-class="selected">河北省</router-link></li>
                <li><router-link to="/henan" active-class="selected">河南省</router-link></li>
            </ul>
        </div>

        <!-- 这个位置将来是要显示对应的组件的 -->
        <!-- <HeBei></HeBei>
        <HeNan></HeNan> -->

        <!-- 路由试图，其实就是起到一个占位的作用 -->
        <router-view></router-view>
    </div>
</template>

<script>
/*     import HeBei from './components/hebei.vue'
    import HeNan from './components/henan.vue' */
    export default {
        name: 'App',
        // components: {HeBei,HeNan}
    }
</script>

<style lang="css">
    .s1{
        margin-left: 100px;
    }
    .selected{
        background-color: aqua;
    }
</style>