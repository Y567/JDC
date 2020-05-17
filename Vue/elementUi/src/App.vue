<template>
  <div>
      <!--这里我们传递一个参数给登录页面过去,这样就需要参数是一个对象,name表示路由对象params是传递参数-->
      <router-link :to="{name:'loginRouter',params:{id:1}}">去登录</router-link>
      <router-link to="/main">去首页</router-link>
      <!--这里让他直接渲染视图即可-->
      <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

