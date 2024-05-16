<template>
    <div>
        <h4>영상 목록</h4>
        <VideoSearch/>
        <hr>
        <table>
            <tr>
                <th></th>
                <th>제목</th>
                <th>부위</th>
                <th>채널명</th>
                <th>조회수</th>
            </tr>
            <tr v-for="video in store.videoList" :key="video.id">
                <td><img :src="`https://img.youtube.com/vi/${video.id}/0.jpg`" id="thumbnail" style="width: 100px;"></td>
                <td>
                    <RouterLink :to="`/video/${video.id}`">{{ video.title }}</RouterLink>
                </td>
                <td>{{ video.part }}</td>
                <td>{{ video.channelName }}</td>
                <td>{{ video.viewCnt }}</td>
            </tr>
        </table>
        
    </div>
    <RouterView/>
</template>

<script setup>
import { useVideoStore } from '@/stores/video';
import { onMounted } from 'vue';
import VideoSearch from './VideoSearch.vue';


const store = useVideoStore()
onMounted(() => {
    store.getVideoList()
})
</script>

<style scoped></style>