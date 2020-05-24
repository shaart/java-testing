package shaart.common.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationName {

  CALCULATOR("calculator");

  private String name;

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
