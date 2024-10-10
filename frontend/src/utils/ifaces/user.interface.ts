export interface User {
  id: number
  firstname: string
  lastname: string
  email: string
  password?: string
  phone: string
  address: string
  formation_id?: number
  user_type: userType
  /* update_date?: Date */
}

export enum userTypes {
  student = 'student',
  teacher = 'teacher',
  STUDENT = 'STUDENT',
  TEACHER = 'TEACHER'
}

export type userType = keyof typeof userTypes
