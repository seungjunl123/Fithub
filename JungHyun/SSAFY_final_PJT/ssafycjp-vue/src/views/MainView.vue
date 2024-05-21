<template>
  <v-app>
    <TheHeaderNav @go-main="goMain" />
    <div class="main-layout">
      <NavigationDrawer :postboardNames="postboardNames" @select-board="selectBoard" />
      <h1 v-if="currentBoardId">{{ currentBoardId }} 번 게시판이야!!</h1>
      <h1 v-if="currentBoardId === null">{{ currentBoardId }} 메인 게시판이야!!</h1>
      <div class="content">
        <RouterView :postboardId="currentBoardId" :key="routerKey" />
        <h1>BoardList 가져왔어!</h1>
      </div>
    </div>

  </v-app>
</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue'
import NavigationDrawer from '@/components/common/NavigationDrawer.vue'
import BoardList from '@/components/board/BoardList.vue'
import { ref, onMounted, watch } from 'vue'
import { useBoardStore } from '@/stores/board'
import { useRoute, useRouter } from 'vue-router'

const store = useBoardStore()
const postboardNames = ref([])
const currentBoardId = ref(null)
const routerKey = ref('main')
const route = useRoute()
const router = useRouter()

const selectBoard = (boardId) => {
  currentBoardId.value = boardId
  routerKey.value = `board-${boardId}`
  router.push({ name: 'boardList', params: { postboardId: boardId } })
}

const goMain = () => {
  currentBoardId.value = null
  routerKey.value = 'main'
  router.push({ name: 'main' })
}

onMounted(async () => {
  await store.fetchPostboardNames()
  postboardNames.value = store.postboardNames
  if (route.name === 'main' && !route.params.postboardId) {
    // 처음 로드 시에 모든 게시글 가져오기
    currentBoardId.value = null
    routerKey.value = 'main'
    store.getBoardList() // 모든 게시글 가져오기
    nextTick(() => {
      showInitialMessage.value = true
    })
  }
})

watch(
  () => route.params.postboardId,
  (newPostboardId) => {
    currentBoardId.value = newPostboardId;
    routerKey.value = `board-${newPostboardId}`;
  },
  { immediate: true }
)
</script>

<style scoped>
.main-layout {
  display: flex;
  height: calc(100vh - 70px); /* 헤더 높이를 뺀 높이 */
  margin-top: 70px; /* 헤더 높이 */
}

.content {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
}
</style>
