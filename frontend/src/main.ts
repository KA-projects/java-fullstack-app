import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
import { RouterOptions, createRouter, createWebHashHistory } from "vue-router";
import Register from "./components/Register.vue";
import Login from "./components/Login.vue";

// import "ant-design-vue/dist/reset.css";
const routes: RouterOptions["routes"] = [
  { path: "/", component: Register },
  { path: "/login", component: Login },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

const app = createApp(App);

app.use(router);

app.mount("#app");
