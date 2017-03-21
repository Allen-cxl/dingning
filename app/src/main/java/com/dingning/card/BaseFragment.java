package com.dingning.card;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;

import com.dingning.card.model.Student;

import java.io.File;

/**
 * Created by Allen on 2016/12/12.
 */

public class BaseFragment extends Fragment {


    public CustomApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (CustomApplication) (getActivity()).getApplication();
    }

    public void onBack(){
        getFragmentManager().popBackStack();
    }

    public void enterFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction().addToBackStack(null)  //将当前fragment加入到返回栈中
                .replace(R.id.fragment, fragment).commit();
    }

}
