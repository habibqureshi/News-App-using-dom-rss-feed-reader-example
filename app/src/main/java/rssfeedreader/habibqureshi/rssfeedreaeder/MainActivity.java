package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


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
        this.changeSupportFragment(new categorySelection(),true);


    }
    void downloadRss(String url,displayContent dis) {
        new getRssFeed(dis).execute(url);
    }

    public void changeSupportFragment(android.support.v4.app.Fragment frag,
                                      Boolean addToStack) {
        ft = fm.beginTransaction();
        ft.replace(R.id.frame, frag);
        if (addToStack) {
            ft.addToBackStack(null);

        }
        ft.commitAllowingStateLoss();
    }
    public void showProgresMessage(String message) {
        progress = new ProgressDialog(this);
        progress.setMessage(message);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(false);
        progress.setCanceledOnTouchOutside(false);
        progress.show();
    }
    public Boolean isProgressShowing()
    {
        if(this.progress!=null)
            if(this.progress.isShowing())
                return true;
        return false;
    }
    public void updateProgressMessage(final String s)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.setMessage(s);
            }
        });
    }
    public void cancleProgressMessage() {
        if (progress != null)
            if (progress.isShowing())
                this.progress.cancel();
    }


}


