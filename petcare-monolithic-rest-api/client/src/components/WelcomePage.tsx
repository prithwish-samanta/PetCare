import WelcomeImage from "../assets/pet-care-welcomepage-img.webp";

function WelcomePage() {
    return (
        <div className="container my-3">
            <h2 className="text-center">Welcome</h2>
            <div className='row'>
                <img className='img-responsive' src={WelcomeImage} alt="Welcome imge"/>
            </div>
        </div>
    )
}

export default WelcomePage;