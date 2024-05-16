import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_SSAFIT_API = `http://localhost:8080/ssafit/video`

export const useVideoStore = defineStore('video', () => {
  
  const videoList = ref([])
  const video = ref({})

  const getVideoList = function () {
    axios.get(REST_SSAFIT_API)
      .then((response) => {
      videoList.value = response.data
    })
  }

  const getVideo = function (id) {
    console.log(`${REST_SSAFIT_API}/${id}/info`)
    axios.get(`${REST_SSAFIT_API}/${id}/info`)
      .then((response) => {
        console.log('리스폰스데이타: ',response.data)
      video.value = response.data
    })
  }

  const searchVideoList = function (searchCondition) {
    axios.get(REST_SSAFIT_API, {
      params: searchCondition
    })
      .then((res) => {
      videoList.value = res.data
    })
  }

  return { videoList, getVideoList, getVideo, video, searchVideoList}
})
