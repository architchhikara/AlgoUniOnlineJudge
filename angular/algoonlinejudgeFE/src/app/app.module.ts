import { NgModule } from '@angular/core';
import { BrowserModule, bootstrapApplication } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { ProblemDetailsComponent } from './problem-details/problem-details.component';
import { ProblemListComponent } from './problem-list/problem-list.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ProblemService } from './services/problem.service';
import { SubmissionService } from './services/submission.service';
import { SubmissionFormComponent } from './submission-form/submission-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
    declarations: [
        ProblemDetailsComponent,
        ProblemListComponent,
        SubmissionFormComponent,

    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        RouterModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatListModule,
        MatCardModule,
        MatToolbarModule,
        ReactiveFormsModule
    ],
    providers: [
        ProblemService,
        SubmissionService,
        HttpClient
    ],
})
export class AppModule { }

bootstrapApplication(AppComponent);
