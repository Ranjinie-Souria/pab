<script lang="ts" setup>
import { onMounted, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import pabButton from '../atoms/pabButton.vue'

const connected = ref()
const route = useRoute()
const router = useRouter()

onMounted(() => {
  console.log('Header mounted')

  console.log("Route : ", route)
  console.log("Router : ", router)

  const isChildRoute = ref(false);

  console.log('Current route name : ', route.name)
  console.log('Current route matched : ', route.matched)

  if (route.matched.length > 1) {
    isChildRoute.value = true;
    console.log('Current route is a child route');
  } else {
    isChildRoute.value = false;
    console.log('Current route is not a child route');
  }

  if (localStorage.getItem('connected') === 'true') {
    connected.value = true
    if (route.name === 'Login') {
      console.log('User is connected, redirecting to home page')
      router.push('/')
    }
  }
})

// Logout function
function logout() {
  localStorage.setItem('connected', 'false')
  connected.value = false
}
</script>

<template>
  <div class="navbar-container">
    <span class="unselectable">PAB Scholarship</span>
    <div class="navbar-menu">
      <ul>
        <li class="navbar-element">
          <span class="unselectable">/</span>
        </li>
        <li class="navbar-element">
          <router-link class="navbar-link" :to="'/'">Home</router-link>
        </li>
        <template v-if="route.name !== 'Home'">
          <li class="navbar-element">
            <span class="unselectable">/</span>
          </li>
          <li class="navbar-element">
            <span class="navbar-link router-link-active">{{ route.name }}</span>
          </li>
        </template>
      </ul>
    </div>
    <div class="navbar-menu flex-end">
      <router-link
        class="navbar-link"
        :to="'/login'"
        v-if="connected !== true && connected !== undefined && connected !== null"
      >
        <pab-button label="Login" />
      </router-link>
      <pab-button label="Logout" v-else-if="connected === true" @click="logout" />
    </div>
  </div>
</template>

<style lang="scss" scoped>
.navbar-container {
  display: flex;
  align-items: center;
  padding: 10px 20px;
  gap: 20px;
  background-color: var(--white);
  box-shadow: var(--elevation-1);
}

.navbar-menu {
  display: flex;
  justify-content: space-evenly;
  align-items: flex-start;

  ul {
    display: flex;
    align-items: center;
    list-style: none;
    padding: 0;
    gap: 20px;
  }
}

.navbar-element {
  &:hover {
    transform: scale(1.05);
    transition: all 0.1s ease-in-out;
  }
  &:hover .navbar-link {
    color: var(--primary);
    text-shadow: 1px 1px 1px var(--grey-lighter);
  }
  &:has(.router-link-active) .navbar-link {
    text-decoration: underline;
    color: var(--primary);
    text-shadow: 1px 1px 1px var(--grey-lighter);
    cursor: default;
  }
  &:has(.router-link-active):hover,
  &:has(.router-link-active) .navbar-link:hover {
    transform: none;
  }
  &:has(.router-link-active) img {
    filter: invert(36%) sepia(93%) saturate(3810%) hue-rotate(199deg) brightness(101%)
      contrast(105%);
  }
  &:not(:has(.router-link-active)):hover img {
    transform: scale(1.05);
    filter: drop-shadow(2px 2px 1px rgb(0 0 0 / 0.4));
    filter: invert(36%) sepia(93%) saturate(3810%) hue-rotate(199deg) brightness(101%)
      contrast(105%);
  }
  &:hover .navbar-logout img {
    filter: invert(29%) sepia(96%) saturate(3227%) hue-rotate(338deg) brightness(91%) contrast(88%);
  }
}

.navbar-link {
  text-decoration: none;
  color: black;
}
.flex-end {
  margin-left: auto;
}
</style>
