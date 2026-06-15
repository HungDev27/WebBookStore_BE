package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.repository.DeliveryRepository;
import com.hungjava.bookstore.service.DeliveryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeliveryServiceImpl implements DeliveryService {
    DeliveryRepository deliveryRepository;
}
