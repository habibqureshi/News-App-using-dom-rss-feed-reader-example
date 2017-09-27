package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    FragmentManager fm;
    FragmentTransaction ft;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.fm = getSupportFragmentManager();
        ft=fm.beginTransaction();
        this.changeSupportFragment(new categorySelection(),false);   //function calls for changing the fragment


    }
    /*
    This function call to download ResFeed with in the mainActivity or its fragments, it takes url and fragrament context
    for Callback Result

     */
    void downloadRss(String url,displayContent dis) {
        new getRssFeed(dis).execute(url);
    }
    /*
        This function used to change the fragment

         */
    public void changeSupportFragment(android.support.v4.app.Fragment frag,
                                      Boolean addToStack) {
        ft = fm.beginTransaction();
        ft.replace(R.id.frame, frag);
        if (addToStack) {
            ft.addToBackStack(null);

        }
        ft.commitAllowingStateLoss();
    }
    /*
        This function display progress Message

         */
    public void showProgresMessage(String message) {
        progress = new ProgressDialog(this);
        progress.setMessage(message);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(false);
        progress.setCanceledOnTouchOutside(false);
        progress.show();
    }
    /*
         This function cancel the progress message

          */
    public void cancelProgressMessage() {
        if (progress != null)
            if (progress.isShowing())
                this.progress.cancel();
    }


}


