<script lang="ts" setup>
import pabTitle from "../../components/atoms/pabTitle.vue";
import pabButton from "../../components/atoms/pabButton.vue";

interface Lesson {
  id: number;
  name: string;
  date: Date;
  room: number;
  duration: string;
  class: string;
  teacher: string;
}

const lessons: Lesson[] = [
  {
    id: 1,
    name: "Lesson 1",
    date: new Date("2024-01-01"),
    room: 1,
    duration: "1h",
    class: "Class 1",
    teacher: "Teacher 1",
  },
  {
    id: 2,
    name: "Lesson 2",
    date: new Date("2024-01-02"),
    room: 2,
    duration: "2h",
    class: "Class 2",
    teacher: "Teacher 2",
  },
  {
    id: 3,
    name: "Lesson 3",
    date: new Date("2024-01-03"),
    room: 3,
    duration: "3h",
    class: "Class 3",
    teacher: "Teacher 3",
  },
  {
    id: 4,
    name: "Lesson 4",
    date: new Date("2024-01-04"),
    room: 4,
    duration: "4h",
    class: "Class 4",
    teacher: "Teacher 4",
  },
  {
    id: 5,
    name: "Lesson 5",
    date: new Date("2024-01-05"),
    room: 5,
    duration: "5h",
    class: "Class 5",
    teacher: "Teacher 5",
  },
];
</script>

<template>
  <pab-title title="Lessons" />
  <router-link to="/lesson/add">
    <pab-button label="Add new lesson" />
  </router-link>
  <table class="pab-table">
    <thead class="pab-table-head">
      <tr class="pab-table-row">
        <th class="pab-table-header">Lesson</th>
        <th class="pab-table-header">Date</th>
        <th class="pab-table-header">Duration</th>
        <th class="pab-table-header">Class</th>
        <th class="pab-table-header">Teacher</th>
        <th class="pab-table-header">Actions</th>
      </tr>
    </thead>
    <tbody class="pab-table-body">
      <tr class="pab-table-row" v-for="lesson in lessons">
        <td class="pab-table-cell">{{ lesson.name }}</td>
        <td class="pab-table-cell">{{ lesson.date }}</td>
        <td class="pab-table-cell">{{ lesson.duration }}</td>
        <td class="pab-table-cell">{{ lesson.class }}</td>
        <td class="pab-table-cell">{{ lesson.teacher }}</td>
        <td class="pab-table-cell">
          <div class="pab-table-actions">
            <router-link :to="`/lesson/${lesson.id}`">
              <pab-button label="View" />
            </router-link>
            <router-link :to="`/lesson/edit/${lesson.id}`">
              <pab-button label="Edit" />
            </router-link>
            <router-link :to="`/lesson/delete/${lesson.id}`">
              <pab-button label="Delete" />
            </router-link>
          </div>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<style lang="scss" scoped>
.pab-table {
  width: 100%;
  border-collapse: collapse;

  &-head {
    background-color: #f9f9f9;
  }

  &-row {
    border-bottom: 1px solid #ddd;
  }

  &-header {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
  }

  &-cell {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
  }

  &-actions {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 8px;
  }
}
</style>
