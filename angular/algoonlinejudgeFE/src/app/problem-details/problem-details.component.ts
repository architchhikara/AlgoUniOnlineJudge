import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Problem } from '../models/Problem.interface';
import { ProblemService } from '../services/problem.service';
import { switchMap } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-problem-details',
  templateUrl: './problem-details.component.html',
  styleUrls: ['./problem-details.component.less']
})
export class ProblemDetailsComponent implements OnInit {
  problem: Problem | undefined;
  submissionForm: FormGroup;

  constructor(
    private activatedRoute: ActivatedRoute,
    private problemService: ProblemService
  ) {
    this.submissionForm = new FormGroup({
      code: new FormControl('')
    });
  }

  ngOnInit(): void {
    const id = parseInt(this.activatedRoute.snapshot.paramMap.get('id') ?? '');
    this.problemService.getProblem(id).subscribe(problem => this.problem = problem);

    this.submissionForm = new FormGroup({
      code: new FormControl('')
    });
  }
}
