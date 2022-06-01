import { createSlice } from '@reduxjs/toolkit'

// cart state
const initialState = {
    shopCartDetails:{
        id:'',
        title:'',
        price:'',
        image:'',
        quantity:0
    },
    shopCardDrinks:[]
}

export const ShopCartSlice = createSlice({
    name: 'counter',
    initialState,
    reducers: {
        addDrink:(state , action) => {
            // add details
            if (state.shopCardDrinks.length === 0 ) {
                state.shopCartDetails.id = action.payload.id;
                state.shopCartDetails.title = action.payload.title;
                state.shopCartDetails.price = action.payload.price;
                state.shopCartDetails.quantity = action.payload.quantity;
                state.shopCartDetails.image = action.payload.image;
                // set details to shopCardDrinks
                state.shopCardDrinks = [state.shopCartDetails, ...state.shopCardDrinks]
            }else {
                let check = false ;
                state.shopCardDrinks.forEach((item , key) =>{
                    if (item.id === action.payload.id) {
                        state.shopCardDrinks[key].quantity++;
                        check = true ;
                    }
                })

                if (!check) {
                    state.shopCartDetails.id = action.payload.id;
                    state.shopCartDetails.title = action.payload.title;
                    state.shopCartDetails.price = action.payload.price;
                    state.shopCartDetails.quantity = action.payload.quantity;
                    state.shopCartDetails.image = action.payload.image;
                    // set details to shopCardDrinks
                    state.shopCardDrinks = [state.shopCartDetails, ...state.shopCardDrinks]
                }
            }
        },
        increaseQuantity:(state , action) => {
            state.shopCardDrinks.forEach((item , key) =>{
                if (item.id === action.payload.id) {
                    state.shopCardDrinks[key].quantity++;
                }
            })
        },
        decreaseQuantity:(state , action) => {
            state.shopCardDrinks.forEach((item , key) =>{
                if (item.id === action.payload.id) {
                    const quantity =  state.shopCardDrinks[key].quantity;
                    if(quantity > 1 ) {
                        state.shopCardDrinks[key].quantity--;
                    }
                }
            })
        },
        removeDrink:(state , action) => {
            state.shopCardDrinks = state.shopCardDrinks.filter(item => item.id !== action.payload);
        },
        cleanShoppingCart:(state) => {
            state.shopCardDrinks = []
        },

    },
})

// Action creators are generated for each case reducer function
export const { addDrink , removeDrink , increaseQuantity , decreaseQuantity , cleanShoppingCart} = ShopCartSlice.actions

export default ShopCartSlice.reducer
