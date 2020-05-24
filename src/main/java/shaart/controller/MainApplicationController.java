package shaart.controller;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import shaart.common.AppContextFactory;
import shaart.common.Application;
import shaart.common.enums.ApplicationName;

@Slf4j
public class MainApplicationController {

  private static final List<String> APPLICATIONS_LIST = ApplicationName.getAppNames();
  private static final String JOINED_APP_NAMES = String.join(", ", APPLICATIONS_LIST);
  private static final String NO_ARGS_ERROR_MESSAGE =
      "Specify an application to run: " + JOINED_APP_NAMES;

  private static final int APP_NAME_INDEX = 0;
  private static final int FIRST_APP_ARG_INDEX = 1;

  public void run(String[] args) {
    if (args.length == 0) {
      log.error(NO_ARGS_ERROR_MESSAGE);
      return;
    }
    final String requestedAppName = args[APP_NAME_INDEX];
    if (!APPLICATIONS_LIST.contains(requestedAppName)) {
      log.error("Application with name '{}' is not found. Available apps: {}", requestedAppName,
          JOINED_APP_NAMES);
      return;
    }

    AppContextFactory appContextFactory = new AppContextFactory();

    Application application = appContextFactory.getApp(requestedAppName);
    final String[] appArgs = Arrays.copyOfRange(args, FIRST_APP_ARG_INDEX, args.length);
    try {
      application.run(appArgs);
    } catch (Exception e) {
      log.error("An application '{}' exited with error", requestedAppName, e);
    }
  }
}
