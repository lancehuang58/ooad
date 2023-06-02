package ooad.hero;


public class SecurityDatabaseProxy implements Database {

  public static final String DEFAULT_PASSWORD = "1qaz2wsx";
  private final Database database;

  public SecurityDatabaseProxy(Database database) {
    this.database = database;
  }

  @Override
  public Employee getEmployeeById(Integer id) {

    String pwd = System.getenv("password");
    if (!pwd.equals(DEFAULT_PASSWORD)) {
      throw new SecurityException("wrong password");
    }
    return database.getEmployeeById(id);
  }
}
