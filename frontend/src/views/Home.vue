<script lang="ts" setup>
import PabTitle from "../components/atoms/pabTitle.vue";
import PabButton from "../components/atoms/pabButton.vue";
</script>

<template>
  <pab-title title="Home Page" />
  <p>
    Welcome to the home page of the PAB app. This is a simple app to manage
    lessons, students and teachers and their attendance.
  </p>
  <br>
  <pab-title title="What do you want to do :" type="subtitle" />
  <div class="pab-button-group">
    <div class="pab-button-group-section">
      <span>Lessons : </span>
      <router-link to="/lesson"
        ><pab-button label="See all lessons"
      /></router-link>
      <router-link to="/lesson/create"
        ><pab-button label="Create a lesson"
      /></router-link>
    </div>
    <div class="pab-button-group-section">
      <span>Students : </span>
      <router-link to="/students"
        ><pab-button label="See students"
      /></router-link>
      <router-link to="/students/create"
        ><pab-button label="Create a student"
      /></router-link>
    </div>
    <div class="pab-button-group-section">
      <span>Teachers : </span>
      <router-link to="/teachers"
        ><pab-button label="See teachers"
      /></router-link>
      <router-link to="/teachers/create"
        ><pab-button label="Create a teacher"
      /></router-link>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.pab-button-group {
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding-left: 20px;

  &-section {
    display: flex;
    align-items: center;
    gap: 20px;
  }
}
</style>
