<template>
  <div style="width: 80%">
    <div style=" text-align: center;margin-top: 40px;margin-bottom: 30px">新增用户</div>
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
      <el-button type="primary" @click="save()" size="medium">提交</el-button>
    </div>
  </div>
</template>
<script>
import request from "@/utils/request";

export default {
  name: 'AddUser',
  data() {
    return {
      form:{}
    }
  },
  created() {

  },
  methods: {
    save(){
      request.post("/user/save",this.form).then(res =>{
        if(res.code == '200'){
          this.$notify.success('新增成功');
          this.form={}
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>