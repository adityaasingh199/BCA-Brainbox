package com.bcajagn.brainbox.creators;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bcajagn.brainbox.helper.BaseActivity;
import com.bcajagn.brainbox.R;

import java.util.ArrayList;

public class CreatorActivity extends BaseActivity {
    String[] nameary = {
            "Abhisek Kr Gupta",

            "Aditya Singh",

            "Jayant Baranwal"


    };
  /*  String[] roleary = {
            "Front End",

            "Back End",

            "Notes Creator",

            "Notes Creator",

            "Notes Creator",

            "Notes Creator"
    }; */
    String[] gtary = {
            "Git-hub :- https://github.com/Dev-Abhisek",

            "Git-hub :- https://github.com/adityaasingh199",

            "Git-hub :- https://github.com/jayantbaranwal12345"
    };
    String[] lkary = {
            "LinkedIn:- https://www.linkedin.com/in/abhisek-kr-gupta",

            "LinkedIn:- https://www.linkedin.com/in/adityaasingh199/",

            "LinkedIn:- https://www.linkedin.com/in/visitjayantr/"



    };

    String[] notesproviderary = {
            "Sushant Yadav",

            "Parmatma Yadav ",

            "Abhay Srivastava"



    };


    int[] profilepic = {R.drawable.profile_1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile_4,
            R.drawable.profile_5};
    ListView listView;
    TextView notesprovider;
    ArrayList<creatormodal> modal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creators);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Creators");
        setSupportActionBar(toolbar);//setting custpom toolbar
        listView = findViewById(R.id.listview);
        View footerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);
        listView.addFooterView(footerView);//adding footer in listview for notes providers
        notesprovider = footerView.findViewById(R.id.notesprovider);
        loadcreators(listView);
        addnotesprovider(notesprovider);
    }

    private void loadcreators(ListView listView) {
        creatormodal s = null;
        for (int i = 0; i <= nameary.length - 1; i++) {
            s = new creatormodal();
            s.setId(0);
            s.setName(nameary[i]);
          //  s.setRole(roleary[i]);
            s.setGithub(gtary[i]);
            s.setLinkedin(lkary[i]);
            s.setProfile(profilepic[i]);
            modal.add(s);
        }
        CreatorAdapter adapter = new CreatorAdapter(CreatorActivity.this, modal);
        listView.setAdapter(adapter);

    }

    public void addnotesprovider(TextView textView) {
        String providers = "";
        for (int i = 0; i <= notesproviderary.length - 1; i++) {
            providers = providers + "◉ " + notesproviderary[i] + "\n";
        }
        textView.setText(providers);
    }


}