package io.confluent.examples.avro;

import com.google.common.base.Preconditions;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataTest {

  File testDirectory;
  @Before
  public void before(){
    this.testDirectory = Constants.outputDirectory();
    this.testDirectory.mkdirs();
  }


  @Test
  public void write() throws IOException {
    Schema schema = Constants.getSchema();
    GenericData.Record genericRecord = new GenericData.Record(schema);
    genericRecord.put(Constants.BOOLEAN_FIELD_NAME, Constants.BOOLEAN_FIELD_VALUE);
    genericRecord.put(Constants.INT_FIELD_NAME, Constants.INT_FIELD_VALUE);
    genericRecord.put(Constants.LONG_FIELD_NAME, Constants.LONG_FIELD_VALUE);
    genericRecord.put(Constants.FLOAT_FIELD_NAME, Constants.FLOAT_FIELD_VALUE);
    genericRecord.put(Constants.DOUBLE_FIELD_NAME, Constants.DOUBLE_FIELD_VALUE);

    genericRecord.put(Constants.BYTES_FIELD_NAME, Constants.BYTES_FIELD_VALUE);
    genericRecord.put(Constants.STRING_FIELD_NAME, Constants.STRING_FIELD_VALUE);


    GenericDatumWriter writer = new GenericDatumWriter(schema);

    System.out.println();


    String fileName = String.format("avro.%s.bin", Constants.AVRO_VERSION);

    File outputFile = new File(this.testDirectory, fileName);


    try(FileOutputStream fileOutputStream=new FileOutputStream(outputFile)) {
      Encoder encoder = EncoderFactory.get().blockingBinaryEncoder(fileOutputStream, null);
      writer.write(genericRecord, encoder);
      encoder.flush();
    }
  }


}
