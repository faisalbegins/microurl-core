package edu.miu.microurl.microurlcore.dto;

import edu.miu.microurl.microurlcore.model.UrlMetaData;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CreateUrlRequest {
    private Long userId;
    @Email
    private String email;
    @NotBlank
    private String longUrl;
    private Long expireDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    public UrlMetaData toUrlMetaData() {
        LocalDateTime localDateTime = Instant.ofEpochMilli(expireDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return new UrlMetaData(this.userId, this.email, this.longUrl, localDateTime);
    }

    @Override
    public String toString() {
        return "CreateUrlRequest{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}
