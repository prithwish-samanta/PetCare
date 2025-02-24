import {useEffect, useState} from "react";
import {IOwner} from "../../types";
import {ApiManager} from "../../api-manager/ApiManager.ts";
import {Link, useParams} from "react-router";

function OwnerInformation() {
    const {ownerId} = useParams();
    const [owner, setOwner] = useState<IOwner | null>(null);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const loadOwnerDetails = async () => {
            if (!ownerId) return;
            const ownerIdNumber = Number(ownerId);
            setError(null);
            try {
                const data = await ApiManager.getOwnerById(ownerIdNumber);
                setOwner(data);
            } catch (err: any) {
                setError(err.message || "Failed to load owner details.");
            }
        };

        loadOwnerDetails();
    }, []);
    return (
        <section className="container my-3">
            <h2 className="text-center mb-3">Owner Information</h2>
            {error && <p className="alert alert-danger text-center">{error}</p>}
            {owner &&
                <table className="table table-bordered">
                    <thead className="table-dark">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Address</th>
                        <th scope="col">City</th>
                        <th scope="col">Telephone</th>
                        <th scope="col">Pets</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>{owner.firstName} {owner.lastName}</td>
                        <td>{owner.address}</td>
                        <td>{owner.city}</td>
                        <td>{owner.telephone}</td>
                        <td>{owner.pets.map(pet => pet.name).join(', ')}</td>
                    </tr>
                    </tbody>
                </table>
            }
            {owner && <Link to={`/owners/${owner.id}/edit`} className='btn btn-primary me-1'>Edit Owner</Link>}
            {owner && <Link to={`/owners/${owner.id}/pets/new`} className='btn btn-primary'>Add New Pet</Link>}
        </section>
    );
}

export default OwnerInformation;