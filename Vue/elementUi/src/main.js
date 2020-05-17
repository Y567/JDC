// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

//下面两个是使用elementUi需要引入的依赖
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//使用引入的组件
Vue.use(ElementUI);
Vue.use(router);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
