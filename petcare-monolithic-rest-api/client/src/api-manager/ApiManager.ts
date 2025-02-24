import {EndPoints} from "./EndPoints.ts";
import {ApiMethods} from "./ApiMethods.ts";

const BASE_URL = 'http://localhost:8080/petcare/api/v1';

export class ApiManager {
    static getOwners = (lastname: string) => {
        const url = BASE_URL + EndPoints.LIST_OF_OWNERS(lastname);
        return ApiMethods.get(url);
    }
}