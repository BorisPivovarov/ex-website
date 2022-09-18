package ru.boris.ex_website_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.boris.ex_website_api.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {


}
