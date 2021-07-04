package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.common.UrlShortenerUtility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ShortUrlTest {

    @Test
    void createRandomShortUrl() {
        String shortUrl = UrlShortenerUtility.getInstance().randomShortUrl();
        assertNotEquals("12345", shortUrl);
    }
}
