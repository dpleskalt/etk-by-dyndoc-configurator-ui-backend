package hr.ericsson.ehealth.belarus.dyndoc.configurator.service;

import hr.ericsson.ehealth.belarus.clc.logger.annotation.ClcLog;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.LogoutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@RefreshScope
public class UserSessionService {

  @Value("${logout.logout-url}")
  private String logoutUrl;

  @Value("${logout.cookie-auth-session}")
  private String cookieAuthSession;

  @ClcLog(logLevel = LogLevel.DEBUG)
  public LogoutDto logoutUser() {
    LogoutDto logoutDto = new LogoutDto();
    logoutDto.setLogoutUrl(logoutUrl);
    logoutDto.setAuthCookieName(cookieAuthSession);
    return logoutDto;
  }
}
