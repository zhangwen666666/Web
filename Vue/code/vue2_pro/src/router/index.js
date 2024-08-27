// 导入vue-router插件
import VueRouter from "vue-router";

// 导入组件
// 一般路由组件会放在一个pages文件夹下
import HeBei from '../pages/HeBei'
import HeNan from '../pages/HeNan'
import City from '../pages/City'

const router = new VueRouter({
    mode : 'hash',
    routes: [
        {
            name: 'bei',
            path : '/hebei',
            component: HeBei,
            meta:{title: '河北省'},
            children: [
                {
                    name: 'shi',
                    path: 'sjz/:a1/:a2/:a3',
                    component: City,
                    props: true,
                    // 带有这个属性的，并且值是true，表示该路由是需要鉴权的。
                    meta:{
                        isAuth: true,
                        title: '石家庄'
                    },
                },
                {
                    name:'han',
                    path: 'hd/:a1/:a2/:a3',
                    component: City,
                    props: true,
                    meta:{
                        isAuth: true,
                        title: '邯郸'
                    }
                }
            ]
        },
        {
            name:'nan',
            path : '/henan',
            component: HeNan,
            meta:{title: '河南省'}
        }
    ]
})

export default router