package ooad.hero;

import java.io.IOException;
import java.util.List;

public class Client {
  public static void main(String[] args) throws IOException {
    Database database = new SecurityDatabaseProxy(new RealDatabase());
    Employee employee = database.getEmployeeById(2);
    System.out.printf(
            "employee id %d, name %s, age %d\n",
            employee.getId(), employee.getName(), employee.getAge());

    List<Employee> subordinates = employee.getSubordinates();
    for (Employee subordinate : subordinates) {
      System.out.printf(
          "subordinate id %d, name %s, age %d\n",
          subordinate.getId(), subordinate.getName(), subordinate.getAge());
    }
  }
}
