package ooad.hero;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RealEmployee implements Employee {
  private Integer id;
  private String name;
  private Integer age;
  private String subordinateIds;

  public RealEmployee(String input) {
    String[] s = input.split(" ");
    this.id = Integer.parseInt(s[0]);
    this.name = s[1];
    this.age = Integer.parseInt(s[2]);
    if (s.length >= 4) this.subordinateIds = s[3];
  }

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Integer getAge() {
    return age;
  }

  @Override
  public List<Employee> getSubordinates() {
    throw new UnsupportedOperationException();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public List<String> getSubordinateIds() {
    return Arrays.stream(subordinateIds.split(",")).collect(Collectors.toList());
  }
}
