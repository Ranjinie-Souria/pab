<script lang="ts" setup>
//import { Lesson } from '../../utils/ifaces/lesson.interface'
import { /* Cell,  */ Row } from '../../utils/ifaces/table.interface'
import pabTitle from '../../components/atoms/pabTitle.vue'
import pabButton from '../../components/atoms/pabButton.vue'
import pabTable from '../../components/molecules/pabTable.vue'

const columns = ['Lesson', 'Date', 'Duration', 'Class Number', 'Teacher ID', 'Actions']
const rows: Row[] = [
  {
    id: 1,
    cells: [
      { value: 'Lesson 1', action: false },
      { value: '2024-01-01', action: false },
      { value: 2, action: false },
      { value: 1, action: false },
      { value: 1, action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 2,
    cells: [
      { value: 'Lesson 2', action: false },
      { value: '2024-01-02', action: false },
      { value: 1, action: false },
      { value: 2, action: false },
      { value: 2, action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 3,
    cells: [
      { value: 'Lesson 3', action: false },
      { value: '2024-01-03', action: false },
      { value: 3, action: false },
      { value: 3, action: false },
      { value: 3, action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 4,
    cells: [
      { value: 'Lesson 4', action: false },
      { value: '2024-01-04', action: false },
      { value: 2, action: false },
      { value: 4, action: false },
      { value: 4, action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 5,
    cells: [
      { value: 'Lesson 5', action: false },
      { value: '2024-01-05', action: false },
      { value: 1, action: false },
      { value: 5, action: false },
      { value: 5, action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 6,
    cells: [
      { value: 'Lesson 6', action: false },
      { value: '2024-01-06', action: false },
      { value: 3, action: false },
      { value: 6, action: false },
      { value: 6, action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 7,
    cells: [
      { value: 'Lesson 7', action: false },
      { value: '2024-01-07', action: false },
      { value: 2, action: false },
      { value: 7, action: false },
      { value: 7, action: false },
      { value: '', action: true }
    ]
  }
]
</script>

<template>
  <pab-title title="Lessons" />
  <router-link to="/lessons/add" style="width: fit-content">
    <pab-button label="Add new lesson" />
  </router-link>
  <pab-table
    :columns
    :rows
    view-cta="/lesson"
    edit-cta="/lesson/edit"
    delete-cta="/lesson/delete"
  />
</template>

<style lang="scss" scoped></style>
