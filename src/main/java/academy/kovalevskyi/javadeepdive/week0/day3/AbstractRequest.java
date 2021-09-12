package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

public abstract class AbstractRequest<T> {
  private final Csv target;

  protected AbstractRequest(Csv target) {
    this.target = target;
  }

  protected abstract T execute() throws RequestException;

  // later you can put here any protected methods that required in multiple requests
}
