package shaart.calculator.impl;

import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import shaart.calculator.Calculator;

@Slf4j
public class CalculatorImpl implements Calculator {

  @Override
  public void run(String[] args) {
    final int sum = Stream.of(args)
        .mapToInt(Integer::valueOf)
        .sum();
    log.info("Sum is: {}", sum);
  }
}
