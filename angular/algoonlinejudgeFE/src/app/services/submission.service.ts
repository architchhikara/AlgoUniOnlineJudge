import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Submission } from '../models/Submission.interface';

@Injectable({ providedIn: 'root' })
export class SubmissionService {
  private apiUrl = 'http://localhost:8090/api/submissions';

  constructor(private http: HttpClient) { }

  submitCode(code: string, language: string, problemId: number): Observable<Submission> {
    const submissionData = { code, language, problemId };
    return this.http.post<Submission>(this.apiUrl, submissionData)
      .pipe(
        catchError(this.handleError)
      );
  }

  getUserSubmissions(): Observable<Submission[]> {
    // Assuming the API is designed for the logged-in user 
    return this.http.get<Submission[]>(this.apiUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Add more methods as needed: getSubmissionById, etc.

  private handleError(error: HttpErrorResponse) {
    // Handle errors appropriately for your UI
    console.error("Submission Service Error: ", error);
    return throwError(() => new Error('Something went wrong with the submission.'));
  }
}
