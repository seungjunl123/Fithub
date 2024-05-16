<template>
    <div>
        <h4>리뷰 상세</h4>
        <hr>
        <div class="reviewDetailContainer">
            <div>제목 : {{ store.review.title }}</div>
            <div>작성자 : {{ store.review.userId }}</div>
            <div>작성일 : {{ store.review.regDate }}</div>
            <div>조회수 : {{ store.review.viewCnt }}회</div>
            <br>
            <div>{{ store.review.content }}</div>
            <br>
        </div>


        <button @click="deleteReview">삭제</button>
        <button @click="updateReview">수정</button>
    </div>
</template>

<script setup>
import { useReviewStore } from '@/stores/review';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios'

const store = useReviewStore()

const route = useRoute();
const router = useRouter();
onMounted(() => {
    store.getReview(route.params.id, route.params.reviewNo)
})

const deleteReview = function () {
    axios.delete(`http://localhost:8080/ssafit/video/${route.params.id}/${route.params.reviewNo}`)
        .then(() => {
            router.push({ name: 'videoList' })
        })
}

const updateReview = function () {
    router.push({ name: 'reviewUpdate',
    params: {
            id: route.params.id,
            reviewNo: route.params.reviewNo,
        }
     })
}

</script>

<style scoped>

</style>