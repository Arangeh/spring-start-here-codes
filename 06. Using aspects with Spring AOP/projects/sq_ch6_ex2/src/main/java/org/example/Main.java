package org.example;

import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setAuthor("Natasha");
        comment.setText("Demo comment");

        String value = service.publishComment(comment);
        logger.info(value);
    }
}