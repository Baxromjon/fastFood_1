import React, {Component} from 'react';
import PropTypes from 'prop-types';
import request from "../../utils/request";
import Title from "../../Components/Title/Title";
import {Box} from "@material-ui/core";
import {TOKEN} from "../../utils/constant";
import MyProductCard from "./MyProductCard";
import {Button} from "reactstrap";

class Cabinet extends Component {
    state = {
        myFoods: [],
        currentFoods: '',
        currentUser: ''
    }


    componentDidMount() {
        if (!localStorage.getItem(TOKEN)) {
            this.props.history.push('/login')
        } else {
            this.getUserMe()
            this.getMyFoods()
        }
    }

    routeToOurProduct = () => {
        this.props.history.push('/our-product')
    }

    getUserMe = () => {
        request({
            url: '/users/me',
            method: 'GET'
        }).then(res => {
            console.log(res.data);
            this.setState({currentUser: res.data})
        }).catch(err => {
        })
    }
    getMyFoods = () => {
        let current = this.state.currentUser
        request({
            url: '/orders/getByUserId/a734c886-e7f6-4a81-9336-413c05865169',
            method: 'GET'
        }).then(res => {
            console.log(res.data);
            this.setState({myFoods: res.data})
        }).catch(err => {
        })
    }

    render() {

        return (
            <div>
                <Title title='Mening Buyurtmalarim'/>
                <Button className="btn btn-info" onClick={this.routeToOurProduct}>Yangi Buyurtma</Button>
                <Box display='flex' flexWrap='wrap' alignContent='center'
                     alignItems='center'>
                    {this.state.myFoods?.map((item, index) =>
                        <div key={index}>
                            <MyProductCard food={item.food} description={item.description} price={item.price}
                                           status={item.status} date={item.date.substring(0, 10)} drinks={item.drinks}
                                           image={item.photo} time={item.date.substring(11, 19)}/>
                        </div>)}
                </Box>
            </div>
        );
    }
}

Cabinet.propTypes = {};

export default Cabinet;
