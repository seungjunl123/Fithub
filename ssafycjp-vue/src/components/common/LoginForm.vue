<template>
    <div class="login-box">
        <h2 style="color: black">로그인</h2>
        <form @submit.prevent="login">
          <div class="input-group">
            <label for="username"></label>
            <input type="text" id="username" placeholder="아이디 입력" v-model.trim="id" required>
          </div>
          <div class="input-group">
            <label for="password"></label>
            <input type="password" id="password" placeholder="비밀번호 입력" v-model.trim="pw" required>
          </div>
          <button type="submit" class="login-button">로그인</button>
        </form>
      </div>
</template>

<script setup>
import { ref } from 'vue';
import {useUserStore} from '@/stores/user';

const store = useUserStore();

const id = ref("")
const pw = ref("")

const login = function() {
    store.userLogin(id.value, pw.value)
}
</script>

<style  scoped>
.login-box {
  background-color: whitesmoke;
  padding: 20px;
  border-radius: 8px;
  text-align: left;
  width: 300px;
  color: white;
}

h2 {
  margin-bottom: 20px;
}

.input-group {
  margin-bottom: 15px;
}

.input-group input {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 4px;
}

.login-button {
  width: 100%;
  padding: 10px;
  background-color: skyblue;
  border: none;
  border-radius: 4px;
  color: white;
  font-weight: bold;
  cursor: pointer;
}
</style>