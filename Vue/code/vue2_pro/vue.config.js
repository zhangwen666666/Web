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
  }
})
