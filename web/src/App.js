import {BrowserRouter as Router , Switch , Route} from 'react-router-dom';
import Home from './Pages/Home/Home';
import ShoppingCart from './Pages/ShoppingCart/ShoppingCart';
import Checkout from './Pages/Checkout/Checkout';
import Register from './Pages/Register/Register';
import Login from './Pages/login/Login';
import OurProducts from './Pages/OurProducts/OurProducts';
import Layout from './layout/Layout';
import { HOME_PATH, SHOPPING_CART_PATH , CHECKOUT_PATH, SIGNUP_PATH, LOGIN_PATH, OUR_PRODUCTS_PATH, ABOUT_PATH, ADD_PRODUCT_PATH, CLIENT_CABINET_PATH, Product_PATH, DRINKS_PATH, DASHBOARD_PATH } from './constants/Routes';
import CreateThemeProvider from './Theme/Theme';
import About from './Pages/About/About';
import Cabinet from "./Pages/Client/Cabinet";
import AdminDashboard from "./Pages/Admin/AdminDashboard";

function App() {

  return (
    <CreateThemeProvider>
      <Router>
        <Layout>
          <Switch>
            <Route exact path={HOME_PATH} component={Home} />
            <Route exact path={CLIENT_CABINET_PATH} component={Cabinet} />
            <Route exact path={SHOPPING_CART_PATH} component={ShoppingCart} />
            <Route exact path={CHECKOUT_PATH} component={Checkout} />
            <Route exact path={SIGNUP_PATH} component={Register} />
            <Route exact path={LOGIN_PATH} component={Login} />
            <Route exact path={OUR_PRODUCTS_PATH} component={OurProducts} />
            <Route exact path={ABOUT_PATH} component={About} />
            <Route exact path={DASHBOARD_PATH} component={AdminDashboard} />
          </Switch>
        </Layout>
      </Router>
    </CreateThemeProvider>
  );
}

export default App;
