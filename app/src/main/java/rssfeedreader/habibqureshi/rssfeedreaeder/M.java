package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by HabibQureshi on 9/19/2017.
 */

public class M {

    public static void t(Context context, String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
    public static void l(String message)
    {
        Log.e("Habib",message);
    }
    public static void l(String tag,String message)
    {
        Log.e("Habib "+tag+" ",message);
    }

}
