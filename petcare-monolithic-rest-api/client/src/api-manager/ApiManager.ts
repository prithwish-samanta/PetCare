import {EndPoints} from "./EndPoints.ts";
import {ApiMethods} from "./ApiMethods.ts";
import {IOwner} from "../types";

const BASE_URL = 'http://localhost:8080/petcare/api/v1';

export class ApiManager {
    static getOwners = (lastname: string) => {
        const url = BASE_URL + EndPoints.LIST_OF_OWNERS(lastname);
        return ApiMethods.get(url);
    }

    static getOwnerById(ownerId: number) {
        const url = BASE_URL + EndPoints.GET_OWNER_BY_ID(ownerId);
        return ApiMethods.get(url);
    }

    static createOwner = (owner: IOwner) => {
        const url = BASE_URL + EndPoints.CREATE_OWNER();
        return ApiMethods.post(url, owner);
    }

    static updateOwner = (ownerId: number, owner: IOwner) => {
        const url = BASE_URL + EndPoints.UPDATE_OWNER(ownerId);
        return ApiMethods.put(url, owner);
    }

    static invokeApiError = () => {
        const url = BASE_URL + EndPoints.ERROR();
        return ApiMethods.get(url);
    }
}