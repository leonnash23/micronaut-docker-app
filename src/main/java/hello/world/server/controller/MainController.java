package hello.world.server.controller;

import hello.world.server.service.HomeService;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/")
public class MainController {

    private HomeService homeService;

    public MainController(HomeService homeService) {
        this.homeService = homeService;
    }

    @View("home")
    @Get("/{name}")
    public HttpResponse hello(String name){
        return HttpResponse.ok(CollectionUtils.mapOf("name", name));
    }

    @View("home")
    @Get()
    public HttpResponse hello(){
        return HttpResponse.ok(CollectionUtils.mapOf("name", "World", "time", homeService.getSystemTime()));
    }
}
