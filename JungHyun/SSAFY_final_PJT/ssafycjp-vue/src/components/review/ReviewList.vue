<template>
    <div class="reviewListContainer">
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>등록일</th>
            </tr>
            <tr v-for="review in store.reviewList" :key="review.reviewNo">
                <td>{{ review.reviewNo }}</td>
                <td>
                    <RouterLink :to="`/video/${review.youtubeId}/${review.reviewNo}`">{{ review.title }}</RouterLink>
                </td>
                <td>{{ review.userId }}</td>
                <td>{{ review.viewCnt }}</td>
                <td>{{ review.regDate }}</td>
            </tr>
        </table>
    </div>
    <RouterView/>
</template>

<script setup>
import { useReviewStore } from '@/stores/review';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const store = useReviewStore()
onMounted(() => {
    store.getReviewList(route.params.id)
})
</script>

<style scoped>
    .reviewListContainer {
        background-color: rgb(255, 242, 224);
        padding-top: 5px;
        padding-bottom: 20px;
        padding-inline: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        border-spacing: 0;
    }
    th, td {
        text-align: center;
        padding: 10px 20px;
        border-bottom: 1px solid #ccc;
    }
    td {
        text-align: center
    }
</style>