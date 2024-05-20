import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import BoardView from '@/views/BoardView.vue'
import SignupView from '@/views/SignupView.vue'
import MyPageView from '@/views/MyPageView.vue'
import MainView from '@/views/MainView.vue'

import BoardCreate from '@/components/board/BoardCreate.vue'
import BoardList from '@/components/board/BoardList.vue'
import BoardUpdate from '@/components/board/BoardUpdate.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'

import Error401 from '@/views/Error401.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignupView
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: MyPageView
    },
    { 
      path: '/401', 
      name: 'Error401', 
      component: Error401 
    },
    {
      path: '/main',
      name: 'main',
      component: MainView
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path: '',
          name: 'boardList',
          component: BoardList
        },
        {
          path: 'create',
          name: 'boardCreate',
          component: BoardCreate
        },
        {
          path: 'update',
          name: 'boardUpdate',
          component: BoardUpdate
        },
        {
          path: ':id',
          name: 'boardDetail',
          component: BoardDetail
        },
      ]
    },
  ]
})

export default router
