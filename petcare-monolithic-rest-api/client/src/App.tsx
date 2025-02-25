import './App.css'
import {Route, Routes} from "react-router";
import WelcomePage from "./components/WelcomePage.tsx";
import FindOwnersPage from "./components/owners/FindOwnersPage.tsx";
import Navbar from "./components/layout/Navbar.tsx";
import NewOwnerPage from "./components/owners/NewOwnerPage.tsx";
import EditOwnerPage from "./components/owners/EditOwnerPage.tsx";
import ErrorPage from "./components/ErrorPage.tsx";
import OwnersPage from "./components/owners/OwnersPage.tsx";

function App() {
    return (
        <>
            <Navbar/>
            <Routes>
                <Route path="/" element={<WelcomePage/>}/>
                <Route path="/owners/list" element={<FindOwnersPage/>}/>
                <Route path="/owners/new" element={<NewOwnerPage/>}/>
                <Route path="owners/:ownerId" element={<OwnersPage/>}/>
                <Route path="/owners/:ownerId/edit" element={<EditOwnerPage/>}/>
                <Route path="/error" element={<ErrorPage/>}/>
            </Routes>
        </>
    )
}

export default App
