This project is to test the outputs from all avro versions against each other to ensure compatibility across releases. It creates a simple record that contains all of the primitive record types.

To run 

```
./run-avro-versions.sh
```

You should see output that is identical across all versions

```
shasum *
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.5.0.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.5.1.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.5.2.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.5.3.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.5.4.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.6.0.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.6.1.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.6.2.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.6.3.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.0.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.1.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.2.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.3.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.4.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.5.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.6.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.7.7.bin
44cceab49730a9c838ca62ad812d3ff05988e638  avro.1.8.0.bin
```