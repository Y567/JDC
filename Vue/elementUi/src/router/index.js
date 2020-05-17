import Vue from 'vue'
// 连那个组件都没倒进来，比打算干啥
import Router from 'vue-router'
import login from '../views/login'
import main from '../views/main'
import notFound from '../views/notFound'


//使用Vue的路由
Vue.use(Router);

//定义导出的路由
export default new Router({
  // 我们可以设置去掉#
  mode: "history",
  //这个routes不能写错
  routes: [
    {
      //需要转的路径,这个就是传递参数的时候的绑定方法:id
      path: "/login/:id",
      name: "loginRouter",
      //要跳到那个组件,component也不能多写一个s
      component: login
    },
    {
      //需要转的路径
      path: "/main",
      //要跳到那个组件,component也不能多写一个s
      component: main
    },
    {
      path: "/goHome",
      redirect: "/main"
    },
    {
      path: "*",
      component: notFound
    }
  ]
});
