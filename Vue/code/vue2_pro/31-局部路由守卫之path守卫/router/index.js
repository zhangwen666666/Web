// 导入vue-router插件
import VueRouter from "vue-router";

// 导入组件
// 一般路由组件会放在一个pages文件夹下
import HeBei from '../pages/HeBei'
import HeNan from '../pages/HeNan'
import City from '../pages/City'

const router = new VueRouter({
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
                    // 1.这个局部路由守卫之path，代码写到哪里？写到route对象中。
                    // 2.beforeEnter本身就是一个函数，参数上没有回调函数了。
                    // 3.对于beforeEnter来说，参数仍然有三个：to from next
                    // 4.beforeEnter什么时候被调用？进入"shi"这个路由之前被调用
                    beforeEnter(to,from,next){
                        let loginName='zhangsan'
                        if(loginName === 'admin'){
                            document.title = to.meta.title || '欢迎光临'
                            next()
                        } else {
                            alert('对不起，您没有权限')
                        } 
                    }
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