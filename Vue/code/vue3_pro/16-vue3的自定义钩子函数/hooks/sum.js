import { reactive } from 'vue'
export default function(){
    let data = reactive({
        num1: 0,
        num2: 0,
        result: 0,
    })

    function sum(){
        data.result = data.num1 + data.num2
    }

    return {data, sum}
}