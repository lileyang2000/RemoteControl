package com.zte.remotecontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



/**
 * Created by lileyang on 2016/10/13.
 */
public class RemoteControlFragment extends Fragment {
    private TextView mSelectedTextView;
    private TextView mWorkingTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_remote_control,container,false);

        mSelectedTextView = (TextView)v.findViewById(R.id.fragment_remote_control_selectedTextView);
        mWorkingTextView = (TextView)v.findViewById(R.id.fragment_remote_control_workingTextView);

        View.OnClickListener numberButtonListener = new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                TextView textView = (TextView)view;
                String working = mWorkingTextView.getText().toString();
                String text = textView.getText().toString();

                if(working.equals("0")){
                    mWorkingTextView.setText(text);
                }else{
                    mWorkingTextView.setText(working+text);
                }
            }
        };

        Button zeroButton = (Button)v.findViewById(R.id.fragment_remote_control_zeroButton);
        zeroButton.setOnClickListener(numberButtonListener);

        Button oneButton = (Button)v.findViewById(R.id.fragment_remote_control_oneButton);
        oneButton.setOnClickListener(numberButtonListener);

        Button enterButton = (Button)v.findViewById(R.id.fragment_remote_control_enterButton);
        enterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                CharSequence working = mWorkingTextView.getText();
                if(working.length()>0){
                    mSelectedTextView.setText(working);
                }
                mWorkingTextView.setText("0");
            }
        });

        return v;

    }
}