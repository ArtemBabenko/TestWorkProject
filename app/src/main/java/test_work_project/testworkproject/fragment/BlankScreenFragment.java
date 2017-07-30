package test_work_project.testworkproject.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import test_work_project.testworkproject.R;

public class BlankScreenFragment extends Fragment {

    public static final int LAYOUT = R.layout.fragment_blank_screen;

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        includeArrow();
        return view;
    }

    private void includeArrow() {
        ImageView arrow = (ImageView) view.findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.arrow) {
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });
    }

}
