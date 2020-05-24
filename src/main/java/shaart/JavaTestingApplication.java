package shaart;

import shaart.controller.MainApplicationController;

/**
 * Application's entry point.
 */
public class JavaTestingApplication {

  public static void main(String[] args) {
    final MainApplicationController mainApplicationController = new MainApplicationController();
    mainApplicationController.run(args);
  }
}
