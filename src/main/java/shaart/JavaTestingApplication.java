package shaart;

import shaart.controller.ApplicationController;

/**
 * Application's entry point.
 */
public class JavaTestingApplication {

  public static void main(String[] args) {
    final ApplicationController applicationController = new ApplicationController();
    applicationController.run(args);
  }
}
