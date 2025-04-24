package com.example.Link.control;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Link.entity.QRCodeEntity;
import com.example.Link.service.QRCodeService;

@RestController
@RequestMapping("/api/qr")
@CrossOrigin(origins = "http://localhost:5173")  
public class QRCodeController
{

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public byte[] generateAndSaveQRCode(@RequestParam("url") String url) throws Exception 
    {
        // Generate and save QR code
        QRCodeEntity qrCodeEntity = qrCodeService.generateAndSaveQRCode(url);

        // Return the QR code as a byte array
        return qrCodeEntity.getQrCodeData();
    }

    @GetMapping("/get/{id}")
    public byte[] getQRCode(@PathVariable("id") Long id) throws Exception
    {
        QRCodeEntity qrCodeEntity = qrCodeService.getQRCodeById(id);

        if (qrCodeEntity != null)
        {
            return qrCodeEntity.getQrCodeData();
        } else {
            throw new RuntimeException("QR Code not found for id: " + id);
        }
    }
    
    @GetMapping("/all")
    public List<Map<String, Object>> getAllQRCodes() 
    {
        List<QRCodeEntity> qrCodes = qrCodeService.getAll();
        
        return qrCodes.stream().map(qr -> 
        {
            Map<String, Object> map = new HashMap<>();
            map.put("id", qr.getId());
            map.put("url", qr.getUrl());
            map.put("imageBase64", Base64.getEncoder().encodeToString(qr.getQrCodeData()));
            return map;
        }).collect(Collectors.toList());
    }

}


