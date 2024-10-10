export interface Lesson {
  id: number
  name: string
  date: Date
  room_number?: number
  formation_id: number
  duration: number
  users_id?: number[]
  /* teacher: string */
  /* deleted_date?: Date */
}
