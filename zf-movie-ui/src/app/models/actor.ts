import { Movie } from './movie';

export interface ActorResponse {
    actorId: number;
    firstName: string;
    secondName: string;
    born: Date;
    placeOfBirth: string;
    description: string;
    movies?: Movie[];
}

export interface ActorRequest {
    actorId: number;
    firstName: string;
    secondName: string;
    born: Date;
    placeOfBirth: string;
    description: string;
}


export class Actor {
    piecieId: number;
    releasedDate: Date;
    title: string;
    posterUrl: string;
    director: string;
    genre: string;
    countryOfProduction: string;
    movies?: Movie[];

    constructor(actor: Partial<ActorResponse>) {
        Object.assign(this, actor);
    }
}

