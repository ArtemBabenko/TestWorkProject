package test_work_project.testworkproject.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import test_work_project.testworkproject.R;
import test_work_project.testworkproject.adapter.PersonalRecyclerAdapter;
import test_work_project.testworkproject.item.User;

public class PersonalChatFragment extends Fragment {

    public static final int LAYOUT = R.layout.fragment_prsonal_chat;

    private View view;
    private String chatName;
    private ArrayList<User> list_elements = new ArrayList<User>();

    private RecyclerView recycler;
    private PersonalRecyclerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        includeArrow();
        includeName();
        addData();
        createRecycler();
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

    private void includeName() {
        TextView name = (TextView) view.findViewById(R.id.chat_name);
        chatName = getArguments().getString("name");
        name.setText(chatName);
    }

    private void addData() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                list_elements.add(new User("", "Donec facilisis tortor ut augue lacinia, at viverra est semper. Sed sapien metus, scelerisque?", "", 0, 1));
            } else
                list_elements.add(new User("", "Donec facilisis tortor ut augue lacinia, at viverra est semper. Sed sapien metus, scelerisque?", "16:04", 0, 2));
        }
    }

    private void createRecycler() {
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutMenager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutMenager);
        recycler.setHasFixedSize(true);

        adapter = new PersonalRecyclerAdapter(list_elements);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
