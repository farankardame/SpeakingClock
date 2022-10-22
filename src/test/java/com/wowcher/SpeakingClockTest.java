package com.wowcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeakingClockTest {

  private SpeakingClock speakingClock;

  @Before
  public void before(){
    speakingClock = new SpeakingClock();
  }

  @Test
  public void testCurrentTimeInWordsForInvalidHours(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords("44:00"));
  }

  @Test
  public void testCurrentTimeInWordsForInvalidMins(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords("12:88"));
  }

  @Test
  public void testCurrentTimeInWordsForEmptyString(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords(""));
  }

  @Test
  public void testCurrentTimeInWordsForMissingColon(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords("1230"));
  }

  @Test
  public void testCurrentTimeInWordsForInvalidLength(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords("8:30"));
  }

  @Test
  public void testCurrentTimeInWordsForTimeWithSeconds(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords("08:30:28"));
  }

  @Test
  public void testCurrentTimeInWordsForInvalidMidnightTime(){
    Assert.assertEquals("Invalid Current Time", speakingClock.currentTimeInWords("24:00"));
  }

  @Test
  public void testCurrentTimeInWordsForMidnight(){
    Assert.assertEquals("It's Midnight", speakingClock.currentTimeInWords("00:00"));
  }

  @Test
  public void testCurrentTimeInWordsForMidday(){
    Assert.assertEquals("It's Midday", speakingClock.currentTimeInWords("12:00"));
  }

  @Test
  public void testCurrentTimeInWordsForMorning(){
    Assert.assertEquals("It's eight thirty four", speakingClock.currentTimeInWords("08:34"));
  }

  @Test
  public void testCurrentTimeInWordsForAfternoon(){
    Assert.assertEquals("It's twelve fifty five", speakingClock.currentTimeInWords("12:55"));
  }

  @Test
  public void testCurrentTimeInWordsForEvening(){
    Assert.assertEquals("It's eighteen o'nine", speakingClock.currentTimeInWords("18:09"));
  }

  @Test
  public void testCurrentTimeInWordsForOClock(){
    Assert.assertEquals("It's seventeen o'clock", speakingClock.currentTimeInWords("17:00"));
  }

  @Test
  public void testCurrentTimeInWordsForMinsUnderTen(){
    Assert.assertEquals("It's seventeen o'five", speakingClock.currentTimeInWords("17:05"));
  }

  @Test
  public void testCurrentTimeInWordsPastMidnight(){
    Assert.assertEquals("It's twelve o'five", speakingClock.currentTimeInWords("00:05"));
  }
}
