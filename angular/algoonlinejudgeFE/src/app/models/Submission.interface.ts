export interface Submission {
    id: number;
    problemId: number; 
    code: string;
    language: string;
    verdict: 'Accepted' | 'Wrong Answer' | 'Time Limit Exceeded' | 'Runtime Error' | 'Compilation Error'; 
    executionTime?: number; 
    // ... potentially other fields like timestamps 
}
