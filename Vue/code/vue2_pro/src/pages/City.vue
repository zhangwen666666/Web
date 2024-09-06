<template>
    <div class="s2">
        <ul>
            <!-- <li v-for="elem in $route.query">
                {{elem}}
            </li> -->

            <li>{{a1}}</li>
            <li>{{a2}}</li>

            <li v-for="elem in $route.params">
                {{elem}}
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name:'City',
    props:['a1','a2','a3']
}
</script>

<style>

</style>