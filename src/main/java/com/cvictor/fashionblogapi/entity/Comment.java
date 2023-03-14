package com.cvictor.fashionblogapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentBody;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

}
