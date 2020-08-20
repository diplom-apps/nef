package ru.server.nef.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.server.nef.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
