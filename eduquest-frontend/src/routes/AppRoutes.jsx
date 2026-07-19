import { Routes, Route } from "react-router-dom";


import MainLayout from "../layouts/MainLayout/MainLayout";
import AuthLayout from "../layouts/AuthLayout/AuthLayout";


import Welcome from "../pages/Welcome/Welcome";
import Login from "../pages/Login/Login";
import Register from "../pages/Register/Register";

import Home from "../pages/Home/Home";
import Subjects from "../pages/Subjects/Subjects";
import Lesson from "../pages/Lesson/Lesson";


function AppRoutes(){


return(

<Routes>


{/* Without Login */}

<Route element={<AuthLayout/>}>

<Route path="/" element={<Welcome/>}/>

<Route path="/login" element={<Login/>}/>

<Route path="/register" element={<Register/>}/>


</Route>



{/* After Login */}

<Route element={<MainLayout/>}>


<Route path="/home" element={<Home/>}/>

<Route path="/subjects" element={<Subjects/>}/>

<Route path="/lesson" element={<Lesson/>}/>


</Route>



</Routes>

)

}


export default AppRoutes;