package constant;

public enum DayOfTheWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    
    private static final int FIRST_MONDAY = 4;
    
    public static DayOfTheWeek of(int day) {
        int numberOfWeek = values().length;
        return values()[(day + numberOfWeek - FIRST_MONDAY) % numberOfWeek];
    }
}
