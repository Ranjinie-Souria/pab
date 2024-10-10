export interface Row {
  id: number
  cells: Cell[]
}

export interface Cell {
  value: string | number
  action: boolean
}