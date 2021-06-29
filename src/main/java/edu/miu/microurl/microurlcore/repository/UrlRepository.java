package edu.miu.microurl.microurlcore.repository;

import edu.miu.microurl.microurlcore.model.UrlMetaData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<UrlMetaData, String> {
    Optional<UrlMetaData> findByShortUrl(String shortUrl);
    Page<UrlMetaData> findByUserId(Long userId, Pageable pageable);
}