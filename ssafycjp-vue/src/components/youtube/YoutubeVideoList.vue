<template>
  <div class="container">
    <h4 class="text-center" v-if="store.videos === null">
      검색결과가 없습니다. 😂
    </h4>
    <div id="youtube-carousel" class="carousel slide">
      <div class="carousel-inner">
        <YoutubeVideoListItem
          v-for="(video,index) in store.videos"
          :key="video.id.videoId"
          :video="video"
          :index="index"
          :current="current"
        ></YoutubeVideoListItem>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#youtube-carousel"
        data-bs-slide="prev"
        @click="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#youtube-carousel"
        data-bs-slide="next"
        @click="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

  </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
import YoutubeVideoListItem from './YoutubeVideoListItem.vue';
import { ref } from 'vue';

const store = useYoutubeStore();

const current = ref(0)

const prev = function() {
  current.value = (current.value+9)%10
}

const next = function() {
  current.value = (current.value+1)%10
}


</script>

<style scoped></style>
