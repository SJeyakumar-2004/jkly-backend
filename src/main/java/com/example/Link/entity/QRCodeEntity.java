package com.example.Link.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

//import java.util.Arrays;

@Entity
@Table(name = "qr_codes")
public class QRCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2048)
    private String url;

    @Lob  // Use @Lob to store large binary data
    private byte[] qrCodeData;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getQrCodeData() {
        return qrCodeData;
    }

    public void setQrCodeData(byte[] qrCodeData) {
        this.qrCodeData = qrCodeData;
    }

    @Override
    public String toString() {
        return "QRCodeEntity{id=" + id + ", url='" + url + "'}";
    }
}
