import * as types from '../../utils/ActionTypes/AppActionType';
import * as types2 from '../../utils/ActionTypes/AuthActionType';

import {
    confirmOffer,
    getUserByUserId,
    loginUser,
    register,
    me
} from '../../API/AuthApi'
import {NEW_USER_FOR_ORDER, TOKEN} from '../../utils/constant';
// import {confirmCode,
//     editPassword,
//     forgotPassword,
//     me,
//     resetPassword,
// } from '../../API/AuthApi'
import {toast} from 'react-toastify';
import * as app2 from '../API/AppAPI';
import jwt from 'jwt-decode';

export const login = (payload) => async (dispatch) => {
    try {
        const res = await dispatch({
            api: loginUser,
            types2: [types2.REQUEST_AUTH_START, "", types2.REQUEST_API_ERROR],
            data: payload.v,
        });
        if (res.success) {
            let parsedToken = jwt(res.payload.token);
            setTimeout(() => {
                setStateRole(parsedToken.role, dispatch);
                pushHisPage(parsedToken.role, payload.history)
            }, 1000);
            localStorage.setItem(
                TOKEN,
                res.payload.tokenType + ' ' + res.payload.token
            );
        }
        return true;
    } catch (err) {
        if (err.response) toast.error(err.response.data.message);
        return false;
    }
}
const setStateRole = (roles, dispatch) => {
    let roleStatus = ""
    roles.forEach((item) => {
        if (item.roleName === "ADMIN") {
            dispatch({
                type: "updateState",
                payload: {
                    isSuperAdmin: true,
                    isAdmin: true,
                },
            });
            roleStatus = 'admin'
        } else if (item.roleName === "MODERATOR") {
            dispatch({type: "updateState", payload: {isAgent: true}});
            roleStatus = 'moderator'
        } else if (item.roleName === "CLIENT") {
            dispatch({type: "updateState", payload: {isUser: true}});
            roleStatus = 'user'
        }
        localStorage.setItem('role', roleStatus);
    });
};
const pushHisPage = (roles, history) => {
    const {push} = history;
    roles.forEach(({roleName}) => {
        if (roleName === "ADMIN") {
            push("/admin");
        } else if (roleName === "MODERATOR") {
            push("/moderator");
        } else if (roleName === "CLIENT") {
            push("/client/main-page");
        }
    });
};

export const userMe = (payload, minusNine) => async (dispatch, getState) => {
    const {
        auth: {currentUser, sentUserMe},
    } = getState();
    if (!minusNine && (sentUserMe || currentUser || !localStorage.getItem(TOKEN))) return;
    try {
        const response = await dispatch({
            api: me,
            types: [
                types2.AUTH_GET_CURRENT_USER_REQUEST,
                types2.AUTH_GET_USER_TOKEN_SUCCESS,
                types2.AUTH_GET_CURRENT_USER_ERROR,
            ],
        });
        if (response.success) {
            dispatch({
                type: "updateState",
                payload: {
                    permissions: response.payload.permissions,
                },
            });
            if (payload) {
                dispatch({
                    type: "updateStateOrder",
                    payload: {currentUser: response.payload},
                });
            }
            dispatch({
                type: types2.AUTH_GET_USER_TOKEN_SUCCESS,
                payload: response.payload,
            });
            setStateRole(response.payload.roles, dispatch);
        } else {
            dispatch({
                type: types2.AUTH_LOGOUT,
            });
        }
    } catch (e) {
        dispatch({
            type: types2.AUTH_LOGOUT,
        });
    }
};

export const registerUser = (payload) => async (dispatch) => {
    const response = await dispatch({
        api: register,
        types2: [
            types2.REQUEST_AUTH_START,
            types2.AUTH_REGISTER_USER_SUCCESS,
            types2.REQUEST_API_ERROR
        ],
        data: payload,
    });
    if (response.success) {
        dispatch({
            type: types2.REQ_ALERT,
            payload: response.payload.message,
        })
    }
    return response;
};
export const getUserById = (id) => (dispatch) => {
    dispatch({
        api: getUserByUserId,
        types2: ["", "", ""],
        data:id
    })
}
