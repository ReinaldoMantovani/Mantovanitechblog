package br.com.reinaldo.Mantovanitechblog.service;

import java.util.List;

import br.com.reinaldo.Mantovanitechblog.payload.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto);
	
	List<PostDto> getAllPosts();
	
	PostDto getPostById(Long id);
	
	PostDto updatePost(PostDto postDto,Long id);
}
