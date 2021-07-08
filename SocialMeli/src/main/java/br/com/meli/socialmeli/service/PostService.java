package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.PostFromFollowedDTO;
import br.com.meli.socialmeli.dto.PostsFromFollowedDTO;
import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final FollowerService followerService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService, FollowerService followerService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.followerService = followerService;
    }

    public void newPost(NewPostDTO newPostDTO) {
        User user = userService.getUserById(newPostDTO.getUserId());
        Long postId = (long) postRepository.getList().size()+1;
        Post post = NewPostDTO.convert(user, postId, newPostDTO);
        postRepository.add(post);
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
