const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 保存时是否进行语法检查。true表示检查，默认值是true
  lintOnSave: false,
  pages: {
    index: {
      // 程序的入口main.js
      entry: 'src/main.js'
    }
  },

  /* 代理机制简单开启 */
  /* devServer: {
    proxy: 'http://localhost:8000'
  } */

    /* 代理机制高级开启 */
  /*   devServer: {
      proxy: {
        // 凡是请求路径以 /api开始的，都走这个代理
        '/api': {
          target: 'http://localhost:8000',
          pathRewrite:{'^/api':''},
          ws: true,
          changeOrigin: true
        },

        '/abc': {
          target: 'http://localhost:8001',
          pathRewrite:{'^/abc':''},
          ws: true,
          changeOrigin: true
        },
      }
    } */
})
