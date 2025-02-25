import {IPet} from "../../types";
import {Link} from "react-router";

interface PetInfoProps {
    ownerId: number | null,
    pets: IPet[]
}

function PetsTable({ownerId, pets}: PetInfoProps) {
    return (
        <div>
            <h3 className="text-center mb-3">Pets and Visits</h3>
            <table className="table table-bordered">
                <thead className="table-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Birth Date</th>
                    <th scope="col">Type</th>
                    <th scope="col">Visit Info</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                {pets.map((pet) => (
                    <tr key={pet.id}>
                        <td>{pet.name}</td>
                        <td>{pet.birthDate}</td>
                        <td>{pet.petType.name}</td>
                        {pet.visits.length == 0 && <td>No visits scheduled</td>}
                        {pet.visits.length > 0 &&
                            <td>{pet.visits.map((visit, idx) => (
                                <span key={idx}>
                                Visit date: {visit.date}<br/>
                                Description: {visit.description}<br/>
                            </span>
                            ))}
                            </td>}
                        <td>
                            <Link to={`/owners/${ownerId}/pets/${pet.id}/edit`} className='btn btn-primary me-1'>Edit
                                Owner</Link>
                            <Link to={`/owners/${ownerId}/pets/${pet.id}/visits/new`} className='btn btn-primary'>Add
                                New Pet</Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default PetsTable;