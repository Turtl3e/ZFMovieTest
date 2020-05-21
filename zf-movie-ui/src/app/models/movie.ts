import { Actor } from './actor';

export interface MovieResponse {
    pieceId: number;
    releaseDate: Date;
    title: string;
    description: string;
    posterUrl: string;
    director: string;
    genre: string;
    countryOfProduction: string;
    actors?: Actor[];
}

export interface MovieRequest {
    pieceId: number;
    releaseDate: Date;
    title: string;
    description: string;
    posterUrl: string;
    director: string;
    genre: string;
    countryOfProduction: string;
}


export class Movie {
    pieceId: number;
    releaseDate: Date;
    title: string;
    description: string;
    posterUrl: string;
    director: string;
    genre: string;
    countryOfProduction: string;
    actors?: Actor[];

    constructor(movie: Partial<MovieResponse>) {
        Object.assign(this, movie);
    }
}

