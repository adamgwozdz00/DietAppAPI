package pl.ag.acl;

import org.springframework.stereotype.Service;
import pl.ag.application.shared.UsersService;
import pl.ag.domain.user.UserId;

@Service
public class UserServiceImpl implements UsersService {

  @Override
  public UserId getLoggedUserId() {
    return UserId.userId(1);
  }
}
