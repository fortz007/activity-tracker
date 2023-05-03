package com.fortuneprogramming.activitytrackerapplication.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    private String dob;
    private String gender;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Task> taskSet;
}
