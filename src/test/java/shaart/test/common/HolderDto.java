package shaart.test.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HolderDto<T> {

  private T value;
}
