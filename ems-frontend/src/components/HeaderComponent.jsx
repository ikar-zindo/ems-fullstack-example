import React from 'react'

function home(){
   navigator('/')
}

const HeaderComponent = () => {
  return (
    <div>
      <header>
         <nav className='navbar navbar-dark bg-dark'>
            <a className='navbar-brand' href="https://www.ems.app.net">Employee Menegment System</a>
         </nav>
      </header>

    </div>
  )
}

export default HeaderComponent