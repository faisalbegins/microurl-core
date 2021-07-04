package edu.miu.microurl.microurlcore.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class UrlMetaData {
    @Id
    private String id;
    private Long userId;
    private String email;
    private String longUrl;
    private String shortUrl;
    private LocalDateTime expireDate;

    public UrlMetaData() {}

    public UrlMetaData(Long userId, String email, String longUrl, LocalDateTime expireDate) {
        this.userId = userId;
        this.email = email;
        this.longUrl = longUrl;
        this.expireDate = expireDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlMetaData metaData = (UrlMetaData) o;
        return Objects.equals(id, metaData.id) && Objects.equals(userId, metaData.userId) && Objects.equals(email, metaData.email) && Objects.equals(longUrl, metaData.longUrl) && Objects.equals(shortUrl, metaData.shortUrl) && Objects.equals(expireDate, metaData.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, email, longUrl, shortUrl, expireDate);
    }
}
