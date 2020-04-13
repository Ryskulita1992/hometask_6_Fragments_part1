package kg.geektech.hometask_6_fragments_part1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Result_Share_Fragment  extends Fragment {
   Button shareIntent, resultShareToApp;
   TextView resultFieldToShare;

    ResultShareInterface resultShareListener;
    Integer receivedInfo;



    public Result_Share_Fragment() {
        // Required empty public constructor
    }
    public interface onMessageReadListener{  // establishing the communication between fragment and activity
        public  void onMessageRead (String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_result__share_, container, false);
        resultFieldToShare=view.findViewById(R.id.result_text_view_last_page);
        shareIntent=view.findViewById(R.id.result_share_last_page);
        Bundle bundle = getArguments();
        if (bundle != null) {
            receivedInfo = bundle.getInt("savedInfo");
            resultFieldToShare.setText(receivedInfo);

        }
        shareIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT, receivedInfo);
                        intent.setType("text/plain");
                        startActivity(intent);
                    }
    });
     return  view;
    }
 @Override
 public void onAttach(Context context) {// to check if interface implementing by parent Activity
       super.onAttach(context);
      Activity activity = (Activity) context; // getting activity instance from context
    try {
     resultShareListener= (ResultShareInterface) activity;//getting call pack for the interface

        }catch (ClassCastException e)
    {
           throw new ClassCastException(activity.toString()+ "must override ResultShareInterface");
       }

  }




}
