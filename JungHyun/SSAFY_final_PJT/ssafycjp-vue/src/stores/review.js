import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_REVIEW_API = `http://localhost:8080/ssafit/video`

export const useReviewStore = defineStore('review', () => {


  const createReview = function (id, review) {
    axios({
      url: `${REST_REVIEW_API}/${id}`,
      method: 'POST',
      data: review
    })
      .then(() => {
        router.push({name: 'reviewList'})
      })
      .catch((err) => {
      console.log(err)
    })
  }

  const reviewList = ref([])
  const getReviewList = function (id) {
    axios.get(`${REST_REVIEW_API}/${id}`)
      .then((response) => {
      reviewList.value = response.data
    })
  }

  const review = ref({})

  const getReview = function (id, reviewNo) {
    axios.get(`${REST_REVIEW_API}/${id}/${reviewNo}`)
      .then((response) => {
      review.value = response.data
    })
  }

  const updateReview = function (review) {
    // console.log(review)
    // console.log('Sending Data:', JSON.stringify(review));
    axios.put(`${REST_REVIEW_API}/${review.id}/${review.reviewNo}`, review, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then((response) => {
        console.log('Response:', response);
      router.push({name: 'reviewList'})
    })
    .catch(error => {
      console.log(review)
      console.error('Update failed:', error);
      console.error('Error response:', error.response);
    })
  }

  const searchReviewList = function (searchCondition) {
    axios.get(REST_REVIEW_API, {
      params: searchCondition
    })
      .then((res) => {
      reviewList.value = res.data
    })
  }

  return { createReview, reviewList, getReviewList, review, getReview, updateReview, searchReviewList}
})