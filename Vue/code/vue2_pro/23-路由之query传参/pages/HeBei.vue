<template>
    <div class="s1">
        <div>
            <h2>市</h2>
            <ul>
                <!-- 这里路径要将父级路径也写上 -->
                <!-- query形式传参  url?name1=value1&name2=value2 -->
                <!-- <li><router-link to="/hebei/city?a1=长安区&a2=裕华区&a3=新华区" active-class="selected">石家庄</router-link></li> -->
                
                <!-- 在实际的开发中，这里传的数据不会写死,使用ES6的模版语法 -->
                <!-- <li><router-link :to="`/hebei/city?a1=${sjz[0]}&a2=${sjz[1]}&a3=${sjz[2]}`" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="`/hebei/city?a1=${hd[0]}&a2=${hd[1]}&a3=${hd[2]}`" active-class="selected">邯郸</router-link></li> -->

                <!-- 传参时可以使用计算属性 -->
                <!-- <li><router-link :to="sjzComputed" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="hdComputed" active-class="selected">邯郸</router-link></li> -->
                
                <!-- 传参时还可以使用对象形式 -->
                <!-- <li><router-link :to="{path: '/hebei/city', query:{a1:sjz[0],a2:sjz[1],a3:sjz[2]}}" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="{path: '/hebei/city', query:{a1: hd[0], a2: hd[1], a3: hd[2]}}" active-class="selected">邯郸</router-link></li> -->

                <!-- 
                    为了解决点击其中一个，两个都会激活，还是需要其路径不同，如果路径相同，就会同时激活
                    因此在配置路由时还是需要配置两个子路由, 但是组件只需要一个了
                -->
                <!-- <li><router-link :to="{path: '/hebei/sjz', query:{a1:sjz[0],a2:sjz[1],a3:sjz[2]}}" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="{path: '/hebei/hd', query:{a1: hd[0], a2: hd[1], a3: hd[2]}}" active-class="selected">邯郸</router-link></li> -->


                <!-- 给路由命名后，path可以用名字来代替（如果使用name，必须使用对象形式，不能使用字符串形式） -->
                <li><router-link :to="{name: 'shi', query:{a1:sjz[0],a2:sjz[1],a3:sjz[2]}}" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="{name: 'han', query:{a1: hd[0], a2: hd[1], a3: hd[2]}}" active-class="selected">邯郸</router-link></li>
                <li>唐山</li>
                <li>保定</li>
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
        }
    }
</script>