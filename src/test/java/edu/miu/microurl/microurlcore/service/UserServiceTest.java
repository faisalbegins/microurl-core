package edu.miu.microurl.microurlcore.service;

import edu.miu.microurl.microurlcore.model.UrlMetaData;
import edu.miu.microurl.microurlcore.repository.UrlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UrlRepository urlRepository;

    private UrlService urlService;

    @BeforeEach
    void init() {
        urlService = new UrlServiceImpl(urlRepository);
    }

    @Test
    void shortUrlToLongUrlTest() {
        String shortUrl = "1234567";
        when(urlRepository.findByShortUrl(shortUrl)).thenReturn(findByShortUrl());
        String longUrl = urlService.longUrl(shortUrl);
        assertEquals("www.miu.edu", longUrl);
    }

    @Test
    void listAllUrlsWithoutFilter() {
        when(urlRepository.findAll()).thenReturn(listAllUrls());
        List<UrlMetaData> urls = urlService.listAllUrls();
        List<UrlMetaData> list = new ArrayList<>();
        list.add(new UrlMetaData(1L, "a@b.com", "www.miu.edu", null));
        list.add(new UrlMetaData(2L, "b@b.com", "stu.miu.edu", null));
        list.add(new UrlMetaData(3L, "c@b.com", "info.miu.edu", null));
        assertArrayEquals(list.toArray(), urls.toArray());
    }

//    @Test
//    void listAllUrlsWithFilter() {
//        long userId = 1L;
//        when(urlRepository.findByUserId(userId, Pageable.ofSize(5))).thenReturn(pagedListAllUrls());
//        List<UrlMetaData> urls = urlService.listAllUrls();
//        List<UrlMetaData> list = new ArrayList<>();
//        list.add(new UrlMetaData(1L, "a@b.com", "www.miu.edu", null));
//        assertEquals(0, urls.size());
//    }

//    @Test
//    void createShortUrl() {
//        when(urlRepository.findByShortUrl("")).thenReturn(Optional.empty());
//        String shortUrl = urlService.createShortUrlForUser(new CreateUrlRequest());
//        assertNotEquals("1234567", shortUrl);
//    }

    Optional<UrlMetaData> findByShortUrl() {
        UrlMetaData metaData = new UrlMetaData(1L, "faisalbegins@gmail.com","www.miu.edu", null);
        return Optional.of(metaData);
    }

    List<UrlMetaData> listAllUrls() {
        List<UrlMetaData> list = new ArrayList<>();
        list.add(new UrlMetaData(1L, "a@b.com", "www.miu.edu", null));
        list.add(new UrlMetaData(2L, "b@b.com", "stu.miu.edu", null));
        list.add(new UrlMetaData(3L, "c@b.com", "info.miu.edu", null));
        return list;
    }

    Page<UrlMetaData> pagedListAllUrls() {
        List<UrlMetaData> list = new ArrayList<>();
        list.add(new UrlMetaData(1L, "a@b.com", "www.miu.edu", null));
        return Page.empty();
    }

}
