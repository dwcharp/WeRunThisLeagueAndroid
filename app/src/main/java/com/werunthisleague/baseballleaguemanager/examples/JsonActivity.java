package com.werunthisleague.baseballleaguemanager.examples;

import com.werunthisleague.baseballleaguemanager.R;
import com.werunthisleague.baseballleaguemanager.model.application.Team;
import com.werunthisleague.baseballleaguemanager.service.DataService;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class JsonActivity extends Activity {
    private TextView teamName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        teamName = (TextView) findViewById(R.id.json_text);

        StrictMode.ThreadPolicy policy = new StrictMode.
                ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Team team = DataService.getTeamInfo();
        teamName.setText(team.name);
    }
}
