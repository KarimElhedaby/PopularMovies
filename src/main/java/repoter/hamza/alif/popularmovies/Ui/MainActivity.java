package repoter.hamza.alif.popularmovies.Ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import repoter.hamza.alif.popularmovies.R;
import repoter.hamza.alif.popularmovies.Ui.Top_rated_Ui.MainRatedFragment;
import repoter.hamza.alif.popularmovies.firebase.RegisterActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    protected NavigationView navigationView;
    //@BindView(R.id.navTV)
     TextView navTv ;
    RegisterActivity registerActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        navTv =(TextView) header.findViewById(R.id.navTV);
        SharedPreferences prfs = getSharedPreferences("Nav_Mail", 0);
        String nav_mail = prfs.getString("nav_mail", "");
        navTv.setText(nav_mail);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_popular) {
            MainFragment moviesFragment = MainFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, moviesFragment).addToBackStack(null)
                    .commit();
            return true;
        }

        else if (id == R.id.nav_toprated) {
            MainRatedFragment ratedfragment = MainRatedFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, ratedfragment).addToBackStack(null)
                    .commit();
            return true;
        }

        else if (id == R.id.nav_favourite) {}
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
