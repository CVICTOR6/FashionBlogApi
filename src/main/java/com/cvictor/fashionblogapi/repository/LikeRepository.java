package com.cvictor.fashionblogapi.repository;

import com.cvictor.fashionblogapi.entity.Like;
import com.cvictor.fashionblogapi.entity.Post;
import com.cvictor.fashionblogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Transactional
    void deleteLikeByPostAndUser(Post post, User user);

    List<Like> findAllByPost(Post post);

    void deleteAllByPost(Post post);
}
