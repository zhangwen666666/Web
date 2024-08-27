<template>
    <div>
        <input type="text" v-model.lazy="$store.state.uname">
        <br>
        <h3>用户名：{{uname}}</h3>
        <h3>反转之后的用户名：{{reversedName}}</h3>
    </div>
</template>

<script>
    import {mapState,mapGetters} from 'vuex'
    export default {
        name: 'Name',
        computed:{

            ...mapState(['uname',]),
            // 实际上生成的代码
            // uname(){
            //     return this.$store.state.uname
            // },

            // 由于$store.state.uname是双向数据绑定的，实际上我们需要set和get方法同时都存在
            // 因此vuex的mapState不能满足，我们也就没必要使用它了
            // uname:{
            //     get(){
            //         console.log(this);
            //         return this.$store.state.uname
            //     },
            //     set(val){
            //         // 这样会递归
            //         // this.uname = val
            //         this.$store.state.uname = val
            //     }
            // },
            ...mapGetters(['reversedName'])
        }
    }
</script>
