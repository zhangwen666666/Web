<template>
<!-- 不使用参数 -->
<!--     <div class="s1">
        <ul>
            <li><router-link :to="{name:'ty'}" active-class="selected">太原市</router-link></li>
            <li><router-link to="/shanxi/datong" active-class="selected">大同市</router-link></li>
            <li>临汾市</li>
            <li>运城市</li>
        </ul>

        <router-view></router-view>
    </div> -->


    <!-- 动态传参 -->
    <div class="s1">
        <ul>
            <!-- <li><router-link :to="{name:'ty',query:{a:ty[0], b:ty[1], c:ty[2]}}" active-class="selected">太原市</router-link></li> -->
            <!-- <li><router-link to="/shanxi/datong?a1=新荣区&a2=南郊区" active-class="selected">大同市</router-link></li> -->


            <!-- <li><router-link :to="`/shanxi/datong?a1=${dt[0]}&a2=${dt[1]}&a3=${dt[2]}&a4=${dt[3]}`" active-class="selected">大同市</router-link></li>
            <li><router-link :to="{
                name: 'ty',
                query:{
                    a1: ty[0],
                    a2: ty[1],
                    a3: ty[2]
                }
            }" active-class="selected">太原市</router-link></li> -->
            <li><router-link active-class="selected" :to="{name:'lin',params:{
                    a1:lf[0],
                    a2:lf[1],
                    a3:lf[2],
                }
            }">临汾市</router-link></li>
            <li><router-link active-class="selected" :to="{name:'yc',params:{a1:yc[0],a2:yc[1],a3:yc[2]}}">运城市</router-link></li>

            <button @click="goDaTong">大同</button><br>
            <button @click="goTaiYuan">太原</button>
        </ul>

        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'ShanXi',
        methods:{
            goDaTong(){
                this.$router.push({name:'dt', params:{a1:this.dt[0],a2:this.dt[1],a3:this.dt[2]}},() => {},() => {})
            },
            goTaiYuan(){
                this.$router.replace({name:'ty',params:{a1:this.ty[0], a2:this.ty[1], a3:this.ty[2]}},() => {},() => {})
            }
        },
        data(){
            return {
                ty:[
                    '太原三区',
                    '太原二区',
                    '太原一区'
                ],
                dt:[
                    '新荣区',
                    '矿区',
                    '南郊区',
                    '城区'
                ],
                lf:[
                    '临汾三区',
                    '临汾一区',
                    '临汾五区'
                ],
                yc:[
                    '运城三区',
                    '运城一区',
                    '运城五区'
                ]
            }
        }
    }
</script>
