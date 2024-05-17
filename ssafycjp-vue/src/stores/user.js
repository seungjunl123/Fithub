import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/user`

export const useUserStore = defineStore('user', () => {
  const loginUserId = ref(null)
  const userLogin = function (id, password) {
    axios.post(`${REST_USER_API}/login`, {
      id: id,
      password: password
    })
      .then((res) => {
        sessionStorage.setItem('access-token', res.data["access-token"])

        const token = res.data['access-token'].split('.')
        let id = JSON.parse(atob(token[1]))['id']
        
        loginUserId.value = id;

        router.push({name: 'boardList'})

      })
      .catch(() => {
    })
  }

  
  const userRegist = function(user) {
    axios.post(`${REST_USER_API}/signup`,{
      id:id,
      pw:pw,
      name:name,
      age:age,
      gender: gender,
      goalweight:goalweight,
      nowweight:nowweight,
      profileimg:profileimg
    })
    
  }

  return { userLogin , loginUserId, userRegist ,user}
})
