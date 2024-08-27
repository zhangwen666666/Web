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
            children: [
                {
                    name: 'shi',
                    path: 'sjz/:a1/:a2/:a3',
                    component: City,
                    props: true,
                    // 带有这个属性的，并且值是true，表示该路由是需要鉴权的。
                    meta:{
                        isAuth: true
                    }
                },
                {
                    name:'han',
                    path: 'hd/:a1/:a2/:a3',
                    component: City,
                    props: true,
                    meta:{
                        isAuth: true
                    }
                }
            ]
        },
        {
            name:'nan',
            path : '/henan',
            component: HeNan
        }
    ]
})

// 全局前置路由守卫
// 1. 代码写在哪里? 在创建好之后，以及暴露router之前
// 2. beforeEach中的callback什么时候被调用呢？ 在初始化的时候执行一次，
//      以后每一次切换任意路由组件之前都会被调用
//      router.beforeEach(callback)
// 3. callback可以是普通函数，也可以是箭头函数
// 4. callback函数有三个参数，to from next  （初始化时from和to相同）
// 5. from参数: from是一个路由对象route(注意不是路由器对象)，表示从哪来(从哪个路由切过来的)，起点
// 6. to参数：to也是一个路由对象，表示到哪去，终点
// 7. next参数：这是一个函数，调用这个函数之后，表示放行，可以继续向下走。
// 8. 给路由对象添加自定义属性的话，需要在路由对象的meta(路由元)中定义 
router.beforeEach((to, from, next) => {
    // console.log('beforeEach...');
    // console.log('to', to);
    // console.log('from', from);
    // console.log('next', next);

    // 假设当前登录的用户是：
    let loginName='zhangsan'

    // 如果目的地是'shi'和'han'，则需要判断登录用户是否是admin
    // if(to.name === 'shi' || to.name === 'han'){
    //     if(loginName === 'admin'){
    //         // 放行
    //         next()
    //     } else {
    //         alert('对不起，您没有权限')
    //     }  
    // } else {
    //     next()
    // }

    // 目前来说只有shi和han两个路由需要鉴权
    // 如果项目中需要鉴权的路由比较多，这里的代码会比较繁琐，比较冗余。
    // 怎么解决？
    // 给路由对象加一个自定义的属性，凡是需要鉴权的将该属性值设为ture，不需要鉴权的可以不设置该属性
    // 不设置该属性，属性值就是undefined，将来会被当做false来处理，或者将该属性值设置为false
    if(to.meta.isAuth){
        if(loginName === 'admin'){
            // 放行
            next()
        } else {
            alert('对不起，您没有权限')
        } 
    } else {
        next()
    }
})

export default router