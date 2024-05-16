<template>
    <div class="search">
        <div>
            <label>검색 기준 :</label>
            <select v-model="searchInfo.key">
                <option value='none'>없음</option>
                <option value="part">부위</option>
                <option value="title">제목</option>
                <option value="channelName">채널명</option>
            </select>
        </div>
        <div>
            <label>검색 내용 :</label>
            <input type="text" v-model="searchInfo.word" />
        </div>
        <div>
            <label>정렬 기준 :</label>
            <select v-model="searchInfo.orderBy">
                <option value='none'>없음</option>
                <option value="part">부위</option>
                <option value="title">제목</option>
                <option value="channelName">채널명</option>
            </select>
        </div>
        <div>
            <label>정렬 방향 :</label>
            <select v-model="searchInfo.orderByDir">
                <option value="asc">오름차순</option>
                <option value="desc">내림차순</option>
            </select>
        </div>
        <div>
            <button @click="searchVideoList">검색</button>
        </div>
    </div>
</template>

<script setup>
import { useVideoStore } from '@/stores/video';
import { ref } from 'vue';


const searchInfo = ref({
    key: 'none',
    word: '',
    orderBy: 'none',
    orderByDir: 'asc'
})

const store = useVideoStore()

const searchVideoList = function () {
    store.searchVideoList(searchInfo.value)
}
</script>

<style scoped>
.search {
    display: flex;
}
</style>