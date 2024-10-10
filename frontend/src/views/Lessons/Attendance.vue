<script lang="ts" setup>
import PabTitle from '../../components/atoms/pabTitle.vue'
import { Lesson } from '../../utils/ifaces/lesson.interface'
import { User } from '../../utils/ifaces/user.interface'
import PabTable from '../../components/molecules/pabTable.vue'
import PabButton from '../../components/atoms/pabButton.vue'

const lesson: Lesson = {
  id: 1,
  name: 'Lesson 1',
  date: new Date('2024-01-01'),
  room_number: 1,
  duration: 1,
  formation_id: 1 /* ,
  teacher: 'Teacher 1' */
}

const students: User[] = [
  {
    id: 1,
    firstname: 'John',
    lastname: 'Doe',
    email: 'johndoe@example.com',
    phone: '1234567890',
    address: '1234 Elm St',
    user_type: 'STUDENT'
  }
]

const columns = ['Firstname', 'Lastname', 'Email', 'Phone', 'Adress', 'User Type', 'Actions']

const currenRows = students.map((student) => {
  return {
    id: student.id,
    cells: [
      { value: student.firstname, action: false },
      { value: student.lastname, action: false },
      { value: student.email, action: false },
      { value: student.phone, action: false },
      { value: student.address, action: false },
      { value: student.user_type, action: false },
      { value: '', action: true }
    ]
  }
})

// TODO : Fetch the lesson details from the id of the route
// TODO : Fetch the list of students who needs to attend the lesson
</script>

<template>
  <pab-title :title="`Attendance for the lesson : ${lesson.name}`" />
  <p>Here is the list of students who needs to attend the lesson.</p>
  <pab-title title="Students" type="subtitle" />
  <pab-table :columns :rows="currenRows">
    <template #actions="{ row }">
      <router-link :to="`/lessons/${lesson.id}/attendance/${row.id}`"
        ><pab-button label="Mark as present"
      /></router-link>
    </template>
  </pab-table>
</template>

<style lang="scss" scoped></style>
