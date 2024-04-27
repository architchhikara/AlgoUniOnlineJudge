import { Component, OnInit } from '@angular/core';
import { Problem } from '../models/Problem.interface';
import { ProblemService } from '../services/problem.service';

import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-problem-list',
  templateUrl: './problem-list.component.html',
  styleUrls: ['./problem-list.component.less']
})
export class ProblemListComponent implements OnInit {
  problems: Problem[] = [];
  filteredProblems: Problem[] = [];
  difficultyFilter: string = '';
  selectedDifficulty: string = '';

  constructor(private problemService: ProblemService, private router: Router, private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.problemService.getAllProblems().subscribe(problems => {
      this.problems = problems;
      this.filteredProblems = problems;
    });
  }

  loadProblems() {
    if (this.difficultyFilter) { // Check if value exists
      this.problemService.getProblems(this.difficultyFilter)
        .subscribe(problems => this.problems = problems);
    } else {
      this.problemService.getAllProblems()
        .subscribe(problems => this.problems = problems);
    }
  }


  onFilterChange(difficulty: string) {
    this.selectedDifficulty = difficulty;

    if (difficulty === '') {
      this.filteredProblems = this.problems;
    } else {
      this.filteredProblems = this.problems.filter(problem => problem.difficulty === difficulty);
    }

    this.loadProblems();
    this.router.navigate(['/problems', this.activatedRoute.snapshot.params['id']]);
  }
}
