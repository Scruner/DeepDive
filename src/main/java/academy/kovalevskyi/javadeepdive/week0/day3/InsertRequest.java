package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

public class InsertRequest extends AbstractRequest<Csv> {
  private String[] line;

  private InsertRequest(Csv target, String[] line) {
    super(target);
    this.line = line;
  }

  @Override
  protected Csv execute() throws RequestException {
    // TODO
  }

  public static class Builder {
    private Csv csv;
    private String[] line;

    public Builder to(Csv csv) {
      this.csv = csv;
      return this;
    }

    public Builder insert(String[] line) {
      this.line = line;
      return this;
    }

    public InsertRequest build() {
      return new InsertRequest(csv, line);
    }
  }
}
