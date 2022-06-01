import React, { useState }  from 'react'
import { Box, Button, Container, Grid, Typography  } from '@material-ui/core'
import { FormProvider, useForm } from 'react-hook-form'
import CustomTextFiled from '../../Components/CustomTextFiled/CustomTextFiled';
import { useDispatch } from 'react-redux'
import { Link, useHistory } from 'react-router-dom';
import useStyles from './styles';
import { SIGNUP_PATH } from '../../constants/Routes';
import ButtonWithProgress from '../../Components/Buttons/ButtonWithProgress';
import request from "../../utils/request";
import {TOKEN} from "../../utils/constant";
import {api} from "../../API/api";


function Login() {
    const methods  = useForm();
    const dispatch = useDispatch();
    const history = useHistory();
    const classes = useStyles();
    const [loading, setLoading] = useState(false)

    // sign in by email and password
    const signInByEmailAndPassword = async(data) => {
      setLoading(true)
      try {
          request({
              url:'/auth/login',
              method:'POST',
              data:data
          }).then(res=>{
              if (res.status===200){
                  localStorage.setItem(TOKEN, 'Bearer '+res.data.object)
                    request({
                        url:api.me,
                        method:'GET'
                    }).then(res=>{
                        if (res.data.object.authorities[0].roleName==='ADMIN'){
                            history.push('/dashboard-main')
                        }else if (res.data.object.authorities[0].roleName==='CLIENT'){
                            history.push('/client/main-page')
                        }
                    })
                  // history.push('/client/main-page')
              }
          }).catch(err=>{
              alert('nimadir noto\'g\'ri qayta urinib ko\'ring')
          })
      }catch {
        alert('nimadir noto`g`ri qayta urinib ko`ring');
        setLoading(false)
      }
    }

    return (
        <Container>
          <Box className={classes.root} display='flex' flexDirection='column' justifyContent="center" alignItems="center">
            <Typography align='center' variant='h3' color='secondary'>Login</Typography>
            <FormProvider {...methods}>
              <form onSubmit={methods.handleSubmit(data => signInByEmailAndPassword(data))}>
                  <Grid container spacing={3}>
                      <CustomTextFiled name="phoneNumber" label="phone number" type='phoneNumber' size={13}/>
                      <CustomTextFiled name="password" label="password" type='password' size={12}/>
                      <div className={classes.btnGroup}>
                        <ButtonWithProgress type="submit" text="sign in" loading={loading} />
                        {/*<Button color='primary' variant="contained" onClick={signupByGoogle}>sign in by Google  </Button>*/}
                        <Button component={Link} to={SIGNUP_PATH}>sign up </Button>
                      </div>
                  </Grid>
              </form>
            </FormProvider>
            </Box>
        </Container>
    )
}

export default Login
