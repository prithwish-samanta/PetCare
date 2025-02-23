import {LIST_OF_OWNERS} from "../../data";
import {IOwner} from "../../types";
import OwnersTable from "./OwnersTable.tsx";
import {Link} from "react-router";

const owners: IOwner[] = LIST_OF_OWNERS;

function FindOwnersPage() {
    return (
        <section className="container">
            <div className="my-3">
                <h2 className="text-center mb-3">Find Owners</h2>
                <div className="input-group input-group-lg mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Owner's lastname"
                        aria-label="Owner's lastname"
                        aria-describedby="button-addon2"
                    />
                    <button className="btn btn-primary" type="button" id="button-addon2"
                            data-mdb-ripple-color="dark">
                        Button
                    </button>
                </div>
                <OwnersTable owners={owners}/>
                <Link className='btn btn-primary' to='/owners/new'> Add Owner</Link>
            </div>
        </section>
    )
}

export default FindOwnersPage;