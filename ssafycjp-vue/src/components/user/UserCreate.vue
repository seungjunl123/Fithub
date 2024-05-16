<template>
    <div class="userCreateContainer">
        <h4>회원 가입</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="userId">아이디 : </label>
                <input type="text" id="userId" v-model="user.userId">
            </div>
            <div>
                <label for="password">비밀번호 : </label>
                <input type="password" id="password" v-model="review.title">
            </div>
            <div>
                <label for="name">이름 : </label>
                <input type="text" id="name" v-model="user.name">
            </div>
            <div>
                <label for="age">나이 : </label>
                <input type="text" id="age" v-model="user.age">
            </div>
            <div>
                <label for="email">이메일 : </label>
                <input type="email" id="email" v-model="user.email">
            </div>
            <div class="buttons">
                <button @click="createUser">등록</button>
                <button @click="goBack">취소</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute()
const router = useRouter()
const store = useUserStore()

const user = ref({
    userId: '',
    password: '',
    name: '',
    age: '',
    email: '',
})

const createUser = function () {
    store.createUser(user.value)
}

const goBack = () => {
    router.back()
}

</script>

<style scoped>
    .userCreateContainer {
        background-color: rgb(255, 242, 224);
        margin-top: 20px;
        padding-top: 5px;
        padding-bottom: 20px;
        padding-inline: 20px;
    }
    #userId {
        width: 500px;
    }
    #password {
        width: 500px;
        margin-left: 15px;
    }
    #name {
        width: 500px;
        margin-left: 60px;
    }
    #age {
        width: 500px;
        margin-left: 60px;
    }
    #email {
        width: 500px;
        margin-left: 60px;
    }
</style>