package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository;

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        User user = userRepository.findById(userId).get();
        Blog blog = new Blog(title,content,user);
        userRepository.save(user);
        user.getBlogList().add(blog);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
