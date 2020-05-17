<template>
  <div id="app">
      <h1>首页(main.vue)</h1>
  </div>
</template>

<script>

export default {
  name: 'main',
  beforeRouteEnter:(to,from,next)=>{
      console.log("进入组件之前");
      //记得要继续往下走,不然就卡住了,没有参数表示通行,有路径则走固定路由,false则不放行,返回上一个页面
      next(vm=>{
         vm.getData();
      });
  },
  beforeRouteLeave:(to,from,next)=>{
      console.log("离开组件之前");
      //往下走
      next();
  },
  methods: {
      getData: function(){
          this.axios({
            method: 'get',
            url: "http://localhost:8080/static/mock/ag.json"
          }).then(function(response){
            console.log(response);
          });
      }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
