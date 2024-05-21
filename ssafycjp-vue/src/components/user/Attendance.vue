<template>
  <div>
    <calendar-heatmap
      :values="values"
      :endDate="endDate"
      :range="365"
      :tooltip-unit="tooltipUnit"
      :showMonthLabel="true"
      :showWeekdayLabel="true"
      :colorArray="colorArray"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import CalendarHeatmap from 'vue-calendar-heatmap';
import axios from 'axios';
import { useUserStore } from '@/stores/user';

// Store에서 사용자 정보를 가져옴
const store = useUserStore();
const user = ref(null);

// 캘린더 히트맵 데이터
const values = ref({});
const endDate = ref(new Date());
const tooltipUnit = ref('contributions');
const colorArray = ref(['#ebedf0', '#c6e48b', '#7bc96f', '#239a3b', '#196127']);

// 사용자가 mount될 때 실행되는 함수
onMounted(async () => {
  user.value = await store.getUserInfoFromToken();
  try {
    console.log(user.value.id);
    const response = await axios({
      url:`http://localhost:8080/user/attendance/${user.value.id}`,
      method: 'GET',
      
    }); // 백엔드에서 출석 데이터를 가져옴
    const attendanceData = response.data;
    console.log(attendanceData); // 데이터 확인을 위해 콘솔에 출력

    if (Array.isArray(attendanceData)) {
      const formattedData = attendanceData.reduce((acc, curr) => {
        const date = new Date(curr.date).toISOString().split('T')[0]; // 날짜 형식을 'YYYY-MM-DD'로 변환
        acc[date] = (acc[date] || 0) + 1; // 날짜별로 기여도 집계
        return acc;
      }, {});

      values.value = formattedData;
    } else {
      console.error('Expected an array but got', typeof attendanceData);
    }
  } catch (error) {
    console.error('Error fetching attendance data:', error);
  }
});
</script>

<style>
/* 필요한 추가 스타일을 여기에 추가하세요 */
</style>