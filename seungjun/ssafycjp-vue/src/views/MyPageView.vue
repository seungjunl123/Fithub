<template>
    <TheHeaderNav/>
    <div v-if="user">
    <v-app>
      <v-container>
        <v-card class="mx-auto mt-5" max-width="800">
          <v-card-title>
            <h3>회원 정보</h3>
            <v-col cols="6">
            </v-col>
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title>ID: {{ user.id }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
        </v-card-title>

        <v-card-text>
            <div class="userInfo">
            <v-row>
              <v-col class="text-center">
                <v-avatar size="300">
                  <!-- 이미지 가져오기 -->
                  <img class="profileImg" :src="file://C:/Dev/source/SSAFY1CJP/seungjun/ssafycjp/src/main/resources/static/upload/`${user.value.id}`.jpg" alt="Profile">
                </v-avatar>
              </v-col>
            </v-row>
            <v-card class="mx-auto mt-5 " max-width="400">
                <v-row>
                <v-col cols="6">
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>이름: {{ user.name }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('name')" color="primary">수정</v-btn>
              </v-col>
            </v-row>
            <v-row>
                <v-col cols="6">
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>e-mail: {{ user.email }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('email')" color="primary">수정</v-btn>
              </v-col>
            </v-row>
            <v-row>
                <v-col cols="6">
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>비밀번호</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('password')" color="primary">수정</v-btn>
              </v-col>
            </v-row>
            <v-row>
                <v-col cols="6">
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>나이: {{ user.age }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('age')" color="primary">수정</v-btn>
              </v-col>
            </v-row>
            <v-row>
                <v-col cols="6">
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title v-if="user.goalWeight">목표 체중: {{ user.goalWeight }}</v-list-item-title>
                            <v-list-item-title v-else>목표 체중: {{ user.goalWeight }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('goalWeight')" color="primary">수정</v-btn>
              </v-col>
            </v-row>
            <v-row>
                <v-col cols="6">
                    <v-list-item>
                      <v-list-item-content>
                            <v-list-item-title v-if="user.nowWeight">현재 체중: {{ user.nowWeight }}</v-list-item-title>
                            <v-list-item-title v-else>현재 체중: {{ user.nowWeight }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('nowWeight')" color="primary">수정</v-btn>
              </v-col>
            </v-row>
            <v-row>
                <v-col cols="6">
                    <v-list-item>
                      <v-list-item-content>
                            <v-list-item-title v-if="user.height">현재 키: {{ user.height }}</v-list-item-title>
                            <v-list-item-title v-else>현재 키: {{ user.height }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-col>
              <v-col cols="6" class="text-right">
                <v-btn @click="editField('height')" color="primary">수정</v-btn>
              </v-col>
            </v-row>

        </v-card>
            </div>

            <v-row class="mt-4">
              <v-col cols="6">
                <v-card outlined>
                  <v-card-title>
                    목표 체중까지 화이팅!
                  </v-card-title>
                  <v-card-text>
                    <v-row>
                      <v-col cols="6">
                        <div>현재 체중: {{ user.nowWeight }}</div>
                      </v-col>
                    </v-row>
                    <v-row class="mt-2">
                      <v-col cols="6">
                        <div>목표 체중: {{ user.goalWeight }} </div>
                      </v-col>
                    </v-row>
                    <v-row class="mt-2">
                      <v-col cols="6">
                        <div>현재 BMI는:<h2>{{bmi}}</h2> 입니다!</div>
                      </v-col>
   
                    </v-row>
          
                  </v-card-text>
                </v-card>
              </v-col>
              <v-col cols="6">
                <v-card outlined>
                  <v-card-title>
                    오늘 하루도 화이팅!!
                  </v-card-title>
                  <v-card-text>
                    <div>연속 접속</div>
                    <v-row justify="center" class="mt-2">
                      <v-col cols="6">
                        <div class="display-2 text-center">{{ user.streak }}</div>
                      </v-col>
                    </v-row>
                    <div class="text-center">일차에요!!</div>
                  </v-card-text>
                </v-card>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
  
        <v-dialog v-model="showModal" persistent max-width="400">
          <v-card>
            <v-card-title>
              <span class="headline">정보 수정</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12">
                    <v-text-field v-model="tempValue" label="새로운 값"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="showModal = false">취소</v-btn>
              <v-btn color="blue darken-1" text @click="saveChanges">저장</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-container>
    </v-app>
  </div>
  </template>
  
  <script setup>
  import TheHeaderNav from '@/components/common/TheHeaderNav.vue'
  import { ref, onMounted,computed } from 'vue';
  import { useUserStore } from '@/stores/user';

  const store = useUserStore();
  const user = ref(null);
  const showModal = ref(false);
  const currentField = ref('');
  const tempValue = ref('');

  const editField = ref((field) =>{
    currentField.value = field;
    tempValue.value = user.value[field];
    showModal.value = true;
  })

  const saveChanges = ref(() =>{
    if (currentField.value) { 
      store.saveInfoChanges(user.value.id,currentField.value,tempValue.value)
      user.value[currentField.value] = tempValue.value;
      currentField.value = '';
      tempValue.value = '';
      showModal.value = false;
    }
  })


  const bmi = computed(() => {
  if (user.value && user.value.nowWeight) {
    console.log(user.value.height/100)
    return (user.value.nowWeight / (user.value.height/100 *user.value.height/100 )).toFixed(2);
  }
  return 'N/A';
});


  onMounted(async () => {  
    user.value = await store.getUserInfoFromToken();
    console.log(user.value)
  

  });
    
  
  </script>
  
  <style>
  .v-avatar img {
    object-fit: cover;
  }

  .userInfo {
    display: flex;
  justify-content: space-around;
  align-items: center;
  }
  </style>