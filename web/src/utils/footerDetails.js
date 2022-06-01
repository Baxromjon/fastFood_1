import FacebookIcon from '@material-ui/icons/Facebook';
import LinkedInIcon from '@material-ui/icons/LinkedIn';
import GitHubIcon from '@material-ui/icons/GitHub';
import InstagramIcon from '@material-ui/icons/Instagram';
import {ABOUT_PATH, HOME_PATH, LOGIN_PATH, OUR_PRODUCTS_PATH, SIGNUP_PATH, ADMIN_CABINET_PATH, CLIENT_CABINET_PATH, ADD_PRODUCT_PATH, SERVICE_PATH, CHECKOUT_PATH, SHOPPING_CART_PATH} from '../constants/Routes'

export const socialMediaItems = [
    {pathname : "https://www.facebook.com/bahromjon.isaqov/" , icon: <FacebookIcon/>},
    {pathname : "https://www.instagram.com/bakhromjon_ikbaljanovich/" , icon: <InstagramIcon/>},
    {pathname : "https://www.linkedin.com/in/bahromjon-isaqov-73a7931a1/" , icon: <LinkedInIcon/>},
    {pathname : "https://github.com/Baxromjon" , icon: <GitHubIcon/>},
]


export const itemsLink = [
    {name:'Home' , path:HOME_PATH},
    {name:'About' , path:ABOUT_PATH},
    {name:'Sign in ' , path:LOGIN_PATH},
    {name:'Sign up ' , path:SIGNUP_PATH},
    {name:'Our Products' , path:OUR_PRODUCTS_PATH},
    {name:'Service' , path:SERVICE_PATH},
]
