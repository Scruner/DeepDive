package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

public class JoinRequest extends AbstractRequest<Csv> {
  private Csv on;
  private String by;

  private JoinRequest(Csv from, Csv on, String by) {
    super(from);
    this.on = on;
    this.by = by;
  }

  @Override
  protected Csv execute() throws RequestException {
    // TODO
  }

  public static class Builder {
    private Csv from;
    private Csv on;
    private String by;

    public Builder from(Csv from) {
      this.from = from;
      return this;
    }

    public Builder on(Csv on) {
      this.on = on;
      return this;
    }

    public Builder by(String by) {
      this.by = by;
      return this;
    }

    public JoinRequest build() {
      return new JoinRequest(from, on, by);
    }
  }
}
