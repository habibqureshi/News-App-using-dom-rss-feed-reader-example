package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



/**
 * Created by HabibQureshi on 8/13/2017.
 */

public class feedAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflator;
    List<gadgets360> data;
    TextView tittle,pubDate,category,desc;
    ImageView iv;
    Bitmap loading;
    public feedAdapter(Context context,  List<gadgets360> data) {
        this.inflator=inflator.from(context);
        this.data=data;
        this.context=context;
        this.loading=BitmapFactory.decodeResource(context.getResources(),R.drawable.loading);//loading img
    }
    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null) {
            convertView = inflator.inflate(R.layout.design_layout, parent, false);
            tittle = (TextView) convertView.findViewById(R.id.title);
            pubDate = (TextView) convertView.findViewById(R.id.pubDate);
            category = (TextView) convertView.findViewById(R.id.category);
            desc = (TextView) convertView.findViewById(R.id.description);
            iv = (ImageView) convertView.findViewById(R.id.img);
            myViewHolder = new MyViewHolder(tittle,pubDate,category,desc,iv);
            convertView.setTag(myViewHolder);
        }
        else {
            myViewHolder = (MyViewHolder)convertView.getTag();
            Log.e("getView  ","vIEW reStored = ");
        }
        myViewHolder.tittle.setText(this.data.get(position).getTittle());
        myViewHolder.pubDate.setText(this.data.get(position).getPubDate());
        myViewHolder.category.setText(this.data.get(position).getCategory());
        myViewHolder.desc.setText(this.data.get(position).getDescription());
        if (storeBitmaps.gadgets360Bitmaps[position]==null) {//checking if img is already downloaded or not
            myViewHolder.iv.setImageBitmap(this.loading);//setting loading img to ImageView
            new DownloadImagesTask(myViewHolder.iv, position,this.data.get(position).getStoryImage()).execute();//downloading img from web
        }
        else myViewHolder.iv.setImageBitmap(storeBitmaps.gadgets360Bitmaps[position]);//if img is already downloaded then show it


        return convertView;
    }
    public class DownloadImagesTask extends AsyncTask<ImageView, Void, ImageView> {
        ImageView iv=null;
        Bitmap bitmap=null;
        String url=null;
        int position=0;

        public DownloadImagesTask(ImageView iv,int position,String url) {
            this.iv = iv;
            this.position=position;
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            Log.e("aya",url);
        }

        @Override
        protected ImageView doInBackground(ImageView... url) {
            try {
                    Log.e("url", this.url);
                    URL ulrn = new URL(this.url);
                    HttpURLConnection con = (HttpURLConnection) ulrn.openConnection();
                    InputStream is = con.getInputStream();
                    this.bitmap = BitmapFactory.decodeStream(is);
                    if (null != this.bitmap)
                    {
                        return iv;
                    }
                    con.disconnect();
            }catch(Exception e){}
            finally {

            }
            return null;
        }




        @Override
        protected void onPostExecute(ImageView result) {
            if(result!=null) {
                this.iv.setImageBitmap(bitmap);
                storeBitmaps.gadgets360Bitmaps[position]=bitmap;//store img to bitmaps array so we can use it again
            }
            else
                iv.setImageResource(R.drawable.loading);//if img is failed to download set loading img to ImageView
        }


    }




}

