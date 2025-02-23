import './App.css'
import {Route, Routes} from "react-router";
import WelcomePage from "./components/WelcomePage.tsx";
import FindOwnersPage from "./components/owners/FindOwnersPage.tsx";
import Navbar from "./components/layout/Navbar.tsx";

function App() {
    return (
        <>
            <Navbar/>
            <Routes>
                <Route path="/" element={<WelcomePage/>}/>
                <Route path="/owners/list" element={<FindOwnersPage/>}/>
            </Routes>
        </>
    )
}

export default App
