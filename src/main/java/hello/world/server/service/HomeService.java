package hello.world.server.service;

import javax.inject.Singleton;
import java.util.Date;

@Singleton
public class HomeService {

    public String getSystemTime() {
        return new Date().toString();
    }
}
