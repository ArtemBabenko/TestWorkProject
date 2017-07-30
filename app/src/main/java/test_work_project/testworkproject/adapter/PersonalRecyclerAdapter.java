package test_work_project.testworkproject.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test_work_project.testworkproject.ChatActivity;
import test_work_project.testworkproject.R;
import test_work_project.testworkproject.item.User;

public class PersonalRecyclerAdapter extends RecyclerView.Adapter<PersonalRecyclerAdapter.ViewHolder> {

    public static final int POSITION_LEFT = 1;
    public static final int POSITION_RIGHT = 2;

    private List<User> userList;
    private int score = 0;

    public PersonalRecyclerAdapter(List<User> userList) {
        this.userList = userList;
        checkMessageScore(userList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == POSITION_LEFT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_element_personal_left, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_element_personal_right, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User message = userList.get(position);
        if(message.getPosition() == 1 || message.getPosition() == 2){
            holder.userMessage.setText(message.getMessage());
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (userList.get(position).getPosition() == POSITION_LEFT) {
            return POSITION_LEFT;
        } else
            return POSITION_RIGHT;
    }

    private void checkMessageScore(List<User> userList) {
        for (User user : userList) {
            if (user.getWaitingMessage() != 0) {
                score += user.getWaitingMessage();
            }
        }
        ChatActivity.addMessageScore(score);
        score = 0;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userMessage;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            userMessage = (TextView) itemView.findViewById(R.id.user_message);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
    }


}