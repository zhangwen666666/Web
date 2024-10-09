/*封装一个函数，通过这个函数可以获取到html页面中的节点，这个函数给他起一个名字JQuery*/
/*根据id获取元素：document.getElementById("btn")*/
function jQuery(selector) {
    /*selector可能是#id，也可能是其他的选择器，例如类选择器: .class*/
    if (typeof selector == "string") {
        if (selector.charAt(0) === '#') {
            // selector是一个id选择器
            // return document.getElementById(selector.substring(1)); // 这里返回的是dom对象domObj
            domObj = document.getElementById(selector.substring(1)); // 去掉var定义的是一个全局变量
            return new jQuery()
        }
    }

    if (typeof selector == "function") {
        window.onload = selector
    }

    // 定义一个html(htmlStr)函数，代替：domObj.innerHTML = "htmlStr"
    this.html = function (htmlStr) {
        domObj.innerHTML = htmlStr
    }

    // 定义一个click(func)函数, 代替：domObj.onclick = func
    this.click = function (func) {
        domObj.onclick = func
    }

    this.focus = function (func) {
        domObj.onfocus = func
    }
    this.blur = function (func) {
        domObj.onblur = func
    }
    this.change = function (func) {
        domObj.onchange = func
    }

    /*this.val = function (){
        return domObj.value
    }*/
    /*this.setValue = function (val){
        domObj.value = val
    }*/

    // 不给函数传参时，val是undefined
    this.val = function (val) {
        if (val === undefined) {
            return domObj.value
        } else {
            domObj.value = val
        }
    }

    // 静态方法，发送ajax请求
    /**
     * 分析：使用ajax函数发送ajax请求的时候，需要程序员给我们传过来什么？
     *      请求的方式(type)：GET/POST
     *      请求的URL(url)：url
     *      请求时提交的数据(data)：data
     *      请求时发送异步请求还是同步请求(async)：true表示异步，false表示同步。
     */
    jQuery.ajax = function (jsonArgs) {
        // alert(111)
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(this.readyState === 4){
                if (this.status === 200) {
                    // 假设服务器返回的都是json格式的字符串。
                    var jsonObj = JSON.parse(this.responseText)
                    // document.getElementById("mydiv").innerHTML = jsonObj.uname
                    // 调用函数
                    jsonArgs.success(jsonObj)
                }
            }
        }
        if (jsonArgs.type.toUpperCase() === "POST"){
            xhr.open("POST", jsonArgs.url, jsonArgs.async)
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xhr.send(jsonArgs.data)
        }else if(jsonArgs.type.toUpperCase() === "GET"){
            xhr.open("GET", jsonArgs.url + "?" + jsonArgs.data, jsonArgs.async)
            xhr.send()
        }

    }
}

$ = jQuery
// 为了使静态方法生效
new jQuery()