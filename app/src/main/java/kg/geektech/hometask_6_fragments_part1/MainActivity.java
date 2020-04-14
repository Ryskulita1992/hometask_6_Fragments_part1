package kg.geektech.hometask_6_fragments_part1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ResultShareInterface , InterfaceCalculatorFragment{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.result_last_page)!=null){
            if (savedInstanceState!=null){
                return;
            }

            FragmentManager manager= getSupportFragmentManager();
            Log.d("lulu", " Fragment manager class which manage the fragments and their location in storage");
            FragmentTransaction transaction =manager.beginTransaction();// (transaction.remove(); transaction.add() and others)
            Log.d("lulu", "list of FragmentTransactions");
            transaction.replace(R.id.calculator_container, new CalculatorFragment());
            Log.d("lulu", "filling  up the calculator_container  with  new CalculatorFragment");
            transaction.commit();
            Log.d("lulu", "saving all written transactions and sending to manager and FM will realize these functions in order");
        }
    }
    @Override
    public void resultShareInterface(String result) {
        try {
            Bundle bundle=new Bundle();
            Bundle resultFromBundle=bundle.getBundle("savedInfo");
            Log.d("lulu", "getting the (savedInfo) by bundle in order to send to appShare");
            Intent appShare=new Intent();
            appShare.setAction(Intent.ACTION_SEND);
            appShare.putExtra(Intent.EXTRA_TEXT, resultFromBundle);
            appShare.setType("text/plain");
            if (appShare.resolveActivity(getPackageManager())!=null){
                startActivity(appShare); }
            Log.d("lulu", "intent appShare for sending result");
        }catch (ClassCastException e) {
        }
    }
    @Override
    public void onCalculatorFragment(String result) {

    }

    @Override
    public void openFragmentCalculator() {

    }




}



