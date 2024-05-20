<template>
     <TheHeaderNav/>
    <div>
        <div class="text-center">
            <br><br><br>
        </div>
        <RouterView />
    </div>
</template>
  
<script setup>
  import TheHeaderNav from '@/components/common/TheHeaderNav.vue'
</script>
  
<style scoped>
.my-h2 {
    display: inline-block
}
</style>
  