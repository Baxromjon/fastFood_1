import React from 'react'
import { Typography } from '@material-ui/core';
import useStyles from './Styles';

function Title({title}) {
    const classes = useStyles();

    return (
        <div className={classes.titleContainer}>
            <Typography component='h3'> fast-Food</Typography>
            <Typography gutterBottom variant='h2' component='h2' className={classes.subTitle}> {title} </Typography>
        </div>
    )
}

export default Title
