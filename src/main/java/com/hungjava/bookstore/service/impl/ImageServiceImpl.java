package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.repository.ImageRepository;
import com.hungjava.bookstore.service.ImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;
}
