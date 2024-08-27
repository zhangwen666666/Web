<template>
    <div class="s1">
        <div>
            <h2>市</h2>
            <ul>
                <!-- 
                    :replace=true表示对于此链接，浏览器开启replace模式
                -->
                <!-- 以下这种使用router-link的被称为声明式的路由导航 （只适合超链接） -->
                <li><router-link :replace=true :to="{name: 'shi', params:{a1: sjz[0], a2: sjz[1], a3: sjz[2]}}" active-class="selected">石家庄</router-link></li>
                <li><router-link replace :to="{name: 'han', params:{a1: hd[0], a2: hd[1], a3: hd[2]}}" active-class="selected">邯郸</router-link></li>
                <li>唐山</li>
                <li>保定</li>

                <!-- 编程式的路由导航 -->
                <button @click="goSjz">石家庄</button>
                <button @click="goHd">邯郸</button>
            </ul>
        </div>

        <!-- 区组件 -->
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'HeBei',
        data(){
            return {
                sjz: ['长安区', '裕华区', '新华区'],
                hd: ['邯山区', '复兴区', '丛台区']
            }
        },
        computed: {
            sjzComputed(){
                return '/hebei/city?a1=' + this.sjz[0] + '&a2=' + this.sjz[1] + '&a3=' + this.sjz[2]
            },
            hdComputed(){
                return '/hebei/city?a1=' + this.hd[0] + '&a2=' + this.hd[1] + '&a3=' + this.hd[2]
            }
        },
        methods:{
            goSjz(){
                // 这里编写代码，完成路由的切换。
                // 这种通过编程的方式完成路由组件的切换，被称为：编程式路由导航
                // 调用现有的API就可以可以完成路由组件的切换。
                // 先获取到路由器对象。不是路由对象
                // this.$route 获取到的是路由对象
                // this.$router 获取到的是整个项目的路由器对象。(路由器对象一般一个项目只需要一个)

                // 这是push模式
                // 在使用编程式的路由导航时，push以及replace方法会返回一个Promise对象
                // Promise对象期望你能通过参数的方式给它两个回调函数，一个是成功的回调，一个是失败的回调
                // 如果你没有给这两个回调函数，则会出现错误。怎么解决：在参数位置上给两个回调函数
                this.$router.push({
                    name: 'shi', params:{a1: this.sjz[0], a2: this.sjz[1], a3: this.sjz[2]}
                },()=>{},()=>{})
            },
            goHd(){
                this.$router.replace({
                    name: 'han', params:{a1: this.hd[0], a2: this.hd[1], a3: this.hd[2]}
                },()=>{},()=>{})
            }
        }
    }
</script>