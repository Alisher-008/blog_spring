package com.alish.blog_spring.repositories;

import com.alish.blog_spring.models.Post;
import com.alish.blog_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByTitle(String title);

    List<Post> findAllByAuthor(User user);
}
