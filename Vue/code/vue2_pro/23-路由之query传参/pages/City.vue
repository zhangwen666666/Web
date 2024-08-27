<template>
    <div class="s2">
        <h2>区</h2>
        <ul>
            <!-- <li>{{$route.query.a1}}</li>
            <li>{{$route.query.a2}}</li>
            <li>{{$route.query.a3}}</li> -->
            <li v-for="propertyValue,propertyName in $route.query">{{propertyValue}}</li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: 'City',
        mounted(){
            // 所有的路由组件都有一个属性 $route
            // 这个属性可以拿到当前组件所关联的路由对象
            console.log(this.$route);
            // 拿到传过来的query
            console.log(this.$route.query);
        }
    }
</script>