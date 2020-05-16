import Vue from 'vue'
import VueRouter from 'vue-router'
import ag from '../components/ag'
import xq from '../components/xq'

//使用路由
Vue.use(VueRouter);

export default new VueRouter({
  //这个routes不能写错
  routes: [
    {
      //需要转的路径
      path: "/ag",
      name: "agRouter",
      //要跳到那个组件,component也不能多写一个s
      component: ag
    },
    {
      //需要转的路径
      path: "/xq",
      //路由的名字
      name: "xqRouter",
      //要跳到那个组件
      component: xq
    }
  ]
});

