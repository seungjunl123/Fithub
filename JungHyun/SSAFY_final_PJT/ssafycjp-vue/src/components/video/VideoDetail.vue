<template>
    <div class="videoDetailContainer">
        <div>
            <iframe 
            width="700" height="315" 
            :src="`https://www.youtube.com/embed/`+store.video.id+`?si=puMkikXCBJYK4mBH`"
            title="YouTube video player" frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; 
            gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" 
            allowfullscreen>
            </iframe>
        </div>
        <br>
        <div>
            <div class="videoInfoContainer">
                <h3>{{ store.video.title }}</h3>
                <h5>부위: {{ store.video.part }}</h5>
                <h5>채널명: {{ store.video.channelName }}</h5>
                <h5>조회수: {{ store.video.viewCnt }}</h5>
            </div>
            <br>
            <ReviewList/>
            <div>
                <RouterLink :to="{ name: 'reviewCreate' }">리뷰 작성</RouterLink>
            </div>
        </div>
    </div>
    
</template>

<script setup>
import { useVideoStore } from '@/stores/video';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios'
import ReviewList from '../review/ReviewList.vue';

const store = useVideoStore()
onMounted(() => {
    store.getVideo(route.params.id)
})

const route = useRoute();
const router = useRouter();

</script>

<style scoped>
    .videoDetailContainer {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .videoInfoContainer{
        width: 660px;
        height: 180px;
        justify-content: start;
        background-color: rgb(255, 242, 224);
        padding-block: 5px;
        padding-inline: 20px;
    }
</style>