package pl.ag.application.command;

import pl.ag.domain.user.UserId;

public interface UsersService {
  UserId getLoggedUserId();
}
