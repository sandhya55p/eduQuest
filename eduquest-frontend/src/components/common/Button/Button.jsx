function Button({ 
    children, 
    type = "button",
    onClick,
    className = ""
}) {

    return (

        <button
            type={type}
            onClick={onClick}
            className={`
                bg-purple-600
                text-white
                px-6
                py-3
                rounded-xl
                font-semibold
                hover:bg-purple-700
                transition
                ${className}
            `}
        >

            {children}

        </button>

    );

}


export default Button;