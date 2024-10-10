<script lang="ts" setup>
import PabFooter from "../molecules/pabFooter.vue";
import PabHeader from "../molecules/pabHeader.vue";
</script>

<template>
  <div class="pab-page">
    <pab-header />
    <div class="pab-page-container">
      <main class="pab-page-main">
        <div class="pab-page-content">
          <slot></slot>
        </div>
      </main>
      <pab-footer />
    </div>
  </div>
</template>

<style lang="scss" scoped>
.pab-page {
  display: flex;
  flex-direction: column;
  height: 100vh;
  overflow: scroll;

  &-container {
    display: flex;
    flex-direction: column;
    height: 100%;
    width: 100%;
    background-color: var(--background);
    overflow: scroll;
  }

  &-main {
    display: flex;
    flex-direction: column;
    flex: 1;
    padding: 2em;
    gap: 1em;
  }

  &-content {
    display: flex;
    flex-direction: column;
    flex: 1;
    padding: 1em;
    border-radius: 15px;
    gap: 1em;
    background-color: var(--white);
  }
}
</style>
