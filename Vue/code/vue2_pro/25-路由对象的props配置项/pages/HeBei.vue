<template>
    <div class="s1">
        <div>
            <h2>市</h2>
            <ul>
                <!-- 这里路径要将父级路径也写上 -->
                <!-- params形式传参  url/value1/value2 这种方式需要再路由的path处标记 -->

                <!-- 字符串形式 写死的字符串 -->
                <!-- <li><router-link to="/hebei/sjz/裕华区/新华区/长安区" active-class="selected">石家庄</router-link></li>
                <li><router-link to="/hebei/hd/邯山区/丛台区/复兴区" active-class="selected">邯郸</router-link></li> -->
                
                <!-- 在实际的开发中，这里传的数据不会写死,使用ES6的模版语法 字符串形式-->
                <!-- <li><router-link :to="`/hebei/sjz/${sjz[0]}/${sjz[1]}/${sjz[2]}`" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="`/hebei/hd/${hd[0]}/${hd[1]}/${hd[2]}`" active-class="selected">邯郸</router-link></li> -->

                <!-- 传参时还可以使用对象形式 （如果使用params方式传参，这里只能使用name，不能使用path） -->
                <li><router-link :to="{name: 'shi', params:{a1: sjz[0], a2: sjz[1], a3: sjz[2]}}" active-class="selected">石家庄</router-link></li>
                <li><router-link :to="{name: 'han', params:{a1: hd[0], a2: hd[1], a3: hd[2]}}" active-class="selected">邯郸</router-link></li>
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