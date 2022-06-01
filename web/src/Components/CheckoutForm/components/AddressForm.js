import React from 'react';
import { Grid, Typography , Button } from '@material-ui/core';
import CustomTextFiled from '../../CustomTextFiled/CustomTextFiled';
import {useForm , FormProvider} from 'react-hook-form';
import { Link } from 'react-router-dom';
import { SHOPPING_CART_PATH } from '../../../constants/Routes';
import useStyles from './styles';

function AddressForm({next}) {
    const methods  = useForm();
    const classes = useStyles();

    return (
        <>
            <Typography variant="h5">Yetkaziluvchi manzil</Typography>
            <FormProvider {...methods}>
                <form onSubmit={methods.handleSubmit(data => next({...data}))}>
                    <Grid container spacing={3}>
                        <CustomTextFiled name="firstName" label="Ismingiz" />
                        <CustomTextFiled name="lastName" label="Familiyangiz" />
                        <CustomTextFiled name="email" label="Telefon raqamingiz" />
                        <CustomTextFiled name="address" label="Manzil" />
                        <CustomTextFiled name="city" label="Shaxar" />
                        <CustomTextFiled name="zip" label="Joyni ko`rsating" />

                    </Grid>
                    <div className={classes.groupBtn}>
                        <Button component={Link} variant="outlined" to={SHOPPING_CART_PATH}>Savatchaga qaytish</Button>
                        <Button type="submit" variant="contained" color="primary">Keyingisi</Button>
                    </div>
                </form>
            </FormProvider>
        </>
    )
}

export default AddressForm
