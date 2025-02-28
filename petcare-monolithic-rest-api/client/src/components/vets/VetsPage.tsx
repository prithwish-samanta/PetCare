import {useEffect, useState} from "react";
import {IVet} from "../../types";
import {ApiManager} from "../../api-manager/ApiManager.ts";
import LoadingSpinner from "../common/LoadingSpinner.tsx";

function VetsPage() {
    const [vets, setVets] = useState<IVet[] | null>([]);
    const [error, setError] = useState<string | null>(null);
    const [loading, setLoading] = useState<boolean>(false);

    useEffect(() => {
        const loadVets = async () => {
            setError(null);
            setLoading(true);
            try {
                const data = await ApiManager.getVets();
                setVets(data);
                setLoading(false);
            } catch (err: any) {
                setError(err.message);
                setLoading(false);
            }
        };

        loadVets();
    }, []);

    return (
        <section className="container my-3">
            <h2 className="text-center mb-3">Veterinarians</h2>
            {loading && <LoadingSpinner/>}
            {error && <p className="alert alert-danger text-center">{error}</p>}
            {vets && vets.length > 0 &&
                <div>
                    <table className="table table-bordered">
                        <thead className="table-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Specialties</th>
                        </tr>
                        </thead>
                        <tbody>
                        {vets.map((vet) => (
                            <tr key={vet.id}>
                                <td>{vet.id}</td>
                                <td>{`${vet.firstName} ${vet.lastName}`}</td>
                                {vet.specialties.length > 0 &&
                                    <td>{vet.specialties.map(speciality => speciality.name).join(", ")}</td>}
                                {vet.specialties.length == 0 && <td>none</td>}
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            }
        </section>
    );
}

export default VetsPage;