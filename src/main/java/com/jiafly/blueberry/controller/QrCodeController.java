package com.jiafly.blueberry.controller;

import com.jiafly.blueberry.common.utils.QrCodeUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 二维码
 *
 * @author dongxie
 */
@RestController
@RequestMapping(path = "/qrcode")
public class QrCodeController {

    @GetMapping(path = "/create")
    public void image(HttpServletResponse response, @RequestParam("content") String content) {
        try {
            BufferedImage bufferedImage = QrCodeUtils.createImage(content, null, false);
            responseImage(response, bufferedImage);
        } catch (Exception e) {
            // 异常自行处理，应用程序切忌直接打印堆栈日志，难定位
            e.printStackTrace();
        }
    }

    /**
     * 设置 可通过postman 或者浏览器直接浏览
     *
     * @param response      response
     * @param bufferedImage bufferedImage
     * @throws Exception e
     */
    public void responseImage(HttpServletResponse response, BufferedImage bufferedImage) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
        ImageIO.write(bufferedImage, "jpeg", imageOutput);
        InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        OutputStream outputStream = response.getOutputStream();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }
}
