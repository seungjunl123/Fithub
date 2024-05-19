<template>
    <div id="container">
        <header>
            <nav class="navb">
                <RouterLink to="/main">Main</RouterLink> |
                <RouterLink to="/youtube">Youtube</RouterLink> |
                <RouterLink :to="{ name: 'boardList' }">BoardList</RouterLink> |
                <RouterLink :to="{ name: 'boardCreate' }">BoardCreate</RouterLink> |
                <RouterLink :to="{ name: 'kakao' }">Kakao</RouterLink> |
                <RouterLink :to="{ name: 'tmdb' }">Tmdb</RouterLink> 
            </nav>
        </header>

        <nav class="info">
            <RouterLink :to="{name:'mypage'}">마이페이지</RouterLink> |
            <button @click="logout" style="font-weight: bold;">로그아웃</button>
        </nav>
    </div>
    
</template>

<script setup>
    import { ref } from "vue";
    import { useUserStore } from "@/stores/user";
    import router from '@/router'

    const Ustore = useUserStore();

    const logout = function(){
        Ustore.logout();
        router.push({name:'home'})
    }
</script>

<style scoped>
#container {
  display: flex;
  justify-content: space-around;
  align-items: center;

}


nav a {
    font-weight: bold;
    text-decoration: none;
    color: black;
}

nav a.router-link-exact-active {
    color: #42b983
}
</style>