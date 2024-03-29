package br.com.reinaldo.Mantovanitechblog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reinaldo.Mantovanitechblog.payload.PostDto;
import br.com.reinaldo.Mantovanitechblog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	//create blog post rest api 
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED); 
	}
	
	//Get all posts
	@GetMapping
	public List<PostDto> getAllPosts() {
		return postService.getAllPosts();
	}
	
	//Get post by id
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(postService.getPostById(id));
	}
	
	//Update post
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {
		
		PostDto postResponse = postService.updatePost(postDto, id);
		
		return new ResponseEntity<>(postResponse, HttpStatus.OK);
	}
 }
