export class ApiMethods {
    static async apiRequest(method: string, url: string, body?: any) {
        const options: RequestInit = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json",
            },
        };

        if (body && (method === "POST" || method === "PUT")) {
            options.body = JSON.stringify(body);
        }

        try {
            const response = await fetch(url, options);

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.error || "Something went wrong");
            }

            return response.json();
        } catch (error) {
            console.error("API Request Failed:", error);
            throw error;
        }
    }

    static get(url: string) {
        return this.apiRequest('GET', url);
    }

    static post(url: string, data: {}) {
        return this.apiRequest('POST', url, data);
    }

    static put(url: string, data: {}) {
        return this.apiRequest('PUT', url, data);
    }

    static delete(url: string) {
        return this.apiRequest('DELETE', url);
    }
}