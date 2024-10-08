const routes = [
  { path: "/", name: "Home", component: () => import("../views/Home.vue") },
  {
    path: "/login",
    name: "Login",
    component: () => import("../views/Login.vue"),
  },
  {
    path: "/lesson/:id",
    name: "Lesson",
    component: () => import("../views/Lessons/Lesson.vue"),
  },
  {
    path: "/lesson",
    name: "Lessons",
    component: () => import("../views/Lessons/AllLessons.vue"),
  },
  {
    path: "/lesson/add",
    name: "AddLesson",
    component: () => import("../views/Lessons/AddLesson.vue"),
  },
  {
    path: "/lesson/edit/:id",
    name: "EditLesson",
    component: () => import("../views/Lessons/EditLesson.vue"),
  },
  {
    path: "/lesson/delete/:id",
    name: "DeleteLesson",
    component: () => import("../views/Lessons/DeleteLesson.vue"),
  },
  {
    path: "/:pathMatch(.*)*",
    name: "Not Found",
    component: () => import("../views/NotFound.vue"),
  },
];

export default routes;
