import { Outlet } from "react-router-dom";

import Footer from "../../components/layout/Footer/Footer";


function AuthLayout(){

return(

<div className="min-h-screen flex flex-col">


<div className="flex-1 flex items-center justify-center">


<Outlet />


</div>


<Footer />


</div>


)

}


export default AuthLayout;