package rssfeedreader.habibqureshi.rssfeedreaeder;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by HabibQureshi on 9/26/2017.
 */

public class displayContent extends Fragment implements returnData{
    ListView list;
    View fragment_view;
    MainActivity activity;
    List<gadgets360> data;
    feedAdapter adapter;
    String url;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragment_view = inflater.inflate(R.layout.display_content,
                container, false);
        if (getActivity() instanceof MainActivity) {
            activity = (MainActivity) getActivity();
        }
        activity.showProgresMessage("Loading");//showing progress
        this.list= (ListView) fragment_view.findViewById(R.id.listView);
        url=getArguments().getString("link");//getting link from bundle
        activity.downloadRss(url,this);//calling function to get rss
        return fragment_view;
    }
    /*
        This function will auto call when rss will be available ,

         */

    @Override
    public void getData(List list) {
        this.data = list;
        M.l("main");
        activity.cancelProgressMessage();
        // init bitmap array so i can show loading img until the img is not loaded from web
        storeBitmaps.gadgets360Bitmaps = new Bitmap[this.data.size()];
        for (int i = 0; i < data.size(); i++) {
            data.get(i).printData();
            adapter = new feedAdapter(activity.getApplicationContext(), data);
            this.list.setAdapter(adapter);


        }
    }
}
