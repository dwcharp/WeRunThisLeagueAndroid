package com.werunthisleague.baseballleaguemanager.model.GameTracker;

import java.util.LinkedList;

public class Inning {
  LinkedList<AtBat> atBats;
  AtBat currentAtBat;
  int inning;
  boolean topInning;

  public Inning(int inning , boolean topInning) {
    this.inning = inning;
    this.topInning = topInning;
    atBats = new LinkedList<>();
    addAtBat();
  }

  private void addAtBat() {
    currentAtBat = new AtBat();
    atBats.add(currentAtBat);
  }

}
