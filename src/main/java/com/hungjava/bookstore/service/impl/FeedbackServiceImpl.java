package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.repository.FeedbackRepository;
import com.hungjava.bookstore.service.FeedbackService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FeedbackServiceImpl implements FeedbackService {
    FeedbackRepository feedbackRepository;
}
