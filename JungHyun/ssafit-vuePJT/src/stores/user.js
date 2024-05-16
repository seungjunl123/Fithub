import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_USER_API = `http://localhost:8080/ssafit/user`

export const useUserStore = defineStore('user', () => {

  const user = ref({})
  const loginedUser = ref({})

  const createUser = function (user) {
    axios({
      url: `${REST_USER_API}`,
      method: 'POST',
      data: user
    })
      .then(() => {
        router.push({name: 'home'})
      })
      .catch((err) => {
      console.log(err)
    })
  }

  const loginUser = function (user) {
    axios.post(`${REST_USER_API}/login`, user, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then((response) => {
        loginedUser.value = response.data
      router.push({name: 'home'})
    })
    .catch(error => {
      console.error(error);
    })
  }

  return { createUser, loginUser, user, loginedUser }
})