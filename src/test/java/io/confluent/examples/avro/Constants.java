package io.confluent.examples.avro;

import com.google.common.base.Preconditions;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

class Constants {

  public static final String AVRO_VERSION;

  static {
    AVRO_VERSION = System.getProperty("avro.version");
    Preconditions.checkNotNull(AVRO_VERSION, "System property avro.version was not set.");
  }

  public static File outputDirectory() {
    String outputPath = System.getProperty("avro.output.path");
    Preconditions.checkNotNull(outputPath, "System property avro.output.path was not set.");
    return new File(outputPath);
  }

  public static final boolean BOOLEAN_FIELD_VALUE =true;
  public static final int INT_FIELD_VALUE =1234;
  public static final long LONG_FIELD_VALUE =1234;
  public static final float FLOAT_FIELD_VALUE =3.14F;
  public static final double DOUBLE_FIELD_VALUE =3.14D;
  public static final ByteBuffer BYTES_FIELD_VALUE =ByteBuffer.wrap(new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x010});
  public static final String STRING_FIELD_VALUE ="This is a test value";

  public static final String BOOLEAN_FIELD_NAME = "booleanField";;
  public static final String INT_FIELD_NAME = "intField";;
  public static final String LONG_FIELD_NAME = "longField";;
  public static final String FLOAT_FIELD_NAME = "floatField";;
  public static final String DOUBLE_FIELD_NAME = "doubleField";;

  public static final String BYTES_FIELD_NAME = "bytesField";;
  public static final String STRING_FIELD_NAME = "stringField";;

  public static GenericRecord getExpectedRecord() throws IOException{
    GenericRecord expected = new GenericData.Record(getSchema());
    expected.put(BOOLEAN_FIELD_NAME, BOOLEAN_FIELD_VALUE);
    expected.put(INT_FIELD_NAME, INT_FIELD_VALUE);
    expected.put(LONG_FIELD_NAME, LONG_FIELD_VALUE);
    expected.put(FLOAT_FIELD_NAME, FLOAT_FIELD_VALUE);
    expected.put(DOUBLE_FIELD_NAME, DOUBLE_FIELD_VALUE);
    expected.put(BYTES_FIELD_NAME, BYTES_FIELD_VALUE);
    expected.put(STRING_FIELD_NAME, STRING_FIELD_VALUE);

    return expected;
  }

  public static Schema getSchema() throws IOException {
    try (InputStream schemaStream = Constants.class.getResourceAsStream("TestSchema.avsc")) {
      return Schema.parse(schemaStream);
    }
  }
}
