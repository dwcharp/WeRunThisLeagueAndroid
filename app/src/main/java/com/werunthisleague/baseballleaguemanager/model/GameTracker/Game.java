package com.werunthisleague.baseballleaguemanager.model.GameTracker;

import java.util.LinkedList;

public class Game {
  LinkedList<Inning> innings;
  int inning;
  int outs;
  int strikes;
  int balls;
  boolean awayAtBat;
  Inning currentInning;

  public Game() {
    inning = 0;
    innings = new LinkedList<>();
    addInning();
  }

  public Integer updateOuts(int type) {
    if (++outs == 3) {
      outs = 0;
      awayAtBat = !awayAtBat;
      addInning();
    }
    return outs;

  }

  public Integer updateStrikes() {
    if(++strikes == 3) {
      updateOuts(4);
      strikes = 0;
    }
    return  strikes;
  }

  public Integer updateBalls() {
    if(++balls == 4) {
      balls = 0;
      nextAtBat();
    }
    return balls;
  }

  private void addInning() {
    if(awayAtBat)
      inning++;
   currentInning = new Inning(inning, awayAtBat);
   innings.add(currentInning);
  }

  private void nextAtBat() {

  }

}
