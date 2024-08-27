<template>
    <div>
        <h1>用户列表</h1>
        <input type="text" v-model="username">
        <button @click="saveUser(username)">保存用户</button>
        <ul>
            <!-- <li v-for="user in $store.state.users" :key="user.id"> -->
            <!-- 定义了一个计算属性 -->
            <li v-for="user in users" :key="user.id">
                用户名：{{user.name}}
            </li>
        </ul>
        <h3>当前用户数量：{{users.length}}</h3>
        <h3>当前会员数量：{{vips.length}}</h3>
        <h3>用户名：{{uname}}</h3>
        <h3>反转之后的用户名：{{reversedName }}</h3>
    </div>
</template>

<script>
    // vuex插件提供的内置的mapState对象（负责state对象映射工作的一个对象）
    // 这个mapState对象实际上是一个函数
    import {mapState, mapGetters, mapActions} from 'vuex'
    export default {
        name: 'User',
        data(){
            return {
                username:'',
            }
        },
/*         mounted(){
            // mapState({计算属性属性名: 值})
            // 这里的值就是计算属性中$Store.state中的值
            const x = mapState({'users':'users', vips:'vips',uname:'uname'})
            console.log(x);
        }, */
        computed: {
            // 以下计算属性的格式都是固定的
            // 只要格式是固定的，代码就是可以自动生成的
            // users(){
            //     return this.$store.state.users
            // },
            // vips(){
            //     return this.$store.state.vips
            // },
            // uname(){
            //     return this.$store.state.uname
            // },

            // vuex可以借助mapState帮我们自动生成以上的代码
            // 对象形式
            // ...mapState({'users':'users', 'vips':'vips',uname:'uname'})
            // 数组形式，前提是计算属性名和state中的属性名一样
            ...mapState(['users','vips','uname']),
            ...mapGetters(['reversedName'])
        },
        methods:{
            // 以下方法中大部分也是固定的，只有方法名不确定，以及dispatch或commit中的两个参数是不确定的
            saveUser(){
                this.$store.dispatch('saveUser', this.username)
                // this.$store.commit('SAVE_USER', {id: Date.now(), name: this.username})
            },

            // 下一个环节走的是action
            // 在这里传方法名，以及action的方法名，
            // action的参数在<button @click="saveUser(username)">保存用户</button>传
            // 对象形式
            // ...mapActions({saveUser:'saveUser'})

            // 数组形式
            ...mapActions(['saveUser'])
        }
    }
</script>