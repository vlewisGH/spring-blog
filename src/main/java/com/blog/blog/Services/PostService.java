package com.blog.blog.Services;

import com.blog.blog.models.Post;
import com.blog.blog.reposititories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postDao;

    public PostService(PostRepository postDao){
        this.postDao = postDao;
    }

    public void seedDb(){
        postDao.save(new Post(0,"Whats up!","Twenty-five years and my life is still\n" +
                "Trying to get up that great big hill of hope\n" +
                "For a destination"));

        postDao.save(new Post(1,"Africa","It's gonna take a lot to take me away from you\n" +
                "There's nothing that a hundred men or more could ever do\n" +
                "I bless the rains down in Africa\n" +
                "Gonna take some time to do the things we never had"));

        postDao.save(new Post(2,"Stairway to Heaven","There's a lady who's sure\n" +
                "All that glitters is gold\n" +
                "And she's buying a stairway to heaven\n" +
                "When she gets there she knows\n" +
                "If the stores are all closed\n" +
                "With a word she can get what she came for\n" +
                "Oh oh oh oh and she's buying a stairway to heaven"));

        postDao.save(new Post(3,"Dont Stop Believing","Just a small town girl\n" +
                "Livin' in a lonely world\n" +
                "She took the midnight train goin' anywhere"));
    }

    public List<Post> getAll(){
        return postDao.findAll();
    }

    public Post getPostById(long id){
        return postDao.findOne(id);
    }

    public void addPost(Post post){
        postDao.save(post);
    }

    public void removePostById(Long id){
        postDao.delete(id);
    }
}
