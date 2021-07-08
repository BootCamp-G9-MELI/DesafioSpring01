package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.NewPromoPostDTO;
import br.com.meli.socialmeli.dto.PostListPromoDTO;
import br.com.meli.socialmeli.dto.PostFromFollowedDTO;
import br.com.meli.socialmeli.dto.PostsFromFollowedDTO;
import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.entity.PromoPost;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.repository.PostRepository;
import br.com.meli.socialmeli.repository.PromoPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PromoPostRepository promoPostRepository;
    private final FollowerService followerService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService, 
                       PromoPostRepository promoPostRepository, FollowerService followerService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.promoPostRepository = promoPostRepository;
        this.followerService = followerService;
    }


    public void newPost(NewPostDTO newPostDTO) {
        User user = userService.getUserById(newPostDTO.getUserId());
        Long postId = (long) postRepository.getList().size()+1;
        Post post = NewPostDTO.convert(user, postId, newPostDTO);
        postRepository.add(post);
    }

    public List<PromoPost> getListPromoPostById(long id){
        return promoPostRepository.getList().stream().filter(promoPost -> promoPost.getId() == id).collect(Collectors.toList());
    }

    public PostListPromoDTO getList(long id) {
        User user = userService.getUserById(id);
        List<PromoPost> promotionalPosts = getListPromoPostById(id);
        return new PostListPromoDTO(user.getid(), user.getUsername(), promotionalPosts);
    }
    
    public void newPromoPost(NewPromoPostDTO newPromoPostDTO) {
    		User user = userService.getUserById(newPromoPostDTO.getUserId());
    		PromoPost promoPost = new PromoPost(newPromoPostDTO, user);
    		promoPost.setId(promoPostRepository.getList().size()+1);
    		promoPostRepository.add(promoPost);
    }

    public PostsFromFollowedDTO postsFromFollowedLastTwoWeeks(Long userId) {
        User user = userService.getUserById(userId);
        List<Follower> listOfFollowed = followerService.getFollowedByUserId(user.getid());
        List<Post> listOfFollowedPostsLastTwoWeeks = this.getPostsOfFollowedLastTwoWeeks(listOfFollowed);
        List<PostFromFollowedDTO> postFromFollowedDTOList = new ArrayList<>();

        listOfFollowedPostsLastTwoWeeks
                .forEach(p ->
                    postFromFollowedDTOList.add(PostFromFollowedDTO.convert(p))
                );
        return PostsFromFollowedDTO.convert(user.getid(), postFromFollowedDTOList);
    }

    private List<Post> getPostsOfFollowedLastTwoWeeks(List<Follower> listOfFollowed) {
        List<Post> postList = postRepository.getList();
        List<Post> postListFromFollowedLastTwoWeeks = new ArrayList<>();
        LocalDate today = LocalDate.now();

        listOfFollowed
                .forEach(f -> postList.stream()
                        .filter(p -> {
                            if (f.getFollowed() == p.getUser().getid()){
                                long weeks = ChronoUnit.WEEKS.between(p.getDate(), today);
                                return weeks < 2;
                            }
                            return false;
                        })
                        .forEach(postListFromFollowedLastTwoWeeks::add));

        return postListFromFollowedLastTwoWeeks;
    }
}
