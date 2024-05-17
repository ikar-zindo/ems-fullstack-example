import axois from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployee = () => axois.get(REST_API_BASE_URL);

