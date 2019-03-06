package app.controllers;

import app.database.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/forum")
public class ForumController {
    private final PostDao postDao;

    @Autowired
    public ForumController(@Qualifier("simplePostDao") PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getForum(ModelMap modelMap) {
        modelMap.put("posts", postDao.getAllPosts());
        return "forum";
    }

    @RequestMapping(method = RequestMethod.POST, params = {"text", "author"})
    public String createPost(
            ModelMap modelMap,
            @RequestParam("text") String text,
            @RequestParam("author") String author) {
        postDao.createPost(text, author);
        return getForum(modelMap);
    }

}
