package com.grofers.slidenerd;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        //now tell the android that not using its actionbar
        setSupportActionBar(toolbar);


        //to show home button in toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //to identify the navigational drawer
        NavigationDrawerFragmnet drawerFragmnet = (NavigationDrawerFragmnet) getSupportFragmentManager().findFragmentById(R.id.fragment_navigational_drawer);

        drawerFragmnet.setUp(R.id.fragment_navigational_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), toolbar);

    }


    //overide this method to link the "just" menu layout to something into action
    // src - android in 5 mins

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        //to inflate the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    //in order to capture the clicks on menu (right side wala menu)  items, we need to override the following method
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_1:
                Toast.makeText(MainActivity.this, "menu 1 selected", Toast.LENGTH_SHORT).show();
                break;


            case R.id.menu_2:
                Toast.makeText(MainActivity.this, "menu 2 selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
