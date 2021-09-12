package academy.kovalevskyi.javadeepdive.week0.day3;

import academy.kovalevskyi.javadeepdive.week0.day2.Csv;

import java.util.ArrayList;

public class DeleteRequest extends AbstractRequest<Csv> {
  private Selector whereSelector;

  private DeleteRequest(Csv target, Selector whereSelector) {
    super(target);
    this.whereSelector = whereSelector;
  }

  @Override
  protected Csv execute() throws RequestException {
   String[][] temp = new String[Csv.value.length][];
    Csv.String[] header = new String[0];
    Csv.String[][] values = new String[0][];
    Csv csv = new Csv(header, values);
    if (header.)
    for (String str: header) {
      arrayList.add(str);
    }
    return arrayList;
  }

  public static class Builder {
    private Selector selector;
    private Csv csv;

    public Builder where(Selector selector) {
      this.selector = selector;
      return this;
    }

    public Builder from(Csv csv) {
      this.csv = csv;
      return this;
    }

    public DeleteRequest build() {
      return new DeleteRequest(csv, selector);
    }
  }
}
