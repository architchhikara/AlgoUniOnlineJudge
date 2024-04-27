import { Injectable } from '@angular/core';

import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import {  } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Problem } from '../models/Problem.interface';

@Injectable({ providedIn: 'root' })
export class ProblemService {
  private apiUrl = 'http://localhost:8090/api/problems';

  constructor(private http: HttpClient) { }

  getProblems(difficulty?: string): Observable<Problem[]> {
    let params = new HttpParams();
    if (difficulty) {
      params = params.set('difficulty', difficulty);
    }

    return this.http.get<Problem[]>(this.apiUrl, { params })
      .pipe(
        catchError(this.handleError)
      );
  }

  getAllProblems(): Observable<Problem[]> {
    return this.http.get<Problem[]>(this.apiUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  getProblem(id: number): Observable<Problem> {
    return this.http.get<Problem>(`${this.apiUrl}/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    // Handle the error in a way that's suitable for your UI
    // You could display an error message, log it or potentially retry

    console.error("Problem Service Error: ", error);

    // Rethrow to let the caller handle it
    return throwError(() => new Error('Something went wrong fetching data.'));
  }
}

