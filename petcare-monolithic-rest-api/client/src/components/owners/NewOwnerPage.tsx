import {IOwner} from "../../types";
import OwnerEditor from "./OwnerEditor.tsx";

function NewOwnerPage() {
    const newOwner: IOwner = {
        id: null,
        firstName: '',
        lastName: '',
        address: '',
        city: '',
        telephone: '',
        pets: []
    }

    return (
        <section className="container my-3">
            <h2 className="text-center mb-3">Add new Owner</h2>
            <OwnerEditor owner={newOwner} isNew={true}/>
        </section>
    );
}

export default NewOwnerPage;