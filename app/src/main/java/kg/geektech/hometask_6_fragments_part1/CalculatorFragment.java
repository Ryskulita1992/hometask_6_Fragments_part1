package kg.geektech.hometask_6_fragments_part1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {
    private String operation = "";
    private float num1 = 0, num2 = 0;
    private float result = 0;
    TextView textView;
    String saveString, savedInfo;
    Button save;

    InterfaceCalculatorFragment interfaceCalculatorFragment;

    public CalculatorFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_result__share_, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final MainActivity mainActivity = (MainActivity) getActivity();
        if (savedInstanceState!= null)
            saveString = savedInstanceState.getString("saved_String");
        textView.setText(saveString);
        Log.d("lulu", "getting  string value  and saving in (saveString field)  in case of screen orientation will be changed by Bundle savedInstanceState ");

        textView = view.findViewById(R.id.editText);
        onClick(view);
        Log.d("lulu", "must implement the onClick method");

        save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedInfo= textView.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("savedInfo", savedInfo);
                Log.d("lulu", "syntax of save button , saving result of editText and putting through bundle, in order to make possible for another fragments to get value from here ");



            }
        });
    }
        public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                textView.append("1");
                break;
            case R.id.two:
                textView.append("2");
                break;
            case R.id.three:
                textView.append("3");
                break;
            case R.id.four:
                textView.append("4");
                break;
            case R.id.five:
                textView.append("5");
                break;
            case R.id.six:
                textView.append("6");
                break;
            case R.id.seven:
                textView.append("7");
                break;
            case R.id.eight:
                textView.append("8");
                break;
            case R.id.nine:
                textView.append("9");
                break;
            case R.id.zero:
                textView.append("0");
                break;
            case R.id.increment:
                textView.setText("-" + textView.getText());
                break;
            case R.id.minus:
                operation = "-";
                textView.append("-");
                break;
            case R.id.plus:
                operation = "+";
                textView.append("+");
                break;
            case R.id.multiply:
                operation = "*";
                textView.append("*");
                break;
            case R.id.divide:
                operation = "/";
                textView.append("/");
                break;
            case R.id.equals:
                if (textView.length()==0){
                    textView.setText(""); }
                else {
                    String[] values = textView.getText().toString().split(Pattern.quote(operation));
                    num1 = Integer.valueOf(values[0]);
                    num2 = Integer.valueOf(values[1]);
                    textView.append("=");
                    equal();}
                break;
            case R.id.percent:
                operation = "%";
                textView.append("%");
                break;
            case R.id.AC:
                textView.setText("");
                break;
            case R.id.comma:
                if (textView.length()==0){
                    textView.setText("");
                }else {
                    textView.setText(",");
                    break;}
            case R.id.save:
                String saveButton= textView.getText().toString();
                Intent save =new Intent();
                save.putExtra("Saved", saveButton);
                Log.d("save", "");
                break;}}
    private void equal()
    { try {
        if (operation == "+") {
            result = num1 + num2;
        } else if (operation.equals("*") ) {
            result = num1 * num2;
        }else if(operation.equals(" * 0")){
            result=0;
        } else if (operation.equals("-")) {
            result = num1 - num2;
        } else if (operation.equals("/")) {
            result = num1 / num2;
        }else if (operation.equals("/0")){
            result=0;
        }else if (operation.equals("*")) {
            result = num1 * num2;
        } else if (operation.equals("%")) {
            result = (num1 / 100) * num2; }
        textView.append(String.valueOf(result));
    } catch (Exception e) { e.printStackTrace(); } }

    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saved_String", textView.getText().toString());
        Log.d("lulu", "putting the string value by bundle outState");

    }



    @Override
    public void onAttach(Context context) {// to check if interface implementing by parent Activity
        super.onAttach(context);
        Activity activity = (Activity) context; // getting activity instance from context
        try {
            interfaceCalculatorFragment= (InterfaceCalculatorFragment) activity;//getting call pack for the interface


        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+ "must override InterfaceCalculatorFragment");
        }

    }





}



