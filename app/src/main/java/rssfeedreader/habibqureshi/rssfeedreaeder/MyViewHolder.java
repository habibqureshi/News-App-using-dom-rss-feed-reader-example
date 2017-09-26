package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HabibQureshi on 8/13/2017.
 */

public class MyViewHolder {
    TextView tittle,pubDate,category,desc;
    ImageView iv;
    public MyViewHolder(TextView tittle, TextView pubDate, TextView category, TextView desc, ImageView iv) {
        this.tittle = tittle;
        this.pubDate = pubDate;
        this.category = category;
        this.desc = desc;
        this.iv = iv;
    }
}
