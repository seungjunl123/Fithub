<template>
  <div class="carousel-item text-center" :class="active">
    <iframe
      width="800"
      height="500"
      :src="videoURL"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      referrerpolicy="strict-origin-when-cross-origin"
      allowfullscreen
    ></iframe>
    <h5>{{ videoTitle }}</h5>
  </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
import { computed } from 'vue';
import _ from 'lodash';

const store = useYoutubeStore();

const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
  index: Number,
  current: Number,
});

const videoURL = computed(() => {
  const videoId = props.video.id.videoId;
  return `https://www.youtube.com/embed/${videoId}`;
});

const active = computed(() => {
  if (props.current == props.index) return { active: true };
});

const videoTitle = computed(() => {
  return _.unescape(props.video.snippet.title);
});
</script>

<style scoped></style>
