<template>
  <div id="app">
    <!-- 头部区域 -->
    <div style="height: 60px; line-height: 60px; background-color: white ;margin-bottom: 2px" >
      <img src="@/assets/logo.png" alt="" style="width: 40px;position: relative;top: 10px; left: 20px ">
      <span style="margin-left: 25px;font-size: 24px ">图书管理系统</span>
    </div>
    <!-- 侧边栏和主体区域 -->
    <div style="display: flex">
      <!-- 侧边栏导航 -->
      <div style="width:200px;min-height:calc(100vh - 62px);overflow: hidden;margin-right: 2px; background-color: white">
        <!-- 定义一个宽度为200px，最小高度为视口高度减去62px的div，溢出隐藏，右侧边距为2px，背景颜色为白色 -->
        <el-menu :default-active="$route.path" :default-openeds="['/']" router class="el-menu-demo">
          <!-- 使用el-menu组件，设置默认激活的路径为$route.path，设置默认展开的路径为‘/’，设置为路由菜单，添加类名"el-menu-demo" -->
          <el-menu-item index="/">
            <!-- 使用el-menu-item组件，设置索引为‘/’ -->
            <i class="el-icon-eleme"></i>
            <!-- 添加一个el-icon-eleme图标 -->
            <span>首页</span>
            <!-- 添加一个span标签，内容为"首页" -->
          </el-menu-item>
          <el-submenu index="/">
            <!-- 使用el-submenu组件，设置索引为‘/’ -->
            <template slot="title">
              <!-- 使用template标签，并设置slot为'title' -->
              <i class="el-icon-info"></i>
              <!-- 添加一个el-icon-info图标 -->
              <span>关于页面</span>
              <!-- 添加一个span标签，内容为"关于页面" -->
            </template>
            <el-menu-item index="about">关于详情</el-menu-item>
            <!-- 使用el-menu-item组件，设置索引为"about"，内容为"关于详情" -->
          </el-submenu>
        </el-menu>
      </div>


      <!-- 主体数据 -->
      <div style="flex: 1; background-color: white; padding: 10px">
        <router-view/>
      </div>
    </div>

  </div>
</template>
<script>
</script>