<template>
  <div>
    <!-- <BugHeader :saveBugCallBack="saveBugCallBack"/>
        <BugList :bugList="bugList" :deleteBugCallBack="deleteBugCallBack" :modifySelectedCallBack="modifySelectedCallBack"
        :updateBugCallBack="updateBugCallBack" v-show="isShow" :selectAllCallBack="selectAllCallBack" :selectedCount="selectedCount"/>
        <BugFooter v-show="isShow" :clearSelectedCallBack="clearSelectedCallBack" :bugList="bugList" :selectedCount="selectedCount"/> -->

    <!-- 自定义事件 -->
    <!-- <BugHeader @saveBugCallBack="saveBugCallBack"/>
        <BugList :bugList="bugList" :deleteBugCallBack="deleteBugCallBack" :modifySelectedCallBack="modifySelectedCallBack"
        :updateBugCallBack="updateBugCallBack" v-show="isShow" @selectAllCallBack="selectAllCallBack" :selectedCount="selectedCount"/>
        <BugFooter v-show="isShow" @clearSelectedCallBack="clearSelectedCallBack" :bugList="bugList" :selectedCount="selectedCount"/> -->

    <!-- 全局事件总线 -->
    <BugHeader @saveBugCallBack="saveBugCallBack" />
    <BugList
      :bugList="bugList"
      v-show="isShow"
      @selectAllCallBack="selectAllCallBack"
      :selectedCount="selectedCount"
    />
    <BugFooter
      v-show="isShow"
      @clearSelectedCallBack="clearSelectedCallBack"
      :bugList="bugList"
      :selectedCount="selectedCount"
    />
  </div>
</template>

<script>
/* import axios from "axios"; */
import BugHeader from "./components/BugHeader.vue";
import BugList from "./components/BugList.vue";
import BugFooter from "./components/BugFooter.vue";
export default {
  name: "App",
  components: { BugHeader, BugList, BugFooter },
  data() {
    return {
      bugList: [],
    };
  },
  mounted() {

    // 发送AJAX请求
    /* axios.get("/api/vue/bugs").then(
      (resopnse) => {
        console.log("服务器响应回来的数据:", resopnse.data);
        this.bugList = resopnse.data
      },
      (error) => {
        console.log("错误信息:", error.message);
      }
    ); */

    /* 使用vue-resource插件发送ajax请求 */
    this.$http.get("/api/vue/bugs").then(
      (resopnse) => {
        console.log("服务器响应回来的数据:", resopnse.data);
        this.bugList = resopnse.data
      },
      (error) => {
        console.log("错误信息:", error.message);
      }
    );

    this.$bus.$on("deleteBugCallBack", this.deleteBugCallBack);
    this.$bus.$on("modifySelectedCallBack", this.modifySelectedCallBack);
    this.$bus.$on("updateBugCallBack", this.updateBugCallBack);
  },
  beforeDestroy() {
    this.$off();
  },
  computed: {
    isShow() {
      return this.bugList.length !== 0;
      // return true
    },
    selectedCount() {
      let count = 0;
      this.bugList.forEach((bug) => {
        if (bug.selected === true) count++;
      });
      return count;
    },
  },
  methods: {
    saveBugCallBack(bug) {
      this.bugList.unshift(bug);
    },
    deleteBugCallBack(bugId) {
      this.bugList = this.bugList.filter((bug) => {
        return bug.id !== bugId;
      });
      // console.log('deleteBugCallBack');
    },
    modifySelectedCallBack(bugId) {
      this.bugList.forEach((bug) => {
        if (bugId === bug.id) {
          bug.selected = !bug.selected;
        }
      });
      // console.log('modifySelectedCallBack');
    },
    updateBugCallBack(bugId, newDesc) {
      this.bugList.forEach((bug) => {
        if (bug.id === bugId) {
          bug.desc = newDesc;
          return;
        }
      });
      // console.log('updateBugCallBack');
    },
    selectAllCallBack(selected) {
      this.bugList.forEach((bug) => {
        console.log(bug);
        bug.selected = selected;
        console.log(bug);
      });
    },
    clearSelectedCallBack() {
      this.bugList = this.bugList.filter((bug) => {
        return bug.selected !== true;
      });
    },
  },
};
</script>


<style>
.button {
  display: inline-block;
  zoom: 1;
  padding: 6px 20px;
  margin: 0;
  cursor: pointer;
  border: 1px solid #bbb;
  overflow: visible;
  font: bold 13px arial, helvetica, sans-serif;
  text-decoration: none;
  white-space: nowrap;
  color: #555;
  background-color: #ddd;
  background-image: -webkit-gradient(
    linear,
    to right top,
    to right bottom,
    from(rgba(255, 255, 255, 1)),
    to(rgba(255, 255, 255, 0))
  );
  background-image: -webkit-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 1),
    rgba(255, 255, 255, 0)
  );
  background-image: -moz-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 1),
    rgba(255, 255, 255, 0)
  );
  background-image: -ms-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 1),
    rgba(255, 255, 255, 0)
  );
  background-image: -o-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 1),
    rgba(255, 255, 255, 0)
  );
  background-image: linear-gradient(
    to bottom,
    rgba(255, 255, 255, 1),
    rgba(255, 255, 255, 0)
  );
  -webkit-transition: background-color 0.2s ease-out;
  -moz-transition: background-color 0.2s ease-out;
  -ms-transition: background-color 0.2s ease-out;
  -o-transition: background-color 0.2s ease-out;
  transition: background-color 0.2s ease-out;
  background-clip: padding-box; /* Fix bleeding */
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  border-radius: 3px;
  -moz-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.3), 0 2px 2px -1px rgba(0, 0, 0, 0.5),
    0 1px 0 rgba(255, 255, 255, 0.3) inset;
  -webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.3),
    0 2px 2px -1px rgba(0, 0, 0, 0.5), 0 1px 0 rgba(255, 255, 255, 0.3) inset;
  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.3), 0 2px 2px -1px rgba(0, 0, 0, 0.5),
    0 1px 0 rgba(255, 255, 255, 0.3) inset;
  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.9);
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.button:active {
  background: #e9e9e9;
  position: relative;
  top: 1px;
  text-shadow: none;
  -moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3) inset;
  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3) inset;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3) inset;
}
.button.red {
  color: #fff;
  text-shadow: 0 1px 0 rgba(0, 0, 0, 0.2);
  background-image: -webkit-gradient(
    linear,
    to right top,
    to right bottom,
    from(rgba(255, 255, 255, 0.3)),
    to(rgba(255, 255, 255, 0))
  );
  background-image: -webkit-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0.3),
    rgba(255, 255, 255, 0)
  );
  background-image: -moz-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0.3),
    rgba(255, 255, 255, 0)
  );
  background-image: -ms-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0.3),
    rgba(255, 255, 255, 0)
  );
  background-image: -o-linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0.3),
    rgba(255, 255, 255, 0)
  );
  background-image: linear-gradient(
    to bottom,
    rgba(255, 255, 255, 0.3),
    rgba(255, 255, 255, 0)
  );
}
.button.red {
  background-color: #ca3535;
  border-color: #c43c35;
}
.button.red:hover {
  background-color: #ee5f5b;
}
.button.red:active {
  background: #c43c35;
}
.button.green {
  background-color: #57a957;
  border-color: #57a957;
}
.button.green:hover {
  background-color: #62c462;
}
.button.green:active {
  background: #57a957;
}
</style>