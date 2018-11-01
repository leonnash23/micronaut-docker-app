package hello.world.server.controller;


import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

@ServerWebSocket("/ws/test")
public class WebSocketController {

    private Logger logger;
    private WebSocketBroadcaster broadcaster;

    public WebSocketController(WebSocketBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
        logger = LoggerFactory.getLogger(WebSocketController.class);
    }

    @OnOpen
    public void onOpen(WebSocketSession session) {
        session.send("Hello!");
        new Thread(() -> {
            int i = 0;
            Scanner scanner = new Scanner(System.in);
            do {
                session.sendAsync(scanner.nextLine());
            } while (true);
        }).start();
    }

    @OnMessage
    public void onMessage(String message, WebSocketSession session) {
        logger.info(message);
    }


}
