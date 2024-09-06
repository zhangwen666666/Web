import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

import ShanXi from '../pages/ShanXi'
import HeBei from '../pages/HeBei'
// import TaiYuan from '../pages/TaiYuan'
// import DaTong from '../pages/DaTong'
import City from '../pages/City'

const router =  new VueRouter({
    routes:[
        {
            path:'/shanxi',
            component: ShanXi,
            children:[
                // {
                //     name:'ty',
                //     path: 'taiyuan',
                //     component:TaiYuan
                // },
                // {
                //     name:'dt',
                //     path:'datong',
                //     component: DaTong
                // }
                // {
                //     name:'city',
                //     path: 'city',
                //     component:City
                // },
                
                {
                    name:'dt',
                    path:'datong',
                    component:City
                },
                {
                    name:'ty',
                    path:'taiyuan',
                    component: City
                },

                {
                    name:'lin',
                    path:'linfen/:a1/:a2/:a3',
                    component: City
                },

                {
                    name:'yc',
                    path:'yuncheng/:a1/:a2/:a3',
                    component:City,
                    // props:{
                    //     a:'运城1区',
                    //     b:'运城2区'
                    // }

                    // props($route){
                    //     return {
                    //         a:$route.params.a1,
                    //         b:$route.params.a2,
                    //         // a3:$route.params[2],
                    //     }
                    // }

                    props:true
                }
            ]
        },
        {
            path:'/hebei',
            component: HeBei
        }
    ]
})

router.beforeEach((to, from, next) => {
    let username = 'zshang'
    if(to.name === "lin"||to.name === 'yc'){
        if(username === 'admin'){
            next()
        }else{
            alert('无权限查看')
        }
    }else{
        next()
    }
})

export default router