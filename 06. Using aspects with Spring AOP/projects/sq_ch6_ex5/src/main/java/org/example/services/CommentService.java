package org.example.services;

import org.example.annotations.ToLog;
import lombok.NoArgsConstructor;
import org.example.models.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }
}
