<script lang="ts" setup>
import pabForm from '../../components/molecules/pabForm.vue'

const inputs = [
  {
    label: 'Lesson name',
    placeholder: 'Enter your the lesson name',
    type: 'input',
    name: 'lesson_name',
    value: ''
  },
  {
    label: 'Date',
    placeholder: 'Enter the date',
    type: 'date',
    name: 'date',
    value: ''
  },
  {
    label: 'Room number',
    placeholder: 'Enter the room number',
    type: 'number',
    name: 'room_number',
    value: ''
  },
  {
    label: 'Duration',
    placeholder: 'Enter the duration',
    type: 'number',
    name: 'duration',
    value: ''
  },
  {
    label: 'Formation ID',
    placeholder: 'Enter the formation ID',
    type: 'number',
    name: 'formation_id',
    value: ''
  }
]
</script>

<template>
  <pab-form title="Create Lesson" :inputs />
</template>

<style lang="scss" scoped>
.pab-login-container {
  display: flex;
  flex-direction: column;
  gap: 20px;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.pab-login-form {
  background: var(--grey-lighter);
  padding: 40px;
  border-radius: 25px;
  margin-left: auto;
  margin-right: auto;
  width: 300px;
  display: flex;
  flex-direction: column;
  gap: 20px;
}
</style>
