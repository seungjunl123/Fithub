<template>
  <div>
    <TheHeaderNav />
    <NavigationDrawer />
  </div>
  <BoardList />
  <RouterView />
</template>
  
<script setup>
  import TheHeaderNav from '@/components/common/TheHeaderNav.vue';
  import NavigationDrawer from '@/components/common/NavigationDrawer.vue';
  import BoardList from '@/components/board/BoardList.vue';
</script>
  
<style scoped>
  
</style>
  