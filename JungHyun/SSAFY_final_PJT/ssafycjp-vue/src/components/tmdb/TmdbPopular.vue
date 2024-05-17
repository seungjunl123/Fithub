<template>
  <div>
    <div class="row">
      <div class="card my-2 col-12 col-sm-6 col-md-3" v-for="(movie, index) in movieList" :key="movie.id">
        <img :src="`https://image.tmdb.org/t/p/w500/${movie.poster_path}`" class="card-img-top">
        <div class="card-body">
          <h5 class="card-title">{{movie.title}}</h5>
          <p class="card-text text-truncate">{{movie.overview}}</p>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">순위 : {{index+1}}</li>
            <li class="list-group-item">언어 : {{movie.original_language}}</li>
            <li class="list-group-item">개봉일 : {{movie.release_date}}</li>
          </ul>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const movieList = ref([]);

onMounted(() => {
  const api_key = import.meta.env.VITE_TMDB_API_KEY;
  const url = `https://api.themoviedb.org/3/movie/popular`;
  const params = {
    api_key,
    language: 'ko',
    region: 'KR',
  };

  axios({
    url,
    method: 'GET',
    params
  })
  .then((response)=>{
    // console.log(response)
    movieList.value = response.data.results
  })



});
</script>

<style scoped></style>
