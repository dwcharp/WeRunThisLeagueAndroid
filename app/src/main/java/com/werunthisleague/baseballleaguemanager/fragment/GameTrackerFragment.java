package com.werunthisleague.baseballleaguemanager.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.werunthisleague.baseballleaguemanager.R;
import com.werunthisleague.baseballleaguemanager.controller.GameController;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameTrackerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameTrackerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameTrackerFragment extends Fragment implements View.OnClickListener{
  public static int [][] buttonIds = {
      {
        R.id.strike_button,
        R.id.ball_button,
        R.id.foul_button,
        R.id.in_play_button
      },
      {
        R.id.hit_button,
        R.id.fly_out_button,
        R.id.ground_out,
        R.id.line_out
      },
      {
        R.id.single_button,
        R.id.double_button,
        R.id.tripple_button,
        R.id.home_run_button
      }
  };

  public static int [] textViewIds = {
    R.id.BallView,
    R.id.StrikeView
  };

  public static HashMap <Integer, Button> buttons;
  public static HashMap <Integer, TextView> textViews;

  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment GameTrackerFragment.
   */
  private GameController gameController;

  // TODO: Rename and change types and number of parameters
  public static GameTrackerFragment newInstance(String param1, String param2) {
    GameTrackerFragment fragment = new GameTrackerFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  public GameTrackerFragment() {
    buttons = new HashMap<>();
    textViews = new HashMap<>();
    gameController = new GameController();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_game_tracker, container, false);
    setUpButtons(view);
    gameController.initButtonState();
    return view;
  }


  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
      mListener = (OnFragmentInteractionListener) activity;
    } catch (ClassCastException e) {
      throw new ClassCastException(activity.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p/>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  private void setUpButtons(View view) {
    for( int ids[] : buttonIds) {
      for(int id :ids) {
        Button b = (Button) view.findViewById(id);
        b.setOnClickListener(this);
        buttons.put(id, b);
      }
    }

    for( int id : textViewIds) {
      TextView v = (TextView) view.findViewById(id);
      textViews.put(id, v );
    }
  }

  @Override
  public void onClick(View v) {
    gameController.onClick(v.getId());
  }

  public interface OnFragmentInteractionListener {
    public void onFragmentInteraction(String s);
  }

}
