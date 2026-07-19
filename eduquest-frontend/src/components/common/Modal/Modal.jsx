function Modal({
    children,
    closeModal
}){


return(

<div

className="
fixed
inset-0
bg-black/50
flex
items-center
justify-center
"

>


<div

className="
bg-white
rounded-xl
p-6
"

>


<button
onClick={closeModal}
>

❌

</button>


{children}


</div>


</div>


)

}


export default Modal;