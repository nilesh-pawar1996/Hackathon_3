import '../Css/login.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import React, { useState } from "react";

function Login() {
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    // Sleep function using setTimeout
    const sleep = (ms) => {
        return new Promise(resolve => setTimeout(resolve, ms));
    };

    const submitLogInDetails = async (event) => {
        try {
            event.preventDefault();
            const result = await axios.get(`http://localhost:8080/user/get-user-details/${userName}/${password}`);
            
            console.log(result.data.role); // Logging the API response data
            if(result.data.role === 'Coco'){
                alert('Login Successfully!!!')
                //navigate page
                navigate('/coursecoordinator');
            }
            else if(result.data.role === 'Staff'){
                alert('Login Successfully!!!')
                // Set userId after login
                localStorage.setItem('userId', result.data.id);
                //navigate page
                navigate('/technicalstaff', {
                    state: {
                        userId: result.data.id,  // Replace `yourDataHere` with the actual data you want to pass
                    },
                });
            }
            else{
                alert("Please check Email and Password");
                navigate('/');
            }
            
        } catch (error) {
            console.error("There was an error fetching the users:", error);
        }
    }

    return (
      <div>
        <div className="container">
            <div className="screen">
                <div className="screen__content">
                    <form className="login">
                        <div className="login__field">
                            <i className="login__icon fas fa-user"></i>
                            <input type="text" className="login__input" 
                            onChange={(event) => setUserName(event.target.value)}
                            placeholder="User name / Email"/>
                        </div>
                        <div className="login__field">
                            <i className="login__icon fas fa-lock"></i>
                            <input type="password" className="login__input" 
                            onChange={(event) => setPassword(event.target.value)}
                            placeholder="Password"/>
                        </div>
                        <button className="button login__submit" onClick={submitLogInDetails}>
                            <span className="button__text">Log In Now</span>
                            <i className="button__icon fas fa-chevron-right"></i>
                        </button>				
                    </form>
                    <div className="social-login">
                        <h3>log in via</h3>
                        <div className="social-icons">
                            <a href="#" className="social-login__icon fab fa-instagram"></a>
                            <a href="#" className="social-login__icon fab fa-facebook"></a>
                            <a href="#" className="social-login__icon fab fa-twitter"></a>
                        </div>
                    </div>
                </div>
                <div className="screen__background">
                    <span className="screen__background__shape screen__background__shape4"></span>
                    <span className="screen__background__shape screen__background__shape3"></span>		
                    <span className="screen__background__shape screen__background__shape2"></span>
                    <span className="screen__background__shape screen__background__shape1"></span>
                </div>		
            </div>
        </div>

      </div>
    );
  }
  
  export default Login;