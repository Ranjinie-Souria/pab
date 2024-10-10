const routes = [
  { path: '/', name: 'Home', component: () => import('../views/Home.vue') },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/lessons',
    name: 'Lessons',
    component: () => import('../views/Lessons/AllLessons.vue')
  },
  {
    path: '/lessons/view/:id',
    name: 'Lesson',
    component: () => import('../views/Lessons/OneLesson.vue')
  },
  {
    path: '/lessons/create',
    name: 'Create Lesson',
    component: () => import('../views/Lessons/AddLesson.vue')
  },
  {
    path: '/lessons/edit/:id',
    name: 'Edit Lesson',
    component: () => import('../views/Lessons/EditLesson.vue')
  },
  {
    path: '/lessons/delete/:id',
    name: 'Delete Lesson',
    component: () => import('../views/Lessons/DeleteLesson.vue')
  },
  {
    path: '/lessons/attendance/:id',
    name: 'Attendance',
    component: () => import('../views/Lessons/Attendance.vue')
  },
  {
    path: '/student/:id',
    name: 'Student',
    component: () => import('../views/Students/OneStudent.vue')
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'Not Found',
    component: () => import('../views/NotFound.vue')
  },
  {
    path: '/Users',
    name: 'Users',
    component: () => import('../views/Users/AllUsers.vue')
  }
]

export default routes
