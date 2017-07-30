package test_work_project.testworkproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test_work_project.testworkproject.R;

public class LiveChatFragment extends Fragment {

    public static final int LAYOUT = R.layout.fragment_live_chat;

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        return view;
    }

    public static LiveChatFragment getInstance() {
        Bundle args = new Bundle();
        LiveChatFragment fragment = new LiveChatFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
