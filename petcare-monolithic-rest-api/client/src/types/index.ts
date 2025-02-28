interface IBaseEntity {
    id: number | null;
}

interface INamedEntity extends IBaseEntity {
    name: string;
}

interface IPerson extends IBaseEntity {
    firstName: string;
    lastName: string;
}

export interface IPetType extends INamedEntity {
}

export interface IVisit extends IBaseEntity {
    date: string;
    description: string;
}

export interface IPet extends INamedEntity {
    birthDate: string;
    petType: IPetType;
    visits: IVisit[];
}

export interface IOwner extends IPerson {
    address: string;
    city: string;
    telephone: string;
    pets: IPet[];
}

export interface ISpecialty extends INamedEntity {
}

export interface IVet extends IPerson {
    specialties: ISpecialty[];
}