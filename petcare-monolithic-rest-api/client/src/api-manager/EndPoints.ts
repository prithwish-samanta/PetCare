export const EndPoints = {
    LIST_OF_OWNERS: (lastname: string) => "/owners?lastName=" + lastname,
    GET_OWNER_BY_ID: (ownerId: number) => `/owners/${ownerId}`,
    CREATE_OWNER: () => "/owners",
    UPDATE_OWNER: (ownerId: number) => `/owners/${ownerId}`,
    ERROR: () => "/oops"
}