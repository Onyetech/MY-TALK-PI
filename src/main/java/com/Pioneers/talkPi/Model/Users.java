package com.Pioneers.talkPi.Model;

import lombok.*;

import javax.persistence.*;


@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, length = 30)
    private String fullName;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 100)
    private String passwordOne;

    @Column(nullable = false, length = 100)
    private String passwordTwo;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//
//    private List<Post> posts = new ArrayList<>();

}
