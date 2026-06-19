package com.hungjava.bookstore.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    // 1. Method dùng chung để UPLOAD 1 ẢNH
    public String uploadFile(MultipartFile file, String folderName) {
        try {
            Map<String, Object> params = ObjectUtils.asMap(
                    "upload_preset", "bookstore", "folder", folderName
            );
            @SuppressWarnings("unchecked")
            Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(file.getBytes(), params);
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload 1 file lên Cloudinary: " + e.getMessage());
        }
    }

    // 2. Method dùng chung để UPLOAD NHIỀU ẢNH LÚC
    public List<String> uploadMultipleFiles(List<MultipartFile> files, String folderName) {
        List<String> urls = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    urls.add(uploadFile(file, folderName)); // Gọi lại method 1
                }
            }
        }
        return urls;
    }

    // 3. Method dùng chung để XÓA ẢNH TRÊN MÂY (Tránh rác bộ nhớ)
    public void deleteFile(String publicId) {
        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi xóa file trên Cloudinary: " + e.getMessage());
        }
    }
    
    /**
     * Hàm bổ trợ: Trích xuất public_id từ đường link URL của Cloudinary
     * Ví dụ URL: https://res.cloudinary.com/dvwgrebm8/image/upload/v1718812345/books/anh1_abc123.jpg
     * Kết quả trả về sẽ là: "books/anh1_abc123"
     */
    public String extractPublicIdFromUrl(String url) {
        if (url == null || !url.contains("upload/")) {
            return null;
        }
        try {
            // Cắt chuỗi lấy phần nằm sau chữ "upload/vxxxxxxxx/"
            String remaining = url.substring(url.indexOf("upload/") + 7);
            if (remaining.contains("/")) {
                // Bỏ phần số phiên bản (version) nếu có, ví dụ: "v1718812345/"
                remaining = remaining.substring(remaining.indexOf("/") + 1);
            }
            // Bỏ đuôi định dạng file (.jpg, .png)
            return remaining.substring(0, remaining.lastIndexOf("."));
        } catch (Exception e) {
            return null;
        }
    }
}
