package br.com.reinaldo.Mantovanitechblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.reinaldo.Mantovanitechblog.entities.Post;


public interface PostRepository extends JpaRepository<Post, Long>{

}
