package com.algouni.algouniOJ.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    // TODO Do NOT store in plain text - hash this!
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Submission> submissions;

    @ManyToMany
    @JoinTable(name = "users_solved_problems", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "problem_id"))
    List<Problem> solvedProblems;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Problem> getSolvedProblems() {
        return solvedProblems;
    }

    public void setSolvedProblems(List<Problem> solvedProblems) {
        this.solvedProblems = solvedProblems;
    }

    // Getters, setters, constructors
}
