<template>
    <div class="reviewCreateContainer">
        <h4>게시글 작성</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="userId">작성자 : </label>
                <input type="text" id="userId" v-model="review.userId">
            </div>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="review.title">
            </div>
            <div>
                <label for="content">내용 : </label>
                <br>
                <textarea id="content" cols="30" rows="10" v-model="review.content"></textarea>
            </div>
            <div class="buttons">
                <button @click="createReview">등록</button>
                <button @click="goBack">취소</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useReviewStore } from '@/stores/review';
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute()
const router = useRouter()
const store = useReviewStore()

const review = ref({
    title: '',
    userId: '',
    content: ''
})

const createReview = function () {
    store.createReview(route.params.id, review.value)
}

const goBack = () => {
    router.back()
}

</script>

<style scoped>
    .reviewCreateContainer {
        background-color: rgb(255, 242, 224);
        margin-top: 20px;
        padding-top: 5px;
        padding-bottom: 20px;
        padding-inline: 20px;
    }
    #userId {
        width: 500px;
    }
    #title {
        width: 500px;
        margin-left: 15px;
    }
    #content {
        width: 500px;
        margin-left: 60px;
    }
    .buttons {
        margin-left: 60px;
    }
</style>