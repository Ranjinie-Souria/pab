<script lang="ts" setup>
import { onMounted } from 'vue'
import { Row, Cell } from '@/utils/ifaces/table'
import PabButton from '@/components/atoms/PabButton.vue'

export interface Props {
  columns: string[]
  rows: Row[]
  viewCta?: string
  editCta?: string
  deleteCta?: string
}

const props = withDefaults(defineProps<Props>(), {
  columns: ['Column 1', 'Column 2'],
  rows: [],
  viewCta: '',
  editCta: '',
  deleteCta: ''
})

onMounted(() => {
  console.log(props.rows[0].cells)
})
</script>

<template>
  <table class="pab-table">
    <thead class="pab-table-head">
      <tr class="pab-table-row">
        <th class="pab-table-header" v-for="column in columns" :key="column">{{ column }}</th>
      </tr>
    </thead>
    <tbody class="pab-table-body">
      <tr class="pab-table-row" v-for="row in rows" :key="row[0]">
        <td class="pab-table-cell" v-for="cell in row.cells" :key="cell">
          <template v-if="!cell.action">{{ cell.value }}</template>
          <template v-else>
            <div class="pab-table-actions">
              <router-link v-if="viewCta" :to="`${viewCta}/${row.id}`">
                <pab-button label="View" />
              </router-link>
              <router-link v-if="editCta" :to="`${editCta}/${row.id}`">
                <pab-button label="Edit" />
              </router-link>
              <router-link v-if="deleteCta" :to="`${deleteCta}/${row.id}`">
                <pab-button label="Delete" />
              </router-link>
            </div>
          </template>
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
