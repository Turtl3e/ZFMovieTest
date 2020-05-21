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
    posterUrl: string;
}


export class Actor {
    actorId: number;
    firstName: string;
    secondName: string;
    born: Date;
    placeOfBirth: string;
    description: string;
    posterUrl: string;
    movies?: Movie[];

    constructor(actor: Partial<ActorResponse>) {
        Object.assign(this, actor);
    }
}

