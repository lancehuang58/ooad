package ooad.hero;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeLazyLoadingProxy implements Employee {

  private final Employee employee;
  private final Database database;

  public EmployeeLazyLoadingProxy(Employee employee, Database database) {
    this.employee = employee;
    this.database = database;
  }

  @Override
  public Integer getId() {
    return employee.getId();
  }

  @Override
  public String getName() {
    return employee.getName();
  }

  @Override
  public Integer getAge() {
    return employee.getAge();
  }

  @Override
  public List<String> getSubordinateIds() {
    return employee.getSubordinateIds();
  }

  @Override
  public List<Employee> getSubordinates() {
    return getSubordinateIds().stream()
        .map(i -> database.getEmployeeById(Integer.parseInt(i)))
        .collect(Collectors.toList());
  }
}
