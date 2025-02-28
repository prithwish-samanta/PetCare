import NavBrandLogo from "../../assets/navbrand-logo.webp";
import {Link, NavLink} from "react-router";

function Navbar() {
    return <nav className="navbar navbar-expand-lg navbar-dark bg-dark-subtle">
        <div className="container">
            <NavLink className="navbar-brand me-2" to="/">
                <img
                    src={NavBrandLogo}
                    height="50"
                    alt="PetCare Logo"
                    loading="lazy"
                />
            </NavLink>
            <button
                data-mdb-collapse-init
                className="navbar-toggler"
                type="button"
                data-mdb-target="#navbarButtonsExample"
                aria-controls="navbarButtonsExample"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <i className="fas fa-bars"></i>
            </button>
            <div className="collapse navbar-collapse" id="navbarButtonsExample">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                        <NavLink className="nav-link text-uppercase" to="/">Home</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link text-uppercase" to="/owners/list">Find owners</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link text-uppercase" to="/vets">Veterinarians</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link text-uppercase" to="/error">Error</NavLink>
                    </li>
                </ul>
                <div className="d-flex align-items-center">
                    <Link type="button" role="button" className="btn btn-primary me-3" to="/auth/login">
                        Login
                    </Link>
                    <Link
                        className="btn btn-light px-3"
                        to="https://github.com/prithwish-samanta/PetCare/"
                        role="button"
                    ><i className="fab fa-github"></i
                    ></Link>
                </div>
            </div>
        </div>
    </nav>
}

export default Navbar;