<script lang="ts" setup>
import { Lesson } from '../../utils/ifaces/lesson.interface'
import pabTitle from '../../components/atoms/pabTitle.vue'
import pabButton from '../../components/atoms/pabButton.vue'

const lesson: Lesson = {
  id: 1,
  name: 'Lesson 1',
  date: new Date('2024-01-01'),
  room_number: 1,
  duration: 1,
  formation_id: 1 /* ,
  teacher: 'Teacher 1' */
}

// TODO Get lesson from backend
// TODO Display lesson
// TODO Display lesson content
</script>

<template>
  <pab-title :title="`Lesson : ${lesson.name}`" />
  <div class="pab-button-group">
    <router-link :to="`/lessons/attendance/${lesson.id}`">
      <pab-button label="Do the attendance" />
    </router-link>
    <router-link :to="`/lessons/edit/${lesson.id}`">
      <pab-button label="Edit" />
    </router-link>
    <router-link :to="`/lessons/delete/${lesson.id}`">
      <pab-button label="Delete" />
    </router-link>
  </div>
  <pab-title title="Content" type="subtitle" />
  <span>Date :{{ lesson.date }}</span>
  <span>Room number :{{ lesson.room_number }}</span>
  <span>Duration :{{ lesson.duration }}</span>
  <span>Formation ID :{{ lesson.formation_id }}</span>
  <!-- <span>Teacher :{{ lesson.teacher }}</span> -->
</template>

<style lang="scss" scoped>
.pab-button-group {
  display: flex;
  gap: 20px;
  padding-left: 20px;

  &-section {
    display: flex;
    align-items: center;
    gap: 20px;
  }
}
</style>
