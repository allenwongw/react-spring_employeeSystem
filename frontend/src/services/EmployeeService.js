import axios from "axios";

const REST_API_BAS_URL = 'http://localhost:9090/api/ems';

export const listEmployees =  () => axios.get(REST_API_BAS_URL);

export const createEmployee = (employee) => axios.post(REST_API_BAS_URL, employee);

export const getEmployee = (employeeId) => axios.get(REST_API_BAS_URL + '/' + employeeId);

export const updateEmployee = (employeeId, employee) => axios.put(REST_API_BAS_URL + '/' + employeeId, employee);

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BAS_URL + '/' + employeeId);