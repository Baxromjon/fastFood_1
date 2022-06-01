import { Button, Typography } from '@material-ui/core'
import React from 'react'
import { Link } from 'react-router-dom'
import DoneOutlineIcon from '@material-ui/icons/DoneOutline';
import useStyles from './styles';
import { HOME_PATH } from '../../../constants/Routes';

function Confirmation({userInfo}) {
    const classes = useStyles();

    return (
        <div>
            <Typography align='center' gutterBottom variant="h6"> {userInfo.firstName} {userInfo.lastName} Buyurtma uchun Rahmat!, Qisqa vaqt ichida yetkazib beramiz! </Typography>
            <div className={classes.done}>
                <DoneOutlineIcon/>
            </div>
            <Button component={Link} to={HOME_PATH} variant='contained' color="primary">Asosiyga qaytish</Button>
        </div>
    )
}

export default Confirmation
