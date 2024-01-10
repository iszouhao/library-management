<template>
  <div style="width: 80%">
    <div style=" text-align: center;margin-top: 40px;margin-bottom: 30px">编辑用户</div>
    <el-form :inline="true" :model="form" style="text-align: center" label-width="100px">
      <el-form-item label="姓名">
        <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
      </el-form-item><br>
      <el-form-item label="年龄">
        <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
      </el-form-item><br>
      <el-form-item label="性别">
        <el-input v-model="form.sex" placeholder="请输入性别"></el-input>
      </el-form-item><br>
      <el-form-item label="电话">
        <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
      </el-form-item><br>
      <el-form-item label="地址">
        <el-input v-model="form.address" placeholder="请输入地址"></el-input>
      </el-form-item>
    </el-form>

    <div style="text-align: center;margin-left: 70px;margin-top: 10px">
      <el-button type="warning" @click="update()" size="medium">修改</el-button>

    </div>
  </div>
</template>
<script>
import request from "@/utils/request";

export default {
  name: 'EditUser',
  data() {
    return {
      form:{}
    }
  },
  created() {
    // 获取路由中的 id 参数
    const id = this.$route.query.id;
    // 使用 Axios 发送 HTTP GET 请求获取用户信息
    request.get("/user/" + id)
        .then(res => {
          // 将获取到的用户信息赋值给组件的 form 数据
          this.form = res.data;
        })
        .catch(error => {
          // 处理请求失败的情况
          console.error('Error fetching user data:', error);
        });
  },
  methods: {
    // 更新用户信息的方法
    update() {
      // 使用 Axios 发送 HTTP PUT 请求
      request.put('/user/update', this.form)
          .then(res => {
            // 处理请求成功的响应
            if (res.code === '200') {
              // 如果返回的状态码为 '200'，表示更新成功
              // 使用 Vue 的 $notify.success 方法显示成功通知
              this.$notify.success('更新成功');
              // 导航到用户列表页面
              this.$router.push('/user');
            } else {
              // 如果返回的状态码不为 '200'，表示更新失败
              // 使用 Vue 的 $notify.error 方法显示错误通知
              this.$notify.error(res.msg);
            }
          })
          .catch(error => {
            // 处理请求失败的情况
            console.error('Error updating user:', error);
          });
    }
  }
}
</script>