import { Component, OnInit, Input } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Actor } from 'src/app/models/actor';
import { ActorService } from 'src/app/services/actor.service';
import { distinctUntilChanged, debounceTime, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-search-actors',
  templateUrl: './search-actors.component.html',
  styleUrls: ['./search-actors.component.scss']
})
export class SearchActorsComponent implements OnInit {

  @Input() selectedMovieActors: Actor[];
  actors$: Observable<Actor[]>;
  private searchTerms = new Subject<string>();

  constructor(private actorService: ActorService) { }

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {

    this.actors$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(500),
      // ignore new term if same as previous term
      distinctUntilChanged(),
      // switch to new search observable each time the term changes
      switchMap((term: string) => this.actorService.searchActors(term)),
    );
  }

  doesActorExistInSelectedMovie(foundActor: Actor): boolean {
    return this.selectedMovieActors.filter(actor => actor.actorId == foundActor.actorId).length > 0
  }

}
