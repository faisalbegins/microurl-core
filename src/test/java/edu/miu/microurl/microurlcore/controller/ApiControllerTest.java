package edu.miu.microurl.microurlcore.controller;

import edu.miu.microurl.microurlcore.dto.CreateUrlRequest;
import edu.miu.microurl.microurlcore.model.Subscription;
import edu.miu.microurl.microurlcore.model.UrlMetaData;
import edu.miu.microurl.microurlcore.service.SubscriptionService;
import edu.miu.microurl.microurlcore.service.UrlService;
import edu.miu.microurl.microurlcore.service.UrlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ApiControllerTest {
    @Mock
    private UrlService urlService;

    @Mock
    private SubscriptionService subscriptionService;

    private ApiController controller;

    private LongUrlController longUrlController;

    @BeforeEach
    void init() {
        controller = new ApiController(urlService, subscriptionService);
        longUrlController = new LongUrlController(urlService);
    }

    @Test
    void longUrlControllerTest() {
        String shortUrl = "1234567";
        when(urlService.longUrl(shortUrl)).thenReturn("www.miu.edu");
        ModelAndView modelAndView = longUrlController.longUrl(shortUrl);
        assertEquals(modelAndView.getViewName(), "redirect:www.miu.edu");
    }

    @Test
    void listAllUrlsTest() {
        List<UrlMetaData> urls = listAllUrls();
        when(urlService.listAllUrls()).thenReturn(listAllUrls());
        List<UrlMetaData> result = controller.urls();
        assertArrayEquals(urls.toArray(), result.toArray());
    }

    @Test
    void listAllUrlsByUserTest() {
        List<UrlMetaData> urls = listAllUrlsByUser();
        when(urlService.listAllUrlsByUser(1L, 0, 5)).thenReturn(listAllUrlsByUser());
        List<UrlMetaData> result = controller.urls(1L, 0, 5);
        assertArrayEquals(urls.toArray(), result.toArray());
    }

    @Test
    void createUrl() {
        String expected = "1234567";
        CreateUrlRequest request = new CreateUrlRequest();
        when(urlService.createShortUrlForUser(request)).thenReturn("1234567");
        String url = controller.url(request);
        assertEquals(expected, url);
    }

    @Test
    void subscribeTest() {
        Subscription subscribe = controller.subscribe();
        assertNull(subscribe);
    }

    List<UrlMetaData> listAllUrls() {
        List<UrlMetaData> list = new ArrayList<>();
        list.add(new UrlMetaData(1L, "a@b.com", "www.miu.edu", null));
        list.add(new UrlMetaData(2L, "b@b.com", "stu.miu.edu", null));
        list.add(new UrlMetaData(3L, "c@b.com", "info.miu.edu", null));
        return list;
    }

    List<UrlMetaData> listAllUrlsByUser() {
        List<UrlMetaData> list = new ArrayList<>();
        list.add(new UrlMetaData(1L, "a@b.com", "www.miu.edu", null));
        list.add(new UrlMetaData(1L, "b@b.com", "stu.miu.edu", null));
        list.add(new UrlMetaData(1L, "c@b.com", "info.miu.edu", null));
        return list;
    }
}
