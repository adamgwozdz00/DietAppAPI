package pl.ag.application.command;

import org.springframework.stereotype.Service;
import pl.ag.domain.user.UserId;

@Service
public interface UsersService {

  UserId getLoggedUserId();
}
