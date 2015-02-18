package com.werunthisleague.baseballleaguemanager.service;

import com.google.gson.Gson;
import com.werunthisleague.baseballleaguemanager.model.application.Team;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class DataService {
    public static Team getTeamInfo() {
        Team[] teams = null;
        Gson gson = new Gson();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://werunthisleague.com/teams/");

        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                teams = gson.fromJson(reader, Team[].class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teams[2];
    }
}
