import { Box, Button, Typography } from '@material-ui/core'
import React from 'react'
import { Link } from 'react-router-dom';
import { CHECKOUT_PATH } from '../../constants/Routes';
import useStyles from './styles';
import { useSelector  } from 'react-redux';


function CardTotal({countTotalProduct}) {
    const classes = useStyles();
    const {shopCartProducts} = useSelector((state) => state.cart);
    const disableBtn = !shopCartProducts.length ? true : false ;

    return (
        <Box className={classes.cartTotal} display='flex' flexDirection='column' justifyContent="center">
             <Typography  gutterBottom variant='h6'>To`lov</Typography>
             <Typography gutterBottom variant='h6'>Narx = {countTotalProduct}$</Typography>
             <Typography gutterBottom variant='h6'>Umumiy narx = {countTotalProduct}$</Typography>
             <Button component={Link} disabled={disableBtn} to={CHECKOUT_PATH} variant="contained" color='secondary'>Davom etish </Button>
        </Box>
    )
}

export default CardTotal
