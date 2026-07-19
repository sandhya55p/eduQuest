import {
FaHome,
FaBook,
FaTrophy,
FaShoppingBag,
FaCog
} from "react-icons/fa";


function Sidebar(){


const menu=[

{
name:"Home",
icon:<FaHome/>
},

{
name:"Subjects",
icon:<FaBook/>
},

{
name:"Leaderboard",
icon:<FaTrophy/>
},

{
name:"Shop",
icon:<FaShoppingBag/>
},

{
name:"Settings",
icon:<FaCog/>
}

];


return(

<aside className="
w-64
bg-slate-900
text-white
p-6
">


<h2 className="
text-xl
font-bold
mb-8
">

Menu

</h2>



<ul className="space-y-5">


{
menu.map((item,index)=>(

<li
key={index}
className="
flex
items-center
gap-4
cursor-pointer
hover:text-purple-400
transition
"
>

{item.icon}

<span>

{item.name}

</span>


</li>


))
}


</ul>


</aside>


)

}


export default Sidebar;