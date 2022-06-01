import HttpClient from "../utils/HttpClient";
import {api} from './api'

export const loginUser = (data = {username: null, password: null, newUser: false}) => {
    return HttpClient.doPost(api.login, data);
}
export const exist = (data = {username: null, password: null, phoneNumber: null}) => {
    return HttpClient.doPost(api.exist, data);
}
export const me = (data = {username: null, password: null}) => {
    return HttpClient.doGet(api.userMe);
}
export const register = (data) => {
    return HttpClient.doPost(api.registerUser, data);
}
export const verifyEmail = (data) => {
    return HttpClient.doGet(api.verifyEmail + data.path)
}
export const confirmOffer = (data) => {
    return HttpClient.doGet(api.confirmOffer + data.path)
}
export const verifyCorporateEmail = (data) => {
    return HttpClient.doGet(api.verifyCorporateEmail + data.path)
}

export const verifyCorporateEmailAdmin = (data) => {
    return HttpClient.doGet(api.verifyCorporateEmailAdmin + data.path)
}
export const resetCorporateUserPassword = (data) => {
    return HttpClient.doGet(api.resetCorporateUserPassword + data.path)
}

export const getUserByUserId = (id) => {
    return HttpClient.doGet(api.getUser + id);
}
export const forgotPassword = (data) => {
    let param = ''
    Object.entries(data).map(([key, value]) => param = param + key + '=' + value + '&&')
    return HttpClient.doPut(api.forgotPassword + param);
}
export const confirmCode = (data) => {
    let param = ''
    Object.entries(data).map(([key, value]) => param = param + key + '=' + value + '&&')
    return HttpClient.doPut(api.confirmCode + param);
}
export const resetPassword = (data) => {
    let param = ''
    Object.entries(data).map(([key, value]) => param = param + key + '=' + value + '&&')
    return HttpClient.doPut(api.resetPassword + param);
}

export const editPassword = (data) => {
    return HttpClient.doPut(api.user + "/editPassword", data);
}
export const findCorporateByAdminId = (data) => {
    return HttpClient.doGet(api.findCorporateByAdmin);
}
