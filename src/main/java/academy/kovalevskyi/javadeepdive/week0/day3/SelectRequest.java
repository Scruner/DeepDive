package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.Objects;

public class SelectRequest extends AbstractRequest<String[][]> {
  private Csv target;
  private Selector selector;
  private String[] columns;

  private SelectRequest(Csv target, Selector selector, String[] columns) {
    super(target);
    this.selector = selector;
    this.columns = columns;
  }

  @Override
  protected String[][] execute() throws RequestException {
    // TODO
  }

  public static class Builder {
    private Selector selector;
    private String[] columns;
    private Csv csv;

    public Builder where(Selector selector) {
      this.selector = selector;
      return this;
    }

    public Builder select(String[] columns) {
      this.columns = columns;
      return this;
    }

    public Builder from(Csv csv) {
      this.csv = csv;
      return this;
    }

    public SelectRequest build() {
      Objects.nonNull(csv);
      return new SelectRequest(csv, selector, columns);
    }
  }
}
