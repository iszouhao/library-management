<template>
  <div>
    <!-- 搜索表单 -->
    <div style="margin-bottom: 20px">
      <el-input style="width: 240px" placeholder="请输入名称" v-model="params.name"></el-input>
      <el-input style="width: 240px ; margin-left: 5px" placeholder="请输入联系方式" v-model="params.phone"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>

    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="编号" width="80px"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="phone" label="手机号"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>

      <el-table-column label="操作" >
        <template v-slot="scope">
         <!-- scope.row就是当前行数据-->
          <el-button type="primary" @click="$router.push('/editUser?id='+scope.row.id)">编辑</el-button>
          <el-popconfirm  style="margin-left: 10px"  title="确定删除吗？" @confirm="del(scope.row.id)">
            <el-button  type="danger" slot="reference">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页   -->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          @current-change="handleCurrentChange"
          layout="prev, pager, next"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: 'User',
  data() {
    // 返回一个对象，用于存储组件的数据
    return {
      tableData: [], // 存储表格数据的数组
      total: 0 ,// 存储分页总数
      params:{
        pageNum:1,
        pageSize:10,
        name:'',
        phone:''
      }
    }
  },
  created() {
    // 组件被创建时执行的钩子函数
    this.load() // 调用load方法加载数据
  },
  methods: {
    // 定义方法
    load() {
      /* // 发起HTTP请求获取用户列表数据
       fetch('http://localhost:9090/user/list')
         .then(res => res.json())
         .then(res => {
           // 打印控制台日志
           console.log(res)
           // 将获取到的数据赋值给tableData属性
           this.tableData = res
         })*/
      request.get('/user/page',{
        params:this.params
      }).then(res => {
        if (res.code === '200') {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset() {
      // 重置表单
      this.params = {
        pageNum:1,
        pageSize:10,
        name:'',
        phone:''
      }
      this.load()
    },
    handleCurrentChange(pageNum) {
      //点击分页按钮触发分页
      this.params.pageNum = pageNum
      this.load()
    },
    del(id){
      request.delete("/user/delete/" +id).then(res => {
        if (res.code === '200') {
          this.$notify.success('删除成功')
          this.load()
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>