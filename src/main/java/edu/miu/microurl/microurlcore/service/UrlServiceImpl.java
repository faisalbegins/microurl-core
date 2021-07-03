package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.common.UrlShortenerUtility;
import edu.miu.microurl.microurlcore.dto.CreateUrlRequest;
import edu.miu.microurl.microurlcore.exception.LongUrlNotFoundException;
import edu.miu.microurl.microurlcore.model.UrlMetaData;
import edu.miu.microurl.microurlcore.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository repository;
    private final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);

    @Autowired
    public UrlServiceImpl(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public String longUrl(String shortUrl) {
        logger.debug("looking up for short url [{}] in the database", shortUrl);
        Optional<UrlMetaData> meta = repository.findByShortUrl(shortUrl);
        return meta.orElseThrow(LongUrlNotFoundException::new).getLongUrl();
    }

    @Override
    public List<UrlMetaData> listAllUrls() {
        logger.debug("Listing all the URLs for all the Users");
        return repository.findAll();
    }

    @Override
    public List<UrlMetaData> listAllUrlsByUser(Long userId, int page, int size) {
        logger.debug("Listing all the URLs for User ID: [{}]", userId);
        return repository.findByUserId(userId, PageRequest.of(page, size)).getContent();
    }

    @Override
    @Retryable(value = RuntimeException.class, maxAttempts = 10)
    public String createShortUrlForUser(CreateUrlRequest request) {
        String randomUrl = UrlShortenerUtility.getInstance().randomShortUrl();
        Optional<UrlMetaData> entry = repository.findByShortUrl(randomUrl);
        if(entry.isPresent()) throw new RuntimeException();
        UrlMetaData meta = request.toUrlMetaData();
        meta.setShortUrl(randomUrl);
        UrlMetaData url = repository.save(meta);
        return url.getShortUrl();
    }
}
