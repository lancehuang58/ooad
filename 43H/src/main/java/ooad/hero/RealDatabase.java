package ooad.hero;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class RealDatabase implements Database {
  @Override
  public Employee getEmployeeById(Integer id) {

    InputStream input = getClass().getResourceAsStream("/employee.txt");
    assert input != null;
    try (Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines()) {
      Optional<String> first = lines.skip(id).findFirst();
      Optional<RealEmployee> realEmployee = first.map(RealEmployee::new);
      RealEmployee employee = realEmployee.orElseThrow(NoSuchElementException::new);
      return new EmployeeLazyLoadingProxy(employee, this);
    }
  }
}
