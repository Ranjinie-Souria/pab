<template>
  <div class="flex col flex-align-start b-component-input">
    <div class="grid grid-gap-xs">
      <div class="pab-input-flex">
        <label class="label-m-500 no-highlight pab-input-label" v-if="label" :for="name">{{
          label
        }}</label>
        <div
          class="row gap-2 px-3 pab-input elevation-1 br-2 py-2"
          :class="{ 'pab-input-error': errorState }"
        >
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
        </div>
      </div>
      <span
        class="error-color label-s-500 ellipsis"
        :class="{ 'pab-input-error-hint': errorState }"
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
  label?: string
  placeholder?: string
  error?: string
  name?: string
  type?: string
  maxlength?: number
}

const props = withDefaults(defineProps<Props>(), {
  label: '',
  placeholder: '',
  error: '',
  name: '',
  type: 'text',
  maxlength: 40
})

const currentType = ref(props.type)
const errorState = ref(false)
function setErrorState(bool: boolean) {
  errorState.value = bool
}

defineExpose({ setErrorState })

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
  display: flex;
  align-items: center;
  border-radius: var(--border-radius-2, 8px);
  padding: 0 var(--size-rem-1, 16px);
  min-height: var(--size-rem-2, 32px);
  background-color: var(--input-background-color, #fff);

  &-flex {
    display: flex;
    flex-direction: column;
    gap: var(--size-rem-2, 8px);
  }

  input {
    width: 100%;
  }

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
