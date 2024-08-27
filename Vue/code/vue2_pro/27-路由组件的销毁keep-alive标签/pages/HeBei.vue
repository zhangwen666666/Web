<template>
    <div class="s1">
        <div>
            <h2>市</h2>
            <ul>
                <!-- 默认情况下，组件切换之后，原先的组件就被销毁了 -->
                <li><input type="checkbox"><router-link :replace=true :to="{name: 'shi', params:{a1: sjz[0], a2: sjz[1], a3: sjz[2]}}" active-class="selected">石家庄</router-link></li>
                <li><input type="checkbox"><router-link replace :to="{name: 'han', params:{a1: hd[0], a2: hd[1], a3: hd[2]}}" active-class="selected">邯郸</router-link></li>
                <li><input type="checkbox">唐山</li>
                <li><input type="checkbox">保定</li>

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
        beforeDestroy(){
            console.log('@河北省下面的市这个组件被销毁了');
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