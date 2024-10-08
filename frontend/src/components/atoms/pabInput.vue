<template>
  <div class="flex col flex-align-start b-component-input">
    <div class="grid grid-gap-xs">
      <div class="grid grid-gap-xs">
        <label class="label-m-500 no-highlight b-input-label" v-if="label" :for="name">{{
          label
        }}</label>
        <div
          class="row gap-2 px-3 b-input flex-item-center elevation-1 br-2 py-2"
          :class="{ 'b-input-error': errorState }"
        >
          <span class="b-input-icon my-auto" v-if="icon" :class="'icon-' + props.icon"></span>
          <slot>
            <input
              v-bind="$attrs"
              v-model="model"
              :placeholder="placeholder"
              :id="name"
              class="col body-m-400 ellipsis"
              :class="{ 'error-color': errorState }"
              :maxlength="props.maxlength"
              :type="currentType"
            />
          </slot>
          <span
          class="b-input-eye"
            v-if="props.type === 'password'"
            :class="showMdp ? 'icon-eye' : 'icon-no-eye'"
            @click="toggleMdp"
          ></span>
        </div>
      </div>
      <span
        class="error-color label-s-500 ellipsis"
        :class="{ 'b-input-error-hint': errorState }"
        v-if="errorState"
        >{{ error }}</span
      >
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'

const model = defineModel({ type: String, default: '' })

export interface Props {
  icon?: string
  label?: string
  placeholder?: string
  error?: string
  name?: string
  type?: string
  maxlength?: number
}

const props = withDefaults(defineProps<Props>(), {
  icon: '',
  label: '',
  placeholder: '',
  error: '',
  name: '',
  type: 'text',
  maxlength: 40
})

const currentType = ref(props.type)
const showMdp = ref(false)
const errorState = ref(false)
function setErrorState(bool: boolean) {
  errorState.value = bool
}

defineExpose({ setErrorState })

function toggleMdp() {
  showMdp.value = !showMdp.value
  currentType.value = showMdp.value ? 'text' : 'password'
}
</script>
<style lang="scss" scoped>
.pab-input-label {
  color: var(--input-label-color, #535353);
}

.pab-input-info {
  color: var(--input-placeholder-color, #535353);
}

.pab-input-icon {
  color: var(--gray-medium-color, #535353);
}

.pab-input-eye {
  color: var(--gray-medium-color, #535353);
}

.pab-input {
  min-height: var(--size-rem-2, 32px);
  background-color: var(--input-background-color, #fff);

  &:has(:disabled) {
    outline: 1px solid var(--neutral-dark-color, #cac5cd);
    outline-offset: -1px;
    color: var(--neutral-dark-color, #cac5cd);
    box-shadow: var(--elevation-0);
    cursor: not-allowed;
  }

  &:has(:disabled) .pab-input-icon {
    color: var(--neutral-dark-color, #cac5cd);
  }

  &:has(:disabled) :-webkit-autofill {
    -webkit-text-fill-color: var(--neutral-dark-color, #cac5cd);
  }

  &:focus-within {
    outline: 2px solid var(--theme-main-color, #6750a4);
  }

  &:focus-within .pab-input-icon {
    color: var(--theme-main-color, #6750a4);
  }

  &.error {
    outline: 2px solid var(--error-lightmed-color);
    outline-offset: -2px;
    animation: shake 0.2s ease-in-out 0s;
  }

  &:focus-within.error {
    outline: 2px solid var(--error-medium-color);
  }
}

.pab-input-error {
  outline: solid 0.1rem;
  outline-color: #{var(--error-lightmed-color)};
  animation: shake 0.2s ease-in-out 0s;

  &:focus-within {
    outline-color: #{var(--error-medium-color)};
  }
}

.pab-input-error-hint {
  animation: shake 0.2s ease-in-out 0s;
}

input,
input[type='text'],
input[type='email'],
input[type='search'],
input[type='password'] {
  border: none;
  outline: none;
  padding: 0;
  display: block;
  color: var(--font-bg-color);
  background-color: var(--input-background-color, #fff);
  font-size: max(var(--size-rem-4, 16px));
  caret-color: var(--theme-main-color, #000);

  &:disabled {
    cursor: not-allowed;
    background-color: var(--white-color);
    color: var(--neutral-dark-color);
  }

  &::placeholder {
    color: var(--input-placeholder-color, #7d7d7d);
    font-size: 1rem;
  }

  &:disabled::placeholder {
    color: var(--neutral-dark-color, #cac5cd);
  }
}
</style>
