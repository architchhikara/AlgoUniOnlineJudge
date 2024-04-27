import { Submission } from "./Submission.interface";

export interface Problem {
    id: number;
    title: string;
    description: string;
    difficulty: 'Easy' | 'Medium' | 'Hard';
    constraints: string; // You might want to change the type here
    // ... potentially other fields like input/output examples
}

export interface ProblemResponse {
    problems: Problem[];
    totalProblems: number;
  }
  
  export interface ProblemDetails {
    problem: Problem;
    submissions: Submission[];
  }