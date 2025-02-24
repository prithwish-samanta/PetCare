import './App.css'
import {Route, Routes} from "react-router";
import WelcomePage from "./components/WelcomePage.tsx";
import FindOwnersPage from "./components/owners/FindOwnersPage.tsx";
import Navbar from "./components/layout/Navbar.tsx";
import NewOwnerPage from "./components/owners/NewOwnerPage.tsx";
import OwnerInformation from "./components/owners/OwnerInformation.tsx";
import EditOwnerPage from "./components/owners/EditOwnerPage.tsx";

function App() {
    return (
        <>
            <Navbar/>
            <Routes>
                <Route path="/" element={<WelcomePage/>}/>
                <Route path="/owners/list" element={<FindOwnersPage/>}/>
                <Route path="/owners/new" element={<NewOwnerPage/>}/>
                <Route path="owners/:ownerId" element={<OwnerInformation/>}/>
                <Route path="/owners/:ownerId/edit" element={<EditOwnerPage/>}/>
            </Routes>
        </>
    )
}

export default App
