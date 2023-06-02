package ooad.hero;

import java.io.IOException;
import java.util.List;

public interface Employee {
  Integer getId();

  String getName();

  Integer getAge();

  List<Employee> getSubordinates() throws IOException;

  List<String> getSubordinateIds();
}
