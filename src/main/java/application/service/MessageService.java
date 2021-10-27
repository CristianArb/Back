package application.service;

import application.model.Message;
import application.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {

        return messageRepository.getAll();

    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message message) {

        if (message.getIdMessage() == null) {

            return messageRepository.save(message);

        } else {

            var e = messageRepository.getMessage(message.getIdMessage());

            if (e.isEmpty()) {

                return messageRepository.save(message);

            } else {

                return message;

            }
        }
    }

    public Message update(Message message) {

        if (message.getIdMessage() != null) {

            var e = messageRepository.getMessage(message.getIdMessage());

            if (!e.isEmpty()) {

                if (message.getMessageText() != null) {

                    e.get().setMessageText(message.getMessageText());

                }

                messageRepository.save(e.get());

                return e.get();

            } else {

                return message;

            }

        } else {

            return message;

        }
    }

    public boolean deleteMessage(int messageId) {

        var aBoolean = getMessage(messageId).map(message -> {

            messageRepository.delete(message);

            return true;

        }).orElse(false);

        return aBoolean;
    }
}
