package com.example.challenge.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select "
            + "distinct a "
            + "from Article a "
            + "left outer join SiteUser u1 on a.author=u1 "
            + "where "
            + "   a.subject like %:kw% "
            + "   or a.content like %:kw% "
            + "   or u1.username like %:kw% ")
    List<Article> findAllByKeyword(@Param("kw") String kw);
}
