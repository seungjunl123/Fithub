<template>
  <div class="container">
    <h4>{{ postboardId }}게시글 목록</h4>
    <hr />
    <BoardSearchInput />
    <table class="table table-hover text-center">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>쓰니</th>
        <th>조회수</th>
        <th>등록일</th>
      </tr>
      <tr v-for="board in currentPageBoardList" :key="board.id">
        <td>{{ board.id }}</td>
        <td>
          <RouterLink :to="`/main/board/${board.id}`">{{ board.title }}</RouterLink>
        </td>
        <td>{{ board.writer }}</td>
        <td>{{ board.viewCnt }}</td>
        <td>{{ board.regDate }}</td>
      </tr>
    </table>
    <nav aria-label="Page navigation">
      <ul class="pagination d-flex justify-content-center">
        <li class="page-item">
          <a
            class="page-link"
            @click.prevent="currentPage--"
            :class="{ disabled: currentPage <= 1 }"
            href="#"
            >&lt;</a
          >
        </li>
        <li
          class="page-item"
          :class="{ active: currentPage === page }"
          v-for="page in pageCount"
          :key="page"
        >
          <a class="page-link" href="#" @click.prevent="clickPage(page)">{{
            page
          }}</a>
        </li>
        <li class="page-item">
          <a
            class="page-link"
            @click.prevent="currentPage++"
            :class="{ disabled: currentPage >= pageCount }"
            href="#"
            >&gt;</a
          >
        </li>
      </ul>
    </nav>
  </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { computed, onMounted, ref, watch } from 'vue';
import BoardSearchInput from './BoardSearchInput.vue';

const props = defineProps({
  postboardId: {
    type : Number,
    default : null,
  }
})

const store = useBoardStore()

const fetchBoards = (boardId) => {
  if (boardId !== null) {
    console.log("postboardId: " + boardId)
    store.getBoardList(boardId)
  } else {
    store.getBoardList() // 모든 게시글 가져오기
  }
}

onMounted(() => {
  console.log("Boardlist 들어왔어!!"+props.postboardId)
  fetchBoards(props.postboardId)
})

watch(
  () => props.postboardId,
  (newValue) => {
    console.log("newValue: " + newValue);
    fetchBoards(newValue);
  },
  { immediate: true }
);

const perPage = 5;
const currentPage = ref(1);

const pageCount = computed(() => {
  return Math.ceil(store.boardList.length / perPage);
});

const clickPage = function (page) {
  currentPage.value = page;
};

const currentPageBoardList = computed(() => {
  return store.boardList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
</script>

<style scoped></style>
