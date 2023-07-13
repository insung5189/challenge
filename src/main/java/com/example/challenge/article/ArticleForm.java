package com.example.challenge.article;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {

    @NotEmpty(message = "필수항목")
    private String subject;

    @NotEmpty(message = "필수항목")
    private String content;
}
