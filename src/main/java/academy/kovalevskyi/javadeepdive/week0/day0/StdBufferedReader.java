package academy.kovalevskyi.javadeepdive.week0.day0;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class StdBufferedReader implements Closeable {
  final Reader reader;
  private final char[] arrayBuf;
  private char[] accumulator;
  private int positionAccum = 0;
  boolean signCloseStream = true;
  int startPosAccum = 0;
  int finishPosAccum = 0;
  //boolean crutchFlag = true;

  public StdBufferedReader(Reader reader, int bufferSize) {
    if (reader == null) {
      throw new NullPointerException("Reader is not be NULL!!!");
    }
    this.reader = reader;
    if (bufferSize < 2) {
      throw new IllegalArgumentException("Buffer size is not be less 2!!!");
    }
    this.arrayBuf = new char[bufferSize];
  }

  public StdBufferedReader(Reader reader) {
    this(reader, 8192);
  }

  // Returns true if there is something to read from the reader.
  // False if nothing is there
  public boolean hasNext() throws IOException {
    return (positionAccum != 0 || reader.ready());
  }

  public char[] generateAccum() throws IOException {
    accumulator = new char[arrayBuf.length];
    while (true) {
      int strm = reader.read(arrayBuf, 0, arrayBuf.length);
      if (strm == -1) {
        char[] temp = new char[positionAccum];
        System.arraycopy(accumulator, 0, temp, 0, temp.length);
        accumulator = new char[temp.length];
        System.arraycopy(temp, 0, accumulator, 0, temp.length);
        signCloseStream = false;
        return accumulator;
      }
      if (accumulator.length - positionAccum < arrayBuf.length) {
        char[] temp = new char[accumulator.length * 5];
        System.arraycopy(accumulator, 0, temp, 0, accumulator.length);
        accumulator = temp;
      }
      System.arraycopy(arrayBuf, 0, accumulator, positionAccum, strm);
      positionAccum += strm;
    }
  }

  // Returns a line (everything till the next line)
  public char[] readLine() throws IOException {
    if (signCloseStream) {
      generateAccum();
    }
    char[] rsl;
    for (; finishPosAccum < accumulator.length; finishPosAccum++) {
      if (accumulator[finishPosAccum] == '\n' || accumulator[finishPosAccum] == '\r') {
        rsl = new char[finishPosAccum - startPosAccum];
        System.arraycopy(accumulator, startPosAccum, rsl, 0, rsl.length);
        startPosAccum = finishPosAccum + 1;
        finishPosAccum++;
        return rsl;
      }
    }
//    if (crutchFlag
//        && startPosAccum == finishPosAccum
//        && startPosAccum != 0
//        && accumulator[accumulator.length - 1] == '\n') {
//      crutchFlag = false;
//      return new char[0];
//    }
    if (startPosAccum == finishPosAccum && startPosAccum != 0) {
      return null;
    }
    rsl = new char[accumulator.length - startPosAccum];
    System.arraycopy(accumulator, startPosAccum, rsl, 0, rsl.length);
    startPosAccum = finishPosAccum;
    return rsl;
  }

  // Closing
  public void close() throws IOException {
    reader.close();
  }
}
