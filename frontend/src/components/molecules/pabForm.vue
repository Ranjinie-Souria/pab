<script lang="ts" setup>
import { defineEmits } from "vue";
import pabTitle from "../atoms/pabTitle.vue";
import pabInput from "../atoms/pabInput.vue";
import pabButton from "../atoms/pabButton.vue";

interface Input {
  label: string;
  placeholder: string;
  type: string;
  name: string;
  value: string;
}

export interface Props {
  title?: string;
  inputs?: Input[];
  submitLabel?: string;
}

const emits = defineEmits(["formsubmit"]);

const props = withDefaults(defineProps<Props>(), {
  title: "",
  inputs: () => [],
  submitLabel: "Submit",
});

function handleSubmit() {
  let formdata = props.inputs.map((input) => input.value);
  emits("formsubmit", formdata);
}
</script>

<template>
  <div class="pab-form-container">
    <pab-title :title="props.title" />
    <form class="pab-form-element">
      <pab-input
        v-for="input in props.inputs"
        :label="input.label"
        :placeholder="input.placeholder"
        :type="input.type"
        :name="input.name"
        v-model="input.value"
      />
      <pab-button :label="props.submitLabel" @click="handleSubmit" />
    </form>
  </div>
</template>

<style lang="scss" scoped>
.pab-form-container {
  display: flex;
  flex-direction: column;
  gap: 20px;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.pab-form-element {
  background: var(--background);
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
