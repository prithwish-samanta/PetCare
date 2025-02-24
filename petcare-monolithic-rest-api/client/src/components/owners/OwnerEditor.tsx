import React, {useState} from "react";
import {IOwner} from "../../types";
import {ApiManager} from "../../api-manager/ApiManager.ts";
import {Link} from "react-router";

interface OwnerEditorProps {
    owner: IOwner;
    isNew: boolean
}

function OwnerEditor({owner, isNew}: OwnerEditorProps) {
    const [formData, setFormData] = useState<IOwner>({...owner});
    const [error, setError] = useState<string | null>(null);
    const [savedOwner, setSavedOwner] = useState<IOwner | null>(null);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {id, value} = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [id]: value,
        }));
    };

    const createOrUpdateOwnerDetails = async () => {
        setError(null);
        try {
            if (isNew) {
                const data = await ApiManager.createOwner(formData);
                setSavedOwner(data);
            } else {
                if (owner.id != null) {
                    const data = await ApiManager.updateOwner(owner.id, formData);
                    setSavedOwner(data);
                }
            }
        } catch (err: any) {
            setError(err.message);
        }
    }

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        createOrUpdateOwnerDetails();
    };

    return (
        <div className="m-auto w-75">
            {error && <p className="alert alert-danger text-center">{error}</p>}
            {savedOwner && <p className="alert alert-success text-center">Owner created successfully. Find <Link
                to={`/owners/${savedOwner.id}`}>details</Link></p>}
            <form onSubmit={handleSubmit}>
                <div className="row mb-4">
                    <div className="col">
                        <div className="form-outline">
                            <input
                                type="text"
                                id="firstName"
                                className="form-control border"
                                value={formData.firstName}
                                onChange={handleChange}
                            />
                            <label className="form-label" htmlFor="firstName">First name</label>
                        </div>
                    </div>
                    <div className="col">
                        <div className="form-outline">
                            <input
                                type="text"
                                id="lastName"
                                className="form-control border"
                                value={formData.lastName}
                                onChange={handleChange}
                            />
                            <label className="form-label" htmlFor="lastName">Last name</label>
                        </div>
                    </div>
                </div>
                <div className="form-outline mb-4">
                    <input
                        type="text"
                        id="address"
                        className="form-control border"
                        value={formData.address}
                        onChange={handleChange}
                    />
                    <label className="form-label" htmlFor="address">Address</label>
                </div>
                <div className="form-outline mb-4">
                    <input
                        type="text"
                        id="city"
                        className="form-control border"
                        value={formData.city}
                        onChange={handleChange}
                    />
                    <label className="form-label" htmlFor="city">City</label>
                </div>
                <div className="form-outline mb-4">
                    <input
                        type="text"
                        id="telephone"
                        className="form-control border"
                        value={formData.telephone}
                        onChange={handleChange}
                    />
                    <label className="form-label" htmlFor="telephone">Telephone</label>
                </div>
                <button type="submit" className="btn btn-primary btn-block mb-4">
                    {isNew ? "Create Owner" : "Update Owner"}
                </button>
            </form>
        </div>
    );
}

export default OwnerEditor;
