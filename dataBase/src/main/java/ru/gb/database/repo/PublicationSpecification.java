package ru.gb.database.repo;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.database.model.Publication;

public final class PublicationSpecification {

    public static Specification<Publication> titleLike(String pattern) {
        return (root, query, builder) -> builder.like(root.get("title"), "%" + pattern + "%");
    }

    public static Specification<Publication> byMenuItem(String menuItem) {
        return (root, query, builder) -> builder.equal(root.get("item"), menuItem);
    }

    public static Specification<Publication> byAuthorName(String authorName) {
        return (root, query, builder) -> builder.equal(root.get("author").get("username"), authorName);
    }
}
