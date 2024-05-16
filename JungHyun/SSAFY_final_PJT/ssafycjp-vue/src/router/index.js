import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import VideoList from '@/components/video/VideoList.vue'
import VideoSearch from '@/components/video/VideoSearch.vue';

import VideoDetail from '@/components/video/VideoDetail.vue'
import ReviewCreate from '@/components/review/ReviewCreate.vue'
import ReviewDetail from '@/components/review/ReviewDetail.vue'
import ReviewList from '@/components/review/ReviewList.vue'
import ReviewUpdate from '@/components/review/ReviewUpdate.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/video',
      name: 'video',
      children: [
        {
          path: '',
          name: 'videoList',
          component: VideoList,
        },
        {
          path: 'search',
          name: 'videoSearch',
          component: VideoSearch,
        },
        {
          path: ':id',
          name: 'videoDetail',
          component: VideoDetail,
          children: [
            {
              path: 'create',
              name: 'reviewCreate',
              component: ReviewCreate,
            },
            {
              path: ':reviewNo',
              name: 'reviewDetail',
              component: ReviewDetail,
            },
            {
              path: 'list',
              name: 'reviewList',
              component: ReviewList,
            },
            {
              path: ':reviewNo/update',
              name: 'reviewUpdate',
              component: ReviewUpdate,
            },
          ]
        },
      ]
    },
  ]
})

export default router