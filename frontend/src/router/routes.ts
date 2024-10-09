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
    component: () => import("../views/Lessons/OneLesson.vue"),
  },
  {
    path: "/lesson",
    name: "Lessons",
    component: () => import("../views/Lessons/AllLessons.vue"),
    children: [
      {
        path: "add",
        name: "AddLesson",
        component: () => import("../views/Lessons/AddLesson.vue"),
      },
      {
        path: "edit/:id",
        name: "EditLesson",
        component: () => import("../views/Lessons/EditLesson.vue"),
      },
      {
        path: "delete/:id",
        name: "DeleteLesson",
        component: () => import("../views/Lessons/DeleteLesson.vue"),
      },
      {
        path: "attendance/:id",
        name: "Attendance",
        component: () => import("../views/Lessons/Attendance.vue"),
      },
    ],
  },
  {
    path: "/student/:id",
    name: "Student",
    component: () => import("../views/Students/OneStudent.vue"),
  },
  {
    path: "/:pathMatch(.*)*",
    name: "Not Found",
    component: () => import("../views/NotFound.vue"),
  },
];

export default routes;
