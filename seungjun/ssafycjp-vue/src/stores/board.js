import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
// import axios from 'axios'
import axiosInstance from '@/utils/interceptor'
import router from '@/router'

const REST_BOARD_API = `http://localhost:8080/api-board/board`

export const useBoardStore = defineStore('board', () => {


  const createBoard = function (board) {
    axiosInstance({
      url: REST_BOARD_API,
      method: 'POST',
      // 아래 작업하지 않아도 그냥 JSON 형태로 Content-type을 결정해서 보내버림
      // headers: {
      //   "Content-Type": "applcation/json"
      // },
      data: board
    })
      .then(() => {
        router.push({name: 'boardList'})
      })
      .catch((err) => {
      console.log(err)
    })
  }

  const boardList = ref([])
  const getBoardList = function () {
    axiosInstance.get(REST_BOARD_API)
      .then((response) => {
      boardList.value = response.data
    })
  }

  const board = ref({})

  const getBoard = function (id) {
    axiosInstance.get(`${REST_BOARD_API}/${id}`)
      .then((response) => {
      board.value = response.data
    })
  }

  const updateBoard = function () {
    axiosInstance.put(REST_BOARD_API, board.value)
      .then(() => {
      router.push({name: 'boardList'})
    })
  }

  const searchBoardList = function (searchCondition) {
    axiosInstance.get(REST_BOARD_API, {
      params: searchCondition
    })
      .then((res) => {
      boardList.value = res.data
    })
  }

  // 인터셉터 사용으로 토큰 검증이 필요한 요청들 쉽게 설정 가능!
  // const createBoard = function (board) {
  //   axios({
  //     url: REST_BOARD_API,
  //     method: 'POST',
  //     // 아래 작업하지 않아도 그냥 JSON 형태로 Content-type을 결정해서 보내버림
  //     // headers: {
  //     //   "Content-Type": "applcation/json"
  //     // },
  //     data: board
  //   })
  //     .then(() => {
  //       router.push({name: 'boardList'})
  //     })
  //     .catch((err) => {
  //     console.log(err)
  //   })
  // }

  // const boardList = ref([])
  // const getBoardList = function () {
  //   axios.get(REST_BOARD_API, {
  //     headers: {
  //       // 토큰 있는지 확인
  //       'access-token': sessionStorage.getItem('access-token')
  //     }
  //   })
  //     .then((response) => {
  //     boardList.value = response.data
  //   })
  // }

  // const board = ref({})

  // const getBoard = function (id) {
  //   axios.get(`${REST_BOARD_API}/${id}`)
  //     .then((response) => {
  //     board.value = response.data
  //   })
  // }

  // const updateBoard = function () {
  //   axios.put(REST_BOARD_API, board.value)
  //     .then(() => {
  //     router.push({name: 'boardList'})
  //   })
  // }

  // const searchBoardList = function (searchCondition) {
  //   axios.get(REST_BOARD_API, {
  //     params: searchCondition
  //   })
  //     .then((res) => {
  //     boardList.value = res.data
  //   })
  // }







  return { createBoard, boardList, getBoardList, board, getBoard, updateBoard, searchBoardList}
})
