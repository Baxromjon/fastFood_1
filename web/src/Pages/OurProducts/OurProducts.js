import React, {useState, useEffect} from 'react';
import useFetch from "../../Hooks/useFetch";
import CardProduct from '../../Components/CardProduct/CardProduct'
import {Container, Grid} from '@material-ui/core';
import Title from '../../Components/Title/Title';
import Sidebar from '../../Components/Sidebar/Sidebar';
import request from "../../utils/request";
import {api} from "../../API/api";
import './OurProducts.css'
import Button from "@material-ui/core/Button";
import {useDispatch} from "react-redux";
import {addProduct} from "../../Redux/ReduxFeatures/CartSlice";

function OurProducts() {
    const {data} = useFetch();
    const [pasteDishes, setPasteDishes] = useState([]);
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);
    const [currentCategory, setCurrentCategory] = useState('');
    useEffect(() => {
        setPasteDishes(data)
        getAllCategory()
        getAllProducts()
    }, [])

    const getAllCategory = () => {
        request({
            url: api.getAllCategory,
            method: 'GET'
        }).then(res => {
            setCategories(res.data)
        }).catch(err => {
        })
    }
    const getAllProducts = () => {
        request({
            url: api.getAllProducts,
            method: 'GET'
        }).then(res => {
            setProducts(res.data)
        }).catch(err => {
        })
    }
    const getProductByCategoryId = () => {
        request({
            url: api.getByCategoryId + '/' + currentCategory,
            method: 'GET'
        }).then(res => {
            setProducts(res.data)
        }).catch(err => {
        })
    }
    // filter data 
    const filterData = (type) => {
        setCurrentCategory(type);
    }

    return (
        <>
            {/*<Header title="Bizning mahsulotlar"/>*/}
            <Container>
                <Title title="Bizning mahsulotlar"/>
                <Grid container spacing={3}>
                    <Grid item md={4} onClick={() => getProductByCategoryId()}>
                        <Sidebar filterData={filterData}/>
                    </Grid>
                    <Grid item xs={12} md={8} container spacing={1}>
                        {
                            products?.map(item => (
                                <Grid item xs={12} sm={6} md={4} key={item.id}>
                                    {/*<CardProduct product={item} />*/}
                                    <div className="gallery">
                                        <div className="container">
                                            <div className="card  m-1 p-1" style={{width: "250px"}}>
                                                <img className="card-img-top"
                                                     src={'http://localhost:8090/api/attachment/' + item.photo.id}
                                                     alt="Card image" style={{width: "100%"}}/>
                                                <div className="card-body">
                                                    <h4 className="card-title">{item.name}</h4>
                                                    <h6 className="card-title">{item.price + " so'm"}</h6>
                                                    {/*<h6 className="card-title">{item.discountPercent+"% chegirma"}</h6>*/}
                                                    {/*<p className="card-text">{item.description?item.description:''}</p>*/}
                                                    <button className="btn btn-outline-secondary">add to card</button>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </Grid>
                            ))
                        }
                    </Grid>
                </Grid>
            </Container>
        </>
    )
}

export default OurProducts
