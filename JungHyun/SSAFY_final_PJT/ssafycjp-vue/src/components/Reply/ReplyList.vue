<template>
    <div class="replies-section">
      <h4>댓글</h4>
      <div v-for="reply in replies" :key="reply.id" class="reply">
        <div class="reply-meta">
          <span class="reply-writer">{{ reply.writer }}</span>
          <span class="reply-date">{{ formatDate(reply.regDate) }}</span>
        </div>
        <div class="reply-content">
          <p>{{ reply.content }}</p>
        </div>
        <div class="reply-actions">
          <button class="btn btn-outline-secondary btn-sm" @click="editReply(reply.id)">수정</button>
          <button class="btn btn-outline-danger btn-sm" @click="deleteReply(reply.id)">삭제</button>
        </div>
      </div>
      <div class="form-floating mb-3">
        <textarea class="form-control" id="newReply" placeholder="댓글을 입력하세요" style="height: 100px" v-model="newReply"></textarea>
        <label for="newReply">댓글</label>
      </div>
      <div class="d-flex justify-content-end">
        <button class="btn btn-outline-primary" @click="addReply">등록</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useBoardStore } from '@/stores/board';
  
  const props = defineProps({
    boardId: {
      type: Number,
      required: true
    }
  });
  
  const store = useBoardStore();
  const replies = ref([]);
  const newReply = ref("");
  
  const fetchReplies = async () => {
    try {
      replies.value = await store.getReplies(props.boardId);
    } catch (error) {
      console.error('댓글을 가져오는 데 실패했습니다:', error);
    }
  };
  
  const addReply = async () => {
    try {
      await store.addReply(props.boardId, newReply.value);
      newReply.value = "";
      fetchReplies();
    } catch (error) {
      console.error('댓글을 추가하는 데 실패했습니다:', error);
    }
  };
  
  const editReply = (replyId) => {
    console.log(`Edit reply ${replyId}`);
    // 댓글 수정 로직 추가
  };
  
  const deleteReply = async (replyId) => {
    try {
      await store.deleteReply(replyId);
      fetchReplies();
    } catch (error) {
      console.error('댓글 삭제에 실패했습니다:', error);
    }
  };
  
  const formatDate = (dateArray) => {
    if (!dateArray || !Array.isArray(dateArray)) return '';
    const [year, month, day, hour, minute, second] = dateArray;
    return `${year}-${String(month).padStart(2, '0')}-${String(day).padStart(2, '0')} ${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}:${String(second).padStart(2, '0')}`;
  };
  
  onMounted(() => {
    fetchReplies();
  });
  </script>
  
  <style scoped>
  .replies-section {
    margin-top: 20px;
    padding: 20px;
    background: #f9f9f9;
    border: 1px solid #ddd;
    border-radius: 8px;
  }
  
  .reply {
    margin-bottom: 15px;
  }
  
  .reply-meta {
    font-size: 0.9rem;
    color: #555;
    display: flex;
    justify-content: space-between;
  }
  
  .reply-content {
    margin: 5px 0;
  }
  
  .reply-actions {
    display: flex;
    gap: 5px;
    justify-content: flex-end;
  }
  
  .btn-outline-primary {
    background-color: #c3fcfc;
    border-color: #c3fcfc;
    color: #000;
  }
  
  .btn-outline-primary:hover {
    background-color: #c3fcfc;
    border-color: #c3fcfc;
    color: #000;
  }
  </style>
  