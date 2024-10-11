<template>
    <div>
        <button @click="getBugs">获取bug列表信息</button>
        <button @click="getUsers">获取用户信息</button>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'Bugs',
    methods:{
        getBugs(){
            // console.log(666);
            // 发送ajax请求访问：http://localhost:8000/vue/bugs
            // 使用axios库发送AJAX请求
            // axios.get('http://localhost:8080/vue/bugs').then(
            // 当前这个页面就是在8080服务器上，又去访问8080服务器上的资源，所以http://localhost:8080可以省略
            // axios.get('/vue/bugs').then(
            //     resopnse => {
            //         console.log("服务器响应回来的数据：", resopnse.data);
            //     },
            //     error => {
            //         console.log('错误信息：', error.message);
            //     }
            // )
            
            axios.get('/api/vue/bugs').then(
                resopnse => {
                    console.log("服务器响应回来的数据：", resopnse.data);
                },
                error => {
                    console.log('错误信息：', error.message);
                }
            )
        },
        getUsers(){
            axios.get('/abc/vue/users').then(
                resopnse => {
                    console.log("服务器响应回来的数据：", resopnse.data);
                },
                error => {
                    console.log('错误信息：', error.message);
                }
            )
        }
    }
}
</script>
