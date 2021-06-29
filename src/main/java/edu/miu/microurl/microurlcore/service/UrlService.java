package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.microurlcore.dto.CreateUrlRequest;
import edu.miu.microurl.microurlcore.model.UrlMetaData;

import java.util.List;

public interface UrlService {
    String longUrl(String shortUrl);
    List<UrlMetaData> listAllUrlsByUser(Long userId, int page, int size);
    String createShortUrlForUser(CreateUrlRequest request);
}
