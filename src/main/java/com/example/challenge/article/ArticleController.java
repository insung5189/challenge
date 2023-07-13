package com.example.challenge.article;

import com.example.challenge.user.SiteUser;
import com.example.challenge.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;
    private final UserService userService;

//    @GetMapping("/test")
//    @ResponseBody
//    public String test () {
//        return "리스폰스바디 테스트";
//    }


    @GetMapping("/list")
    public String articleList (Model model, @RequestParam(value = "kw", defaultValue = "") String kw, Principal principal) {
        List<Article> articleList = this.articleService.getArticlesByKeyword(kw);
        model.addAttribute("articleList", articleList);
        model.addAttribute("searchKeyword", kw);
        return "article_list";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String articleCreate (ArticleForm articleForm) {
        return "article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String articleCreatePost (ArticleForm articleForm, Principal principal) {
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.articleService.create(articleForm.getSubject(), articleForm.getContent(), siteUser);
        return "redirect:/article/list";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail (@PathVariable Integer id, Model model) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String articleModify (ArticleForm articleForm, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        articleForm.setSubject(article.getSubject());
        articleForm.setContent(article.getContent());

        return "article_form";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String articleModifyPost (ArticleForm articleForm, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        this.articleService.modify(article, articleForm.getSubject(), articleForm.getContent());
        return "redirect:/article/list";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String articleDelete(@PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        this.articleService.delete(article);
        return "redirect:/";
    }
}
