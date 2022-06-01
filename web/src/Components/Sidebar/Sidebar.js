import React, {useEffect, useState} from 'react'
import { Button, ListItem, Typography } from '@material-ui/core';
import useStyles from './styles';
import TuneIcon from '@material-ui/icons/Tune';
import { motion } from "framer-motion"
import { variantsSidebar } from '../../Animation';
import { categoriesItems } from '../../utils/categoriesItems';
import request from "../../utils/request";
import {api} from "../../API/api";


function Sidebar({filterData}) {
    const classes = useStyles();
    const [openFilter, setOpenFilter] = useState(true);
    const [categories, setCategories]=useState([]);

    useEffect(()=>{
        getAllCategory()
    },[])

    const getAllCategory=()=>{
        request({
            url:api.getAllCategory,
            method:'GET'
        }).then(res=>{
            setCategories(res.data)
        })
    }
    const openSidebar = () => {
        setOpenFilter(!openFilter);
    }

    return (
        <>
            <div className={classes.icon} onClick={openSidebar}>
                <TuneIcon/>
            </div>
            <motion.div animate={openFilter ? "open" : "closed"} variants={variantsSidebar}>
                <Typography variant="h6" className={classes.title} align="center" >Kategoriyalar</Typography>
                <ListItem className={classes.list}>
                    {categories.map((item , index) => (
                        <Button onClick={() => filterData(item.id)} key={index}>{item.name}</Button>
                    ))}
                 </ListItem>
            </motion.div>
        </>

    )
}

export default Sidebar
