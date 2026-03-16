package com.hanrry.studytracker.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "study_sessions")
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(length = 200)
    private String notes;

    @Column(name = "studied_at", nullable = false)
    private LocalDateTime studiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public StudySession(){
    }

    public StudySession(Integer durationMinutes, String notes, LocalDateTime studiedAt, User user, Lesson lesson) {
        this.durationMinutes = durationMinutes;
        this.notes = notes;
        this.studiedAt = studiedAt;
        this.user = user;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getStudiedAt() {
        return studiedAt;
    }

    public void setStudiedAt(LocalDateTime studiedAt) {
        this.studiedAt = studiedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudySession studySession)) return false;
        return id != null && id.equals(studySession.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
