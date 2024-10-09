import axios, { AxiosInstance } from 'axios';

let defaultURL: string = 'http://127.0.0.1'
let defaultPort: string = '8080'

let axiosAPI: AxiosInstance | null = null
axiosAPI = axios.create({
  baseURL: `${defaultURL}:${defaultPort}/`, timeout: 10000, headers: { 'Content-Type': 'application/json'},
})

export default axiosAPI