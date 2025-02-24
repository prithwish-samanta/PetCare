import {useEffect, useState} from "react";
import {ApiManager} from "../api-manager/ApiManager.ts";

function ErrorPage() {
    const [error, setError] = useState<string | null>(null);
    useEffect(() => {
        const invokeApiError = async () => {
            try {
                await ApiManager.invokeApiError();
            } catch (err: any) {
                setError(err.message);
            }
        };

        invokeApiError();
    }, [])
    return (
        <section className="container my-3">
            <h2 className="text-center text-danger mb-3">Something went wrong!...</h2>
            {error && <p className="alert alert-danger text-center">{error}</p>}
        </section>
    );
}

export default ErrorPage;