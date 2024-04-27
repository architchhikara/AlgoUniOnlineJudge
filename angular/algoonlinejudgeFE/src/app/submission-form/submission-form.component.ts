import { Component, OnInit } from '@angular/core';
import { Problem } from '../models/Problem.interface';
import { SubmissionService } from '../services/submission.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-submission-form',
  templateUrl: './submission-form.component.html',
  styleUrls: ['./submission-form.component.less']
})
export class SubmissionFormComponent implements OnInit {
  supportedLanguages = ['C++', 'Java', 'Python']; // Example languages
  selectedLanguage = this.supportedLanguages[0];
  problem: Problem | null = null;
  submissionForm: FormGroup;

  constructor(
    private submissionService: SubmissionService,
    private route: ActivatedRoute
  ) {
    this.submissionForm = new FormGroup({
      code: new FormControl('')
    });
  }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.submissionForm = new FormGroup({
      code: new FormControl('')
    });
  }

  onSubmit() {
    if (this.submissionForm.valid) {
      const { code, language } = this.submissionForm.value;
      const problemId = this.problem?.id; // Ensure problem is fetched

      if (problemId) {
        this.submissionService.submitCode(code, language, problemId)
          .subscribe({
            next: (submission) => console.log('Submission successful:', submission),
            error: (error) => console.error('Submission failed:', error)
          });
      }
    }
  }

}
