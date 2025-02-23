import {IOwner} from "../../types";
import {NavLink} from "react-router";

function OwnersTable({owners}: { owners: IOwner[] }) {
    return (<>
        <div className="note note-success mb-3">
            <strong>Note success: Total owners found in the registry - {owners.length}</strong>
        </div>
        <table className="table">
            <thead className="table-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Address</th>
                <th scope="col">City</th>
                <th scope="col">Telephone</th>
                <th scope="col">Pets</th>
            </tr>
            </thead>
            <tbody>
            {owners.map((owner) => (
                <tr key={owner.id}>
                    <td>{owner.id}</td>
                    <td>
                        <NavLink to={`/owners/${owner.id}`}>
                            {owner.firstName} {owner.lastName}
                        </NavLink>
                    </td>
                    <td>{owner.address}</td>
                    <td>{owner.city}</td>
                    <td>{owner.telephone}</td>
                    <td>{owner.pets.map(pet => pet.name).join(', ')}</td>
                </tr>
            ))}
            </tbody>
        </table>
    </>);
}

export default OwnersTable;