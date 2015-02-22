package com.werunthisleague.baseballleaguemanager.controller;

import com.werunthisleague.baseballleaguemanager.R;
import com.werunthisleague.baseballleaguemanager.fragment.GameTrackerFragment;
import com.werunthisleague.baseballleaguemanager.model.GameTracker.Game;

public class GameController {
  Game game;

  public  GameController() {
    game = new Game();
  }

  public void onClick(int id) {
    switch (id) {
      case R.id.strike_button : updateStrikes();
          break;
      case R.id.ball_button : updateBalls();
          break;
      case R.id.foul_button : updateStrikes();
          break;
      case R.id.in_play_button : inPlay();
          break;
      case R.id.hit_button : onHit();
          break;
      case R.id.fly_out_button : updateOuts(0);
        break;
      case R.id.ground_out : updateOuts(0);
        break;
      case R.id.line_out : updateOuts(0);
        break;
      case R.id.single_button : onHitType(0);
        break;
      case R.id.double_button : onHitType(0);
        break;
      case R.id.tripple_button : onHitType(0);
        break;
      case R.id.home_run_button : onHitType(0);
        break;
      default:
        break;
    }
  }

  public void initButtonState() {
    toggleHitTypeButtons(false);
    togglePlayTypeButtons(false);
  }

  private void updateStrikes() {
    GameTrackerFragment.textViews.get(R.id.StrikeView).setText(game.updateStrikes().toString());
  }

  private void updateBalls() {
    GameTrackerFragment.textViews.get(R.id.BallView).setText(game.updateBalls().toString());
  }

  private void updateOuts(int type) {

  }

  private void onHit() {
    toggleHitTypeButtons(true);
  }

  private void onHitType(int type) {
    toggleHitTypeButtons(false);
    togglePlayTypeButtons(false);
  }

  private void inPlay() {
    togglePlayTypeButtons(true);
  }

  private void toggleHitTypeButtons(boolean enabled) {
    for(int button : GameTrackerFragment.buttonIds[2]) {
      GameTrackerFragment.buttons.get(button).setEnabled(enabled);
    }
  }

  private void togglePlayTypeButtons(boolean enabled) {
    for(int button : GameTrackerFragment.buttonIds[1]) {
      GameTrackerFragment.buttons.get(button).setEnabled(enabled);
    }
  }
}
