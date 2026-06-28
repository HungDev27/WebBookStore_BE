package com.hungjava.bookstore.service.impl;

import com.hungjava.bookstore.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailServiceImpl implements EmailService {

    JavaMailSender mailSender;

    static final String COMPANY_NAME = "BookStore";

    @Override
    public void sendActivationEmail(String toEmail,String username,String activationLink) {
        System.out.println("toEmail = " + toEmail);
        System.out.println("username = " + username);
        System.out.println("activationLink = " + activationLink);
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper =new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(toEmail);
            helper.setSubject("📚 Xác minh tài khoản BookStore");
            String html = """
        <!DOCTYPE html>
               <html lang="vi">

               <head>
                   <meta charset="UTF-8">
                   <title>BookStore</title>
               </head>

               <body style="margin:0;padding:30px;background:#f4f6f9;font-family:Arial,sans-serif;">
                   <table width="100%%" cellpadding="0" cellspacing="0">
                       <tr>
                           <td align="center">

                               <table width="650" cellpadding="0" cellspacing="0"
                                   style="background:#fff;border-radius:10px;overflow:hidden;box-shadow:0 3px 10px rgba(0,0,0,.1);">

                                   <tr>
                                       <td align="center" style="padding:40px;background:linear-gradient(90deg,#2E86DE,#5DADE2);">
                                           <div
                                               style="display:inline-block;padding:12px 25px;background:#fff;border-radius:8px;font-size:28px;font-weight:bold;color:#2E86DE;">
                                               📚 BookStore</div>
                                           <h2 style="color:#fff;margin-top:25px;">Chào mừng bạn đến với <b>BookStore</b></h2>
                                       </td>
                                   </tr>

                                   <tr>
                                       <td style="padding:40px;">
                                           <h2 style="text-align:center;color:#333;">Xác Minh Tài Khoản Của Bạn</h2>

                                           <p style="font-size:15px;color:#666;line-height:28px;text-align:center;">
                                               Xin chào <b>%s</b><br><br>
                                               Cảm ơn bạn đã đăng ký tài khoản tại <b>BookStore</b>.<br>
                                               Để bắt đầu mua sách, vui lòng xác minh email bằng cách nhấn nút bên dưới.
                                           </p>

                                           <div style="text-align:center;margin:40px 0;">
                                               <a href="%s"
                                                   style="background:#2E86DE;color:#fff;padding:16px 35px;text-decoration:none;border-radius:30px;font-size:16px;font-weight:bold;">📧
                                                   XÁC MINH EMAIL</a>
                                           </div>

                                           <div style="border-left:5px solid #2E86DE;background:#f8f9fa;padding:20px;margin-top:30px;">
                                               <p>Nếu nút trên không hoạt động, hãy sao chép đường dẫn sau:</p>
                                               <div
                                                   style="background:#fff;border:1px solid #ddd;padding:10px;word-break:break-all;font-size:13px;">
                                                   %s</div>
                                           </div>

                                           <div
                                               style="margin-top:30px;padding:18px;background:#FFF8E5;border:1px solid #FFD54F;border-radius:5px;">
                                               <b>⚠ Lưu ý</b>
                                               <p>Liên kết chỉ có hiệu lực trong <b>24 giờ</b>. Nếu bạn không đăng ký tài khoản tại
                                                   <b>BookStore</b>, hãy bỏ qua email này.</p>
                                           </div>

                                           <div
                                               style="margin-top:40px;padding:25px;background:linear-gradient(90deg,#5DADE2,#85C1E9);border-radius:8px;text-align:center;color:#fff;">
                                               <h3>📚 Điều tuyệt vời đang chờ bạn tại BookStore</h3>
                                               <table width="100%%">
                                                   <tr align="center">
                                                       <td>📖<br>Kho sách đa dạng</td>
                                                       <td>🚚<br>Giao hàng nhanh</td>
                                                       <td>💳<br>Thanh toán an toàn</td>
                                                       <td>⭐<br>Ưu đãi mỗi ngày</td>
                                                   </tr>
                                               </table>
                                           </div>

                                       </td>
                                   </tr>

                                   <tr>
                                       <td style="background:#2C3E50;padding:35px;text-align:center;color:#ddd;">
                                           <h2 style="color:#fff;">📚 BookStore</h2>
                                           <p>Đọc sách mỗi ngày - Mở rộng tri thức</p>
                                           <hr style="border:none;border-top:1px solid #555;">
                                           <p style="font-size:13px;">Email này được gửi tự động, vui lòng không trả lời.</p>
                                           <p style="font-size:12px;">© 2026 BookStore. All Rights Reserved.</p>
                                       </td>
                                   </tr>

                               </table>

                           </td>
                       </tr>
                   </table>
               </body>

               </html>
        """.formatted(
                    username,
                    activationLink,
                    activationLink
            );
            helper.setText(html, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Không thể gửi email.", e);
        }
    }
}
