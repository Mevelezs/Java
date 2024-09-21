package enums;

public enum Months {
  JANUARY(31),
  FEBRUARY(28),
  MARCH(31),
  APRIL(30),
  MAY(31),
  JAN(30),
  JULY(31),
  AUGUST(31),
  SEPTEMBER(30),
  OCTOBER(31),
  NOVEMBER(30),
  DECEMBER(31);

  private final int DAYS;

  Months(int DAYS ){
    this.DAYS = DAYS;
  }

  public int getDAYS() {
    return DAYS;
  }
}
