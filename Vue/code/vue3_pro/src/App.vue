<template>
	<h2>计数器：{{counter}}</h2>
	<button @click="counter++">plus one</button>
	<h2>计数器2: {{counter2}}</h2>
	<button @click="counter2++">plus one</button>
</template>

<script>
	import { reactive, watch } from 'vue'
	export default {
		name: 'App',
		// vue3中的监视属性 组合式API：watch
		setup(){

		}
	}
</script>
