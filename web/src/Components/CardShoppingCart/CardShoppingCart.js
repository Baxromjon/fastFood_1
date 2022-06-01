import React from 'react';
import { Typography, Button, Box } from '@material-ui/core';
import {useDispatch } from 'react-redux';
import {removeProduct , decreaseQuantity , increaseQuantity} from '../../Redux/ReduxFeatures/CartSlice';
import useStyles from './styles'
import DeleteOutlinedIcon from '@material-ui/icons/DeleteOutlined';


const CardShoppingCart = ({product , countSingleProduct}) => {
    console.log(product)
  const classes = useStyles();
  const dispatch = useDispatch();
  const deleteProduct = (id) =>  dispatch(removeProduct(id));

  return (
    <Box  className={classes.card} display='flex' justifyContent="space-between" alignItems='center'>
      <img src={'http://localhost:8090/api/attachment/'+product.image} alt={product.name} className={classes.media} />
      <Typography gutterBottom className={classes.itemRow} variant='subtitle2' >{product.name}</Typography>
      <Typography gutterBottom className={classes.itemRow} variant='subtitle2' >{product.price}</Typography>
      <div className={classes.itemRow}>
        <div className={classes.buttons}>
            <Button type="button" size="small" onClick={() => dispatch(decreaseQuantity(product))}>-</Button>
            <Typography>&nbsp;{product.quantity}&nbsp;</Typography>
            <Button type="button" size="small"  onClick={() => dispatch(increaseQuantity(product))}>+</Button>
        </div>
      </div>
      <Typography gutterBottom className={classes.itemRow} variant='subtitle2' >{product.price * product.quantity}</Typography>
      <div className={classes.itemRow}>
          <Button className={classes.delete} variant="contained" type="button" color="secondary" onClick={() => deleteProduct(product.id)}><DeleteOutlinedIcon/> O`CHIRISH</Button>
      </div>
      </Box>

  );
};

export default CardShoppingCart;
