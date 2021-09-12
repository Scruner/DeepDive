package academy.kovalevskyi.javadeepdive.week0.day2;

import academy.kovalevskyi.javadeepdive.week0.day0.StdBufferedReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvHelper {

  // deserialize
  public static Csv parseFile(Reader reader) throws IOException {
    return parseFile(reader, false, ',');
  }

  // deserialize
  public static Csv parseFile(Reader reader, boolean withHeader, char delimiter)
      throws IOException {
    String[] header = new String[0];
    String[][] values = new String[0][];
    try {
      if (!reader.ready()) {
        reader.close();
        return null;
      }
    } catch (FileNotFoundException e) {
      throw e;
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (StdBufferedReader stdBufferedReader = new StdBufferedReader(reader)) {
      header =
          (withHeader) ? Arrays.toString(stdBufferedReader.readLine()).split("" + delimiter) : null;
      List<String> list = new ArrayList<>();
      char[] temp;
      while ((temp = stdBufferedReader.readLine()) != null) {
        String str = new String(temp);
        list.add(str);
      }
      stdBufferedReader.close();
      values = new String[list.size()][];
      for (int i = 0; i < list.size(); i++) {
        values[i] = list.get(i).split(Character.toString(delimiter));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Csv.Builder().header(header).values(values).build();
  }

  // serialize
  public static void writeCsv(Writer writer, Csv csv, char delimiter) throws IOException {
    Writer wr = new StringWriter();
    String[] header = csv.header();
    for (int i = 0; i < header.length; i++) {
      writer.write(header[i]);
      if (i < header.length - 1) {
        writer.append(delimiter);
      }
    }
    writer.append('\n');
    String[][] table = csv.values();
    for (String[] strings : table) {
      for (int j = 0; j < strings.length; j++) {
        writer.write(strings[j]);
        if (j < strings.length - 1) {
          writer.append(delimiter);
        }
      }
      writer.append('\n');
    }
    writer.close();
  }
}
