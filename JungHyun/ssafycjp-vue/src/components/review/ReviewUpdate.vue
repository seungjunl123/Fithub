<template>
    <div>
        <h4>리뷰 수정</h4>
        <fieldset>
            <legend>수정</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="store.review.title">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="store.review.content"></textarea>
            </div>
            <div>
                <button @click="updateReview">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/review";
import { useRoute } from 'vue-router';


const store = useReviewStore();
const route = useRoute();

const updateReview = function () {
    store.review.id=route.params.id
    store.review.reviewNo=route.params.reviewNo
    store.updateReview(store.review);
}
</script>

<style scoped></style>