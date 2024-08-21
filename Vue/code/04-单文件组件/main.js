// 导入App组件
import App from './App.vue'

new Vue({
    el: '#root',
    // 使用App组件
    template: `<App></App>`,
    // 注册App组件
    components: {
        App
    }
})

// main是入口文件