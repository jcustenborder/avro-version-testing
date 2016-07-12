package io.confluent.examples.avro;

import com.google.common.io.PatternFilenameFilter;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DecoderFactory;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataTest {
  File testDirectory;

  @Before
  public void before() {
    this.testDirectory = Constants.outputDirectory();
    this.testDirectory.mkdirs();
  }

  @Test
  public void read() throws IOException {
    Schema schema = Constants.getSchema();
    GenericDatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);

    BinaryDecoder decoder = null;
    GenericRecord record = new GenericData.Record(schema);
    for (File inputFile : testDirectory.listFiles(new PatternFilenameFilter("^.*\\.bin$"))) {
      try (FileInputStream inputStream = new FileInputStream(inputFile)) {
        decoder = DecoderFactory.get().binaryDecoder(inputStream, decoder);
        record = reader.read(record, decoder);
        System.out.format("Reading %s with Avro %s\n", inputFile.getName(), Constants.AVRO_VERSION);
        Assert.assertNotNull(String.format("Record should have been found for %s", inputFile.getName()), record);
        GenericRecord expected = Constants.getExpectedRecord();
        Assert.assertThat(record, IsEqual.equalTo(expected));
      }
    }
  }


}
