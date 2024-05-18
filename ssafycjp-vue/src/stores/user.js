import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/user`

export const useUserStore = defineStore('user', () => {
  const loginUserId = ref(null)
  const userLogin = function (id, password) {
    console.log("로그인 들어왔어!")
    axios.post(`${REST_USER_API}/login`, {
      id: id,
      password: password
    })
      .then((res) => {
        console.log(res.data)
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
    console.log('들어와')
    console.log(user)
    axios({
      url: `${REST_USER_API}/user`,
      method:'POST',
      data:user
    })
    .then(()=>{
      router.push({name:'home'})
    })
    .catch((err)=>{
      console.log(err)
    })


  }

  const logout = function(){
    console.log('로그아웃 테스트');
  }

  return { userLogin , loginUserId, userRegist, logout}
})
