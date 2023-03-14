package com.cvictor.fashionblogapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LikeId;
    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
