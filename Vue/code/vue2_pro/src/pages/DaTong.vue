<template>
    <div class="s2">
        <ul>
            <li v-for="e in $route.query">
                {{e}}
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name:'DaTong'
}
</script>