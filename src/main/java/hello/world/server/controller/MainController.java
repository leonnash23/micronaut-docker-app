package hello.world.server.controller;

import hello.world.server.service.HomeService;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.text.ParseException;

@Controller("/")
public class MainController {

    private HomeService homeService;
    private Logger logger;

    public MainController(HomeService homeService) {
        logger = LoggerFactory.getLogger(MainController.class);
        this.homeService = homeService;
    }

    @View("ws")
    @Get("/ws")
    public HttpResponse ws() {
        return HttpResponse.ok();
    }

    @View("home")
    @Get("/{name}")
    public HttpResponse hello(String name) {
        logger.info("name == {}", name);
        return HttpResponse.ok(CollectionUtils.mapOf("name", name));
    }

    @View("home")
    @Get()
    public HttpResponse hello() {
        return HttpResponse.ok(CollectionUtils.mapOf("name", "World", "time", homeService.getSystemTime()));
    }

    @View("days")
    @Get("/days{?from,to}")
    public HttpResponse getDays(@Nullable String from, @Nullable String to) {
        if (from == null || to == null) {
            return HttpResponse.ok();
        }
        try {
            long daysBeetweenDates = homeService.getDaysBeetweenDates(from, to);
            return HttpResponse.ok(CollectionUtils.mapOf("days", daysBeetweenDates,
                    "from", from,
                    "to", to));
        } catch (ParseException e) {
            return HttpResponse.badRequest();
        }
    }
}
