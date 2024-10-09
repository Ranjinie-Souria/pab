<script lang="ts" setup>
import PabTitle from '@/components/atoms/pabTitle.vue'
import { Lesson } from '@/utils/ifaces/Lesson'

const lesson: Lesson = {
  id: 1,
  name: 'Lesson 1',
  date: new Date('2024-01-01'),
  room: 1,
  duration: '1h',
  class: 'Class 1',
  teacher: 'Teacher 1'
}

// TODO : Fetch the lesson details from the id of the route
// TODO : Fetch the list of students who needs to attend the lesson
</script>

<template>
  <pab-title :title="`Attendance for the lesson : ${lesson.name}`" />
  <p>Here is the list of students who needs to attend the lesson.</p>
  <pab-title title="Students" type="subtitle" />
</template>

<style lang="scss" scoped></style>
