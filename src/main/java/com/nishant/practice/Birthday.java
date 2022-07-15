package com.nishant.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Birthday {

  static Map<String, Set<String>> sameBirthdays(Map<String, String> birthdays) {
    Map<String, Set<String>> sameBirthdays = new HashMap<>();

    for (Map.Entry<String, String> birthdaysEntry : birthdays.entrySet()) {
      String date = birthdaysEntry.getKey().substring(0, 4);
      String name = birthdaysEntry.getValue();
      insertName(sameBirthdays, date, name);
    }

    return sameBirthdays;
  }

  private static void insertName(Map<String, Set<String>> sameBirthdays, String date, String name) {
      Set<String> commonBirthdayName = sameBirthdays.getOrDefault(date, new HashSet<>());
      commonBirthdayName.add(name);
      sameBirthdays.put(date, commonBirthdayName);
  }

  public static void main(String[] args) {
    Map<String, String> birthdays = new HashMap<>();
    birthdays.put("12032021", "Ajay");
    birthdays.put("12032022", "Vijay");
    birthdays.put("05032024", "Mohan");
    birthdays.put("11031991", "Kumar");
    birthdays.put("12032088", "Shyam");
    birthdays.put("12032011", "Raju");
    birthdays.put("11032031", "Bipin");

    System.out.println(sameBirthdays(birthdays));
  }

}
