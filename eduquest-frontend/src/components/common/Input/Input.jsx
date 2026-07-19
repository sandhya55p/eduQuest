function Input({
    type="text",
    placeholder,
    value,
    onChange,
    name
}){


return(

<input

type={type}

name={name}

placeholder={placeholder}

value={value}

onChange={onChange}

className="
w-full
px-4
py-3
rounded-lg
border
border-gray-300
outline-none
focus:ring-2
focus:ring-purple-500
"

/>

)

}


export default Input;