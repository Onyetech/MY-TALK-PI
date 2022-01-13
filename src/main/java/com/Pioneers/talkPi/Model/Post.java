package com.Pioneers.talkPi.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(nullable = false)
    private String postCategory;

    @Column(nullable = false, length = 200)
    private String postTitle;

    @Column(nullable = false, length = 2000)
    private String postBody;

    @Temporal(TemporalType.TIME)
    @Column(length = 50)
    private Date postDate = new Date();


}
