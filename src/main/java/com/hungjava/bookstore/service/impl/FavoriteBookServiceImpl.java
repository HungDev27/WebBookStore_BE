package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.repository.FavoriteBookRepository;
import com.hungjava.bookstore.service.FavoriteBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FavoriteBookServiceImpl implements FavoriteBookService {
    FavoriteBookRepository favoriteBookRepository;
}
