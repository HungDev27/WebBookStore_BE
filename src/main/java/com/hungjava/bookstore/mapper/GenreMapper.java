package com.hungjava.bookstore.mapper;

import com.hungjava.bookstore.dto.response.GenreResponse;
import com.hungjava.bookstore.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    public GenreResponse toGenreResponse(Genre genre) {
        return GenreResponse.builder()
                .id(genre.getId())
                .name(genre.getName())
                .createdAt(genre.getCreatedAt())
                .updatedAt(genre.getUpdatedAt())
                .build();
    }
}
