import { Outlet } from "react-router-dom";

import Navbar from "../../components/layout/Navbar/Navbar";
import Sidebar from "../../components/layout/Sidebar/Sidebar";
import Footer from "../../components/layout/Footer/Footer";


function MainLayout() {

  return (

    <div className="min-h-screen flex flex-col">

      <Navbar />

      <div className="flex flex-1">

        <Sidebar />

        <main className="
flex-1
p-8
bg-gray-100
min-h-screen
">

          <Outlet />

        </main>

      </div>


      <Footer />

    </div>

  );

}


export default MainLayout;