package kg.geektech.hometask_6_fragments_part1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calculator_Share_Buttons extends Fragment {
    String result;
    Interface_Calculator_Share_buttons interface_calculator_share_buttons;

    public Calculator_Share_Buttons() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator__share__buttons, container, false);
    }
 @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
     super.onViewCreated(view, saveInstanceState);
     Button buttonCalculator = view.findViewById(R.id.button1_calculator_share_fragment);
     Button buttonShare = view.findViewById(R.id.button2_calculator_share_fragment);

     buttonCalculator.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            MainActivity activity=(MainActivity)getActivity();
             activity.openFragmentCalculator();
             Log.d("lulu", "must work buttonCalculator in Calculator_Share_buttons");


         }
     });
     buttonShare.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             Bundle bundle = new Bundle();
             bundle.getBundle("savedInfo");
             Log.d("lulu", "must work buttonShare in Calculator_Share_buttons");
         }
     });
 }

    @Override
    public void onAttach(Context context) {// to check if interface implementing by parent Activity
        super.onAttach(context);
        Activity activity = (Activity) context; // getting activity instance from context
        try {
            interface_calculator_share_buttons= (Interface_Calculator_Share_buttons) activity;//getting call pack for the interface


        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+ "must override InterfaceCalculatorFragment");
        }

    }
}





