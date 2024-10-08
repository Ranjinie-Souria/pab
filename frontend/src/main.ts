import { createApp } from "vue";
import "./styles/index.scss";
import App from "./App.vue";

//Initialise vue-router
import { setupRouter } from "./router";

//Create router
const router = setupRouter();

//Make app use router
createApp(App).use(router).mount("#app");
