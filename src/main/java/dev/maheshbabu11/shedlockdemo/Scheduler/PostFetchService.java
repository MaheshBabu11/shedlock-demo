package dev.maheshbabu11.shedlockdemo.Scheduler;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
class PostFetchService {

    final PostRepository postRepository;

    PostFetchService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    record Post(Long userId, Long id, String title, String body) {
    }


    void fetchPosts() {
        RestClient client = RestClient.create();
        Post response = client.get().uri("https://jsonplaceholder.typicode.com/posts/1").retrieve().body(
                Post.class);
        if (null != response) {
            Posts posts = new Posts();
            posts.setPostUid(response.id());
            posts.setPostTitle(response.title());
            posts.setPostContent(response.body());
            postRepository.save(posts);
        }
    }
}
