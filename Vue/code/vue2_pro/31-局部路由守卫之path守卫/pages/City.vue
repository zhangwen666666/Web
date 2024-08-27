<template>
    <div class="s2">
        <h2>区</h2>
        <ul>
            <li>{{a1}}</li>
            <li>{{a2}}</li>
            <li>{{a3}}</li>
            <!-- <li>{{x}}</li>
            <li>{{y}}</li> -->
            <!-- <li v-for="propertyValue,propertyName in $route.params">{{propertyValue}}</li> -->
        </ul>
    </div>
</template>

<script>
    export default {
        name: 'City',
        // 接收路由传递过来的props
        // props: ['x', 'y', 'a1', 'a2', 'a3']
        props: ['a1', 'a2', 'a3']
    }
</script>