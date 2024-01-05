package br.com.reinaldo.Mantovanitechblog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.reinaldo.Mantovanitechblog.entities.Post;
import br.com.reinaldo.Mantovanitechblog.exception.ResourceNotFoundException;
import br.com.reinaldo.Mantovanitechblog.payload.PostDto;
import br.com.reinaldo.Mantovanitechblog.repository.PostRepository;
import br.com.reinaldo.Mantovanitechblog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepository;
	
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}



	@Override
	public PostDto createPost(PostDto postDto) {
		
		//Covert Dto to Entity 	
		
		Post post = mapToEntity(postDto);
		Post newPost =  postRepository.save(post);
		
		//Convert entity to DTO
		PostDto postResponse = mapToDto(newPost);
		
		return postResponse;
	}

	@Override
	public List<PostDto> getAllPosts() {
	   
		List<Post> posts = postRepository.findAll();
		
		return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
	}
	
	private PostDto mapToDto(Post post) {
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitulo(post.getTitulo());
		postDto.setDescricao(post.getDescricao());
		postDto.setConteudo(post.getConteudo());
		
		return postDto;
		
	}
		
	private Post mapToEntity(PostDto postDto) {
		Post post = new Post();
		post.setTitulo(postDto.getTitulo());
		post.setDescricao(postDto.getDescricao());
		post.setConteudo(postDto.getConteudo());
		
		return post;
	}

	@Override
	public PostDto getPostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		
		return mapToDto(post);
	}



	@Override
	public PostDto updatePost(PostDto postDto, Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		
		post.setTitulo(postDto.getTitulo());
		post.setDescricao(postDto.getDescricao());
		post.setConteudo(postDto.getConteudo());
		
		Post updatePost = postRepository.save(post);
		
		return mapToDto(updatePost);
	}
}
