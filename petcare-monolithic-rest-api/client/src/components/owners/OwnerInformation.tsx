import {Link} from "react-router";
import {IOwner} from "../../types";
interface OwnerInfoProps {
    owner: IOwner;
}
function OwnerInformation({owner}: OwnerInfoProps) {
    return (
        <div>
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
            <Link to={`/owners/${owner.id}/edit`} className='btn btn-primary me-1'>Edit Owner</Link>
            <Link to={`/owners/${owner.id}/pets/new`} className='btn btn-primary'>Add New Pet</Link>
        </div>
    );
}

export default OwnerInformation;