package com.wowcher;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class SpeakingClock {

  private static final String INVALID_CURRENT_TIME = "Invalid Current Time";

  private static final String[] ONES = new String[] {" ", "one", "two", "three", "four",
      "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
      "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

  private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  public String currentTimeInWords(final String currentTime){

    if(!isCurrentTimeValid(currentTime)) return INVALID_CURRENT_TIME;

    List<String> hourAndMin = Pattern.compile(":")
        .splitAsStream(currentTime)
        .collect(Collectors.toList());

    if (hourAndMin.size() != 2) return  INVALID_CURRENT_TIME;

    int hourInteger = Integer.parseInt(hourAndMin.get(0));
    int minInteger = Integer.parseInt(hourAndMin.get(1));

    if(hourInteger > 23) return INVALID_CURRENT_TIME;
    if(minInteger > 60) return INVALID_CURRENT_TIME;

    if(isMidnight(hourInteger, minInteger)) return "It's Midnight";
    if(isMidday(hourInteger, minInteger)) return "It's Midday";

    return "It's " + getHourFromHourInteger(hourInteger) + " " + getMinsFromMinsInteger(minInteger);
  }

  private String getHourFromHourInteger(int integerValue) {
    if(integerValue == 0) return "twelve";
    if (integerValue > 19) {
      return TENS[integerValue / 10] + " " + ONES[integerValue % 10];
    }
    return ONES[integerValue];
  }

  private String getMinsFromMinsInteger(int integerValue) {
    if(integerValue == 0) return "o'clock";
    if(integerValue < 10) return "o'" +ONES[integerValue];
    if (integerValue > 19) return TENS[integerValue / 10] + " " + ONES[integerValue % 10];
    return ONES[integerValue];
  }

  private boolean isMidnight(final int hourInteger, final int minInteger){
    return (hourInteger == 0 && minInteger == 0);
  }

  private boolean isMidday(final int hourInteger, final int minInteger){
    return (hourInteger == 12 && minInteger == 0);
  }

  private boolean isCurrentTimeValid(String currentTime) {
    if(StringUtils.isBlank(currentTime))  return false;
    if(!currentTime.contains(":"))  return false;
    return currentTime.length() == 5;
  }
}
