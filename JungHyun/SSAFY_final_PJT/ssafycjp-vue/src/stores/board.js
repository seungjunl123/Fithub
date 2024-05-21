import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import axiosInstance from '@/utils/interceptor'
import router from '@/router'

const REST_BOARD_API = `http://localhost:8080/api-board/board`

export const useBoardStore = defineStore('board', () => {
  const postboardNames = ref([]);

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

  // 게시판 목록 가져오기
  const fetchPostboardNames = async () => {
    try {
      const response = await axios.get(`${REST_BOARD_API}/postboardnames`);
      postboardNames.value = response.data;
      console.log("DB에서 게시판 이름 목록 가져왔어!")
      console.log(postboardNames.value)
    } catch (error) {
      console.error('게시판 이름을 가져오는 데 실패했습니다:', error);
    }
  };
  
  // 게시글 가져오기
  const boardList = ref([])
  const getBoardList = function (postboardId = null) {
    let url = REST_BOARD_API
    console.log("getBoardList 들어왔고, 현재  postboardId: "+postboardId)
    if(postboardId === null){
      // 전체 게시글 조회
      url = REST_BOARD_API
      console.log("전체 게시글 가져올거야.")
    }
    if (postboardId) {
      // 특정 게시판 게시글 조회
      url += `/${postboardId}`
      console.log("게시글 가져올거야. postboardId: " + postboardId)
    }
    console.log("url: " + url)
    axiosInstance.get(url)
      .then((response) => {
        console.log("가져온 게시글 리스트: ")
        console.log(response.data)
        boardList.value = response.data
      })
  }


  const board = ref({})

  // 게시글 상세 보기
  const getBoard = function (id) {
    axiosInstance.get(`${REST_BOARD_API}/detail/${id}`)
      .then((response) => {
      board.value = response.data
    })
  }

  // 게시글 수정
  const updateBoard = async function () {
    try {
        console.log('Updating board with data:', board.value); // 디버깅용 로그 추가
        await axiosInstance.put(`${REST_BOARD_API}/${board.value.id}`, board.value);
        router.back();
    } catch (error) {
        console.error('게시글을 수정하는 데 실패했습니다:', error);
    }
}

  const searchBoardList = function (searchCondition) {
    axiosInstance.get(REST_BOARD_API, {
      params: searchCondition
    })
      .then((res) => {
      boardList.value = res.data
    })
  }

  // 게시글 삭제
  const deleteBoard = function (id) {
    return axiosInstance.delete(`${REST_BOARD_API}/${id}`)
  }

  // 댓글 가져오기
  const getReplies = async (boardId) => {
    const response = await axiosInstance.get(`${REST_BOARD_API}/${boardId}/reply`)
    return response.data
  }

  // 댓글 작성
  const addReply = async (boardId, content) => {
    await axiosInstance.post(`${REST_BOARD_API}/${boardId}/reply`, { content })
  }

  // 댓글 삭제
  const deleteReply = async (replyId) => {
    await axiosInstance.delete(`${REST_BOARD_API}/reply/${replyId}`)
  }

  return { createBoard, boardList, getBoardList, board, getBoard, updateBoard, searchBoardList, postboardNames, fetchPostboardNames, deleteBoard, getReplies, addReply, deleteReply, }
})
