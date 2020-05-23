package shaart.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import shaart.calculator.Calculator;

@Getter
@AllArgsConstructor
public enum ApplicationName {

  CALCULATOR("calculator", Calculator.class);

  private String name;
  private Class<?> appClass;

  public static List<String> getAppNames() {
    return Stream.of(values())
        .map(ApplicationName::getName)
        .collect(Collectors.toList());

  }

  public static ApplicationName getAppByName(String requestedAppName) {
    return Stream.of(values())
        .filter(applicationName -> applicationName.getName().equals(requestedAppName))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
