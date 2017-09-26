package rssfeedreader.habibqureshi.rssfeedreaeder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by HabibQureshi on 9/26/2017.
 */

public class categorySelection extends Fragment {
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10;
    View fragment_view;
    MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragment_view = inflater.inflate(R.layout.category_fragment,
                container, false);
        if (getActivity() instanceof MainActivity) {
            activity = (MainActivity) getActivity();
        }

        iv1= (ImageView) fragment_view.findViewById(R.id.business);
        iv2= (ImageView) fragment_view.findViewById(R.id.cricket);
        iv3= (ImageView) fragment_view.findViewById(R.id.heath);
        iv4= (ImageView) fragment_view.findViewById(R.id.internet);
        iv5= (ImageView) fragment_view.findViewById(R.id.latestnews);
        iv6= (ImageView) fragment_view.findViewById(R.id.news);
        iv7= (ImageView) fragment_view.findViewById(R.id.people);
        iv8= (ImageView) fragment_view.findViewById(R.id.south);
        iv9= (ImageView) fragment_view.findViewById(R.id.sports);
        iv10= (ImageView) fragment_view.findViewById(R.id.tech);
        iv1.setOnClickListener(thisFragmentClick);
        iv2.setOnClickListener(thisFragmentClick);
        iv3.setOnClickListener(thisFragmentClick);
        iv4.setOnClickListener(thisFragmentClick);
        iv5.setOnClickListener(thisFragmentClick);
        iv6.setOnClickListener(thisFragmentClick);
        iv7.setOnClickListener(thisFragmentClick);
        iv8.setOnClickListener(thisFragmentClick);
        iv9.setOnClickListener(thisFragmentClick);
        iv10.setOnClickListener(thisFragmentClick);


        return fragment_view;
    }
    View.OnClickListener thisFragmentClick= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment=new displayContent();
            Bundle bundle=new Bundle();
            bundle.putString("link",v.getContentDescription().toString());
            fragment.setArguments(bundle);
            activity.changeSupportFragment(fragment,true);


        }
    };
}
