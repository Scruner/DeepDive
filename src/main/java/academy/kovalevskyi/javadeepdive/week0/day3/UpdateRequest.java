package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

public class UpdateRequest extends AbstractRequest<Csv> {
  private Selector whereSelector;
  private Selector updateToSelector;

  private UpdateRequest(Csv target, Selector whereSelector, Selector updateToSelector) {
    super(target);
    this.whereSelector = whereSelector;
    this.updateToSelector = updateToSelector;
  }

  @Override
  protected Csv execute() throws RequestException {
    // TODO
  }

  public static class Builder {
    private Csv csv;
    private Selector selector;
    private Selector updateSelector;

    public Builder from(Csv csv) {
      this.csv = csv;
      return this;
    }

    public Builder where(Selector selector) {
      this.selector = selector;
      return this;
    }

    public Builder update(Selector updateSelector) {
      this.updateSelector = updateSelector;
      return this;
    }

    public UpdateRequest build() {
      return new UpdateRequest(csv, selector, updateSelector);
    }
  }
}
