package test_work_project.testworkproject.adapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test_work_project.testworkproject.ChatActivity;
import test_work_project.testworkproject.R;
import test_work_project.testworkproject.fragment.PersonalChatFragment;
import test_work_project.testworkproject.item.User;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<User> userList;
    private Context context;
    private int score = 0;

    public RecyclerAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
        checkMessageScore(userList);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element_main_chat, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final User message = userList.get(position);
        holder.userName.setText(message.getName());
        holder.userMessage.setText(message.getMessage());
        holder.messageTime.setText(message.getMessageTime());
        holder.waitingMessage.setText(String.valueOf(message.getWaitingMessage()));

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", message.getName());
                FragmentManager fm = ((ChatActivity) context).getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                PersonalChatFragment fragment = new PersonalChatFragment();
                fragment.setArguments(bundle);
                ft.replace(R.id.relative_layout, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
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

    public void removeElement(int position) {
        userList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userMessage;
        TextView messageTime;
        TextView waitingMessage;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            userMessage = (TextView) itemView.findViewById(R.id.user_message);
            messageTime = (TextView) itemView.findViewById(R.id.time_message);
            waitingMessage = (TextView) itemView.findViewById(R.id.waiting_message);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
    }


}