package hello.world.server;

import io.micronaut.context.BeanContext;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.runtime.Micronaut;
import io.micronaut.web.router.resource.StaticResourceConfiguration;
import org.thymeleaf.util.ListUtils;

import java.util.ArrayList;

public class Application {


    public static void main(String[] args) {
        Micronaut.run(Application.class);

    }
}