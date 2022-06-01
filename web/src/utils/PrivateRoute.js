import React from 'react';
import {connect} from 'react-redux';
import {Redirect, Route, withRouter} from 'react-router-dom';
import {userMe} from '../Redux/actions/AuthActions'
import {NEW_USER_FOR_ORDER, ORDER, PUSH_SERVICE, TOKEN} from "./constant";

const PrivateRoute = ({dispatch, auth, path, history, location, component: Component, ...rest}) => {
    dispatch(userMe())

    if (window.location.pathname !== '/client/main-page' && window.location.path !== '/client-checkout' &&
        window.location.pathname !== '/client-shopping-cart') {
        localStorage.removeItem(ORDER)
        localStorage.removeItem(NEW_USER_FOR_ORDER)
        localStorage.removeItem(PUSH_SERVICE)
    }
    const filterRole = (props) => {
        const role = localStorage.getItem('role');
        if (role === 'admin') {
            if (path.includes('/admin')) {
                return <Component {...props} />
            } else return <Redirect to={'/badRequest'}/>
        } else if (role === 'client') {
            if (path.includes('/client/main-page')) {
                return <Component {...props} />
            } else return <Redirect to={'/badRequest'}/>
        } else if (role === 'moderator') {
            if (path.includes('/moderator/main-page')) {
                return <Component {...props} />
            } else return <Redirect to={'/badRequest'}/>
        }
    }

    return (
        <Route
            path={path}
            {...rest}
            render={(props) =>
                localStorage.getItem(TOKEN) != null ? (
                    filterRole(props)
                ) : (
                    <Redirect to={{
                        pathname: '/',
                        state: {from: props.location}
                    }}/>
                )}
        />
    )
}
export default connect(({privateRoute, auth})=>({privateRoute, auth}))(
    withRouter(PrivateRoute)
);
