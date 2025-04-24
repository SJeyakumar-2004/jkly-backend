package com.example.Link.service;

import com.example.Link.entity.QRCodeEntity;
import com.example.Link.repository.QRCodeRepository;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QRCodeService 
{

    @Autowired
    private QRCodeRepository qrCodeRepository;
    
    public List<QRCodeEntity> getAll()
    {
    	return qrCodeRepository.findAll();
    }

    public QRCodeEntity generateAndSaveQRCode(String url) throws WriterException, IOException 
    {
        BufferedImage qrCodeImage = generateQRCodeImage(url);
        byte[] qrCodeData = convertImageToByteArray(qrCodeImage);

        QRCodeEntity qrCodeEntity = new QRCodeEntity();
        qrCodeEntity.setUrl(url);
        qrCodeEntity.setQrCodeData(qrCodeData);

        return qrCodeRepository.save(qrCodeEntity);
    }

    public QRCodeEntity getQRCodeById(Long id)
    {
        return qrCodeRepository.findById(id).orElse(null);
    }

    private BufferedImage generateQRCodeImage(String text) throws WriterException 
    {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 1); // Optional: smaller margin

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 250, 250, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix); // Convert BitMatrix to BufferedImage
    }

    private byte[] convertImageToByteArray(BufferedImage image) throws IOException 
    {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            ImageIO.write(image, "PNG", baos);
            return baos.toByteArray();
        }
    }
}


