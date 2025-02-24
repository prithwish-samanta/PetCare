import OwnersTable from "./OwnersTable.tsx";
import {Link} from "react-router";
import {useState} from "react";
import {IOwner} from "../../types";
import {ApiManager} from "../../api-manager/ApiManager.ts";

function FindOwnersPage() {
    const [owners, setOwners] = useState<IOwner[]>([]);
    const [searchTerm, setSearchTerm] = useState<string>("");
    const [error, setError] = useState<string | null>(null);

    const fetchOwners = async (lastName: string) => {
        setError(null);
        setOwners([]);

        try {
            const data = await ApiManager.getOwners(lastName);
            setOwners(data);
        } catch (err: any) {
            setError(err.message);
        }
    };

    const handleSearch = () => {
        fetchOwners(searchTerm);
    };

    return (
        <section className="container">
            <div className="my-3">
                <h2 className="text-center mb-3">Find Owners</h2>
                <div className="input-group input-group-lg mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Owner's last name"
                        aria-label="Owner's last name"
                        value={searchTerm}
                        onChange={(e) => setSearchTerm(e.target.value)}
                    />
                    <button
                        className="btn btn-primary"
                        type="button"
                        id="button-addon2"
                        onClick={handleSearch}
                    >
                        Search
                    </button>
                </div>
                {error && <p className="alert alert-danger text-center">{error}</p>}
                {owners.length > 0 && <OwnersTable owners={owners}/>}
                <Link className="btn btn-primary" to="/owners/new">Add Owner</Link>
            </div>
        </section>
    );
}

export default FindOwnersPage;
