<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import axiosAPI from '../../axios.instance'
//import { Lesson } from '../../utils/ifaces/lesson.interface'
import { /* Cell,  */ Row } from '../../utils/ifaces/table.interface'
import pabTitle from '../../components/atoms/pabTitle.vue'
//import pabButton from '../../components/atoms/pabButton.vue'
import pabTable from '../../components/molecules/pabTable.vue'

const columns = ['Firstname', 'Lastname', 'Email', 'Phone', 'Adress', 'User Type', 'Actions']
const examplerows: Row[] = [
  {
    id: 1,
    cells: [
      { value: 'John', action: false },
      { value: 'Doe', action: false },
      { value: 'johndoe@example.com', action: false },
      { value: '1234567890', action: false },
      { value: '1234 Elm St', action: false },
      { value: 'STUDENT', action: false },
      { value: '', action: true }
    ]
  },
  {
    id: 2,
    cells: [
      { value: 'Jane', action: false },
      { value: 'Doe', action: false },
      { value: 'janedoe@example.com', action: false },
      { value: '0987654321', action: false },
      { value: '4321 Elm St', action: false },
      { value: 'TEACHER', action: false },
      { value: '', action: true }
    ]
  }
]

const currenRows = ref(examplerows)

onMounted(() => {
  if (axiosAPI) {
    axiosAPI
      .get('/user')
      .then((response) => {
        console.log(response.data)
        //currenRows.value = response.data
      })
      .catch((error) => {
        console.error(error)
      })
  } else {
    console.error('axiosAPI is not defined')
  }
})
</script>

<template>
  <pab-title title="Users" />
  <!-- <router-link to="/users/add" style="width: fit-content">
    <pab-button label="Add new user" />
  </router-link> -->
  <pab-table
    :columns
    :rows="currenRows"
    view-cta="/user"
    edit-cta="/user/edit"
    delete-cta="/user/delete"
  />
</template>

<style lang="scss" scoped></style>
