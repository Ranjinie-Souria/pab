<script lang="ts" setup>
import { Lesson } from '@/utils/ifaces/Lesson'
import pabTitle from '@/components/atoms/pabTitle.vue'
import pabButton from '@/components/atoms/pabButton.vue'

const lesson: Lesson = {
  id: 1,
  name: 'Lesson 1',
  date: new Date('2024-01-01'),
  room: 1,
  duration: '1h',
  class: 'Class 1',
  teacher: 'Teacher 1'
}

// TODO Get lesson from backend
// TODO Display lesson
// TODO Display lesson content
</script>

<template>
  <pab-title :title="`Lesson ${lesson.name}`" />
  <router-link :to="`/lesson/attendance/${lesson.id}`">
    <pab-button label="Do the attendance" />
  </router-link>
  <router-link :to="`/lesson/edit/${lesson.id}`">
    <pab-button label="Edit" />
  </router-link>
  <router-link :to="`/lesson/delete/${lesson.id}`">
    <pab-button label="Delete" />
  </router-link>
  <p>Here is the content of the lesson.</p>
  <pab-title title="Content" type="subtitle" />
</template>

<style lang="scss" scoped></style>
