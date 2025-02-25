import {useParams} from "react-router";
import {useEffect, useState} from "react";
import {IOwner} from "../../types";
import {ApiManager} from "../../api-manager/ApiManager.ts";
import OwnerInformation from "./OwnerInformation.tsx";
import PetsTable from "./PetsTable.tsx";

function OwnersPage() {
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
                setError(err.message);
            }
        };

        loadOwnerDetails();
    }, []);
    return (
        <section className="container my-3">
            <h2 className="text-center mb-3">Owner Details</h2>
            {error && <p className="alert alert-danger text-center">{error}</p>}
            {owner && <OwnerInformation owner={owner}/>}
            {owner && <PetsTable ownerId={owner.id} pets={owner.pets}/>}
        </section>
    );
}

export default OwnersPage;