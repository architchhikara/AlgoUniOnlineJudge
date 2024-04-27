import { RouterModule, Routes } from '@angular/router';
import { ProblemListComponent } from './problem-list/problem-list.component';
import { ProblemDetailsComponent } from './problem-details/problem-details.component';
import { SubmissionFormComponent } from './submission-form/submission-form.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  { path: '', redirectTo: '/problems', pathMatch: 'full' }, // Example default route
  { path: 'problems', component: ProblemListComponent },
  { path: 'problems/:id', component: ProblemDetailsComponent },
  { path: 'submit/:id', component: SubmissionFormComponent }
  // ... more routes
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule] // <-- Add this line
})
export class AppRoutingModule { }
