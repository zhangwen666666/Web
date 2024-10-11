<template>
    <div class="search">
        <input type="text" placeholder="请输入城市名字" spellcheck="false" v-model="cityName">
        <button @click="search"><img src="../assets/images/search.png"></button>
    </div>
</template>

<script>
import axios, { Axios } from 'axios'
export default {
  name: "Search",
  data(){
    return {
        cityName:''
    }
  },
  methods:{
    search(){
		if(this.cityName.trim() == ''){
			return
		}
        //console.log(666);
        // 发送AJAX请求，根据城市的名字获取经纬度
        let apiKey = "430ebe23a87ce9bb67541f13298baba1"
        let apiUrlGetLatAndLon = `http://api.openweathermap.org/geo/1.0/direct?q=${this.cityName}&appid=${apiKey}`
        axios.get(apiUrlGetLatAndLon).then(
            (response) => {
                // console.log('响应数据：', response.data);
				if(response.data.length === 0) {
					// console.log('城市不存在');
					this.$bus.$emit('displayNotFound')
				}else{
					let lat = response.data[0].lat
					let lon = response.data[0].lon
					// console.log('纬度', lat);
					// console.log('经度', lon);
					// 在发送一次AJAX请求，调用接口，获取天气信息
					let apiUrlGetWeather = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`
					axios.get(apiUrlGetWeather).then(
						(response) => {
							// console.log('响应数据：', response.data);
							// 从响应的数据中获取温度，湿度，风速，天气图标
							// 将获取到的数据封装成一个weather组件
							response.data
							const weather = {
								// 天气图片路径
								imgPath: `https://openweathermap.org/img/wn/${response.data.weather[0].icon}@2x.png`,
								// 温度
								temp: response.data.main.temp,
								// 湿度
								humidity: response.data.main.humidity,
								// 风速
								windSpeed: response.data.wind.speed,
								// 城市名
								city: this.cityName
							}
							// console.log(weather);
							// 触发事件(使用全局事件总线)，传递数据
							this.$bus.$emit('displayWeather', weather)
						},
						(error) => {
							console.log('错误信息：', error.message);
						}
					)
				}
            },
            (error) => {
                console.log('错误信息：', error.message);
            }
        )
    }
  }
}
</script>

<style lang="css" scoped>
.search {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.search input {
    border: 0;
    outline: 0;
    background: #ebfffc;
    color: #555;
    padding: 10px 25px;
    height: 60px;
    border-radius: 30px;
    flex: 1;
    margin-right: 16px;
    font-size: 18px;
}

.search button{
    border: 0;
    outline: 0;
    background: #ebfffc;
    border-radius: 50%;
    width: 60px;
    height: 60px;
    cursor: pointer;
}

.search button img {
    width: 16px;
}
</style>