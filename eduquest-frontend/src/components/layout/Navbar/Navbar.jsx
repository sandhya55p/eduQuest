import { FaBell, FaUserCircle } from "react-icons/fa";


function Navbar(){

return(

<nav className="
h-16bg-gradient-to-r
from-purple-600
to-indigo-600
text-white
flex
items-center
justify-between
px-8
shadow-lg
">


<div className="flex items-center gap-3">

<h1 className="
text-2xl
font-bold
">

🎮 EduQuest

</h1>

</div>



<div className="
flex
items-center
gap-5
">


<button>

<FaBell size={22}/>

</button>


<div className="
flex
items-center
gap-2
cursor-pointer
">


<FaUserCircle size={30}/>


<span>

Profile

</span>


</div>



</div>


</nav>

)

}


export default Navbar;