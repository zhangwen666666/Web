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


// 需求：随着组件的切换将页面的名称进行修改
// 方式一：在路由对象中添加属性title，在beforeEach()中使用原生的js语句修改
//              这种方式需要再每个放行代码之前都写一遍
// 方式二：使用全局后置路由守卫
//              这种方式代码只写一次即可

router.beforeEach((to, from, next) => {
    // 写在这里不严谨，当没有权限访问石家庄时，点击石家庄，页面虽然无法更新，但标题变了
    // 因此这段代码应该写在放行之前
    // document.title = to.meta.title

    // console.log('beforeEach...');
    // console.log('to', to);
    // console.log('from', from);
    // console.log('next', next);

    // 假设当前登录的用户是：
    let loginName='zhangsan'
    if(to.meta.isAuth){
        if(loginName === 'admin'){
            // 放行
            // 初次执行时，to.meta.title是undefined
            // 如果to.meta.title是undefined，就设置为'欢迎光临'
            document.title = to.meta.title || '欢迎光临'
            next()
        } else {
            alert('对不起，您没有权限')
        } 
    } else {
        document.title = to.meta.title || '欢迎光临'
        next()
    }
})


// 全局后置路由守卫
// 1.代码写在哪里？在创建router对象之后，暴露router之前。
// 2.afterEach中的回调函数callback什么时候执行？
//      router.afterEach(callback)
//      初始化的时候执行一次，以后每一次切换完成任意一个路由组件之后被调用 
// 3.这个回调函数有两个参数：to, from.
// 4.这个回调函数没有next参数，因为没有必要了
router.afterEach((to, from) => {
    // 如果to.meta.title是undefined，就设置为'欢迎光临'
    document.title = to.meta.title || '欢迎光临'
})

export default router