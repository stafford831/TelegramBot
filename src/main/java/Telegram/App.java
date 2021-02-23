package Telegram;

import Telegram.Bot.Bot;
import Telegram.Entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(App.class, args);
    }
}
