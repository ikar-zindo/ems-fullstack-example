import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {
  
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* // http://localhost:3000 */}
            <Route path='/' element = { <ListEmployeeComponent /> }></Route>

            {/* // http://localhost:3000/employees */}
            <Route path='/employees' element = { <ListEmployeeComponent /> }></Route>

            {/* // http://localhost:3000/add-employee */}
            <Route path='/add-employee' element = { <EmployeeComponent /> }></Route>

            {/* // http://localhost:3000/edit-employee/0000018f-85fa-35b5-196a-5770a1b241fb */}
            <Route path='/edit-employee/:id' element = { <EmployeeComponent /> }></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
