import mitt from 'mitt'

// 以下代码一执行，就会创建一个emitter对象，可以当做是一个全局事件总线对象。
export default mitt()