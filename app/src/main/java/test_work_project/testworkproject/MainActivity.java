package test_work_project.testworkproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbar_name;
    private Button btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        includeToolbar();
        btnChat = (Button) findViewById(R.id.btnChat);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startChatActivity();
            }
        });
    }

    private void startChatActivity() {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    private void includeToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_chat);
        String fontPath = "fonts/RobotoMedium.ttf";
        toolbar_name = (TextView) findViewById(R.id.chat_name);
        Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);
        toolbar_name.setTypeface(typeface);
    }
}
