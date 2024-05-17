import axois from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployee = () => axois.get(REST_API_BASE_URL);

export const createEmployee = (employee) => axois.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId) => axois.get(REST_API_BASE_URL + '/' + employeeId);

export const updateEmployee = (employeeId, employee) => axois.put(REST_API_BASE_URL + '/' + employeeId, employee);

export const deleteEmployee = (employeeId) => axois.delete(REST_API_BASE_URL + '/' + employeeId);