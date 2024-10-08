<script lang="ts" setup>
import PabTitle from "../components/atoms/pabTitle.vue";
import PabButton from "../components/atoms/pabButton.vue";
</script>

<template>
  <pab-title title="Home Page" />
  <p>
    Welcome to the home page of the PAB app. This is a simple app to manage
    lessons.
  </p>
  <pab-title title="What do you want to do :" type="subtitle" />
  <div class="pab-button-group">
    <router-link to="/lesson"><pab-button label="See lessons" /></router-link>
    <router-link to="/students"><pab-button label="See students" /></router-link>
  </div>
  
</template>

<style lang="scss" scoped>
.pab-button-group {
  display: flex;
  gap: 20px;
  padding-left: 20px;
}
</style>
