//定义一个Vue类
class Vue {
    //定义构造函数
    //options是一个简单的纯粹的JS对象：{}
    constructor(options) {
        //获取所有的属性名
        Object.keys(options.data).forEach((propertyName, index) => {
            // console.log(propertyName,index);
            let firstChar = propertyName.charAt(0);
            if (firstChar != '_' && firstChar != '$') {
                Object.defineProperty(this, propertyName, {
                    // 数据代理
                    get() {
                        return options.data[propertyName];
                    },

                    // 数据劫持
                    set(val) {
                        //1. 修改内存中改对象的属性值
                        options.data[propertyName] = val;
                        //2. 重新渲染页面
                        console.log('重新渲染页面')
                    }
                })
            }
        })
        // Object.defineProperty(this,'')

        //获取所有的方法名
        // Object.keys(options.methods).forEach((methodName, index) => {
        //     // console.log(methodName);
        //     // 给当前的Vue实例扩展一个方法
        //     this[methodName] = options.methods[methodName];
        // })
    }
}