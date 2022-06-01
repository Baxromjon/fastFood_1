import useStyles from '../../Components/ServiceSection/ServiceCard/styles'
import {motion} from 'framer-motion';
import {variantsHoverIcons} from "../../Animation";
import {Typography} from "@material-ui/core";

function MyProductCard({image, food, drinks, status, description, price, date, time}) {
    const classes=useStyles();

    return(
        <motion.div className={classes.iconContainer}
        whileHover={variantsHoverIcons.whileHover}
        whileTap={variantsHoverIcons.whileTap}>
            <img width={100} src={'http://localhost:8090/api/attachment/' + image} alt="image"/>
            <Typography variant='h5'>{food}</Typography>
            <Typography variant='h5'>{drinks}</Typography>
            <Typography variant='h6'>{status}</Typography>
            <Typography variant='body2'>{description}</Typography>
            <Typography variant='h6'>{price+' UZS'}</Typography>
            <Typography variant='h6'>{date}</Typography>
            <Typography variant='h6'>{time}</Typography>
        </motion.div>
    )
}

export default MyProductCard;
