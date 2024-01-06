<template>
  <div>
    <!-- 搜索表单 -->
    <div style="margin-bottom: 20px">
      <el-input style="width: 240px" placeholder="请输入名称"></el-input>
      <el-input style="width: 240px ; margin-left: 5px" placeholder="请输入联系方式"></el-input>
      <el-button style="margin-left: 5px" type="primary"><i class="el-icon-search"></i>搜索</el-button>
    </div>

    <el-table :data="tableData" stripe>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="phone" label="手机号"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
    </el-table>

    <div style="margin-top: 20px">
      <el-pagination
          background
          :page-size="10"
          layout="prev, pager, next"
          :total="tableData.length">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    // 返回一个对象，用于存储组件的数据
    return {
      tableData: [] // 存储表格数据的数组
    }
  },
  created() {
    // 组件被创建时执行的钩子函数
    this.load() // 调用load方法加载数据
  },
  methods: {
    // 定义方法
    load() {
      // 发起HTTP请求获取用户列表数据
      fetch('http://localhost:9090/user/list')
        .then(res => res.json())
        .then(res => {
          // 打印控制台日志
          console.log(res)
          // 将获取到的数据赋值给tableData属性
          this.tableData = res
        })
    }
  }
}

</script>
