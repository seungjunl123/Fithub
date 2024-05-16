
<template>
  <div class="homeContainer">
    <h1>최고 조회수 🔥</h1>
    <div v-if="findTopViewVideo">
      <iframe 
        width="1100" height="600" 
        :src="`https://www.youtube.com/embed/`+findTopViewVideo.id+`?si=puMkikXCBJYK4mBH`"
        title="YouTube video player" frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; 
        gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" 
        allowfullscreen>
      </iframe>
    </div>
  </div>
</template>

<script setup>
import { useVideoStore } from '@/stores/video';
import { onMounted, computed } from 'vue';

const store = useVideoStore()
onMounted(() => {
    store.getVideoList()
})

const findTopViewVideo = computed(() => {
  if (store.videoList && store.videoList.length > 0) {
    return store.videoList.reduce((max, video) => max.viewCnt > video.viewCnt ? max : video, store.videoList[0]);
  }
  return null;
});
</script>

<style scoped>
  .homeContainer {
    justify-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
</style>
