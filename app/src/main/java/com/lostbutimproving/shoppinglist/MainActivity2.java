package com.lostbutimproving.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lostbutimproving.shoppinglist.databinding.ActivityMain2Binding;
import com.lostbutimproving.shoppinglist.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    public static final String BUTTON_ID = "buttonID";
    public static final String ITEM_REPLY = "itemName";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        attachOnClick(binding.button1);
        attachOnClick(binding.button2);
        attachOnClick(binding.button3);
        attachOnClick(binding.button4);
        attachOnClick(binding.button5);
        attachOnClick(binding.button6);
        attachOnClick(binding.button7);
        attachOnClick(binding.button8);
        attachOnClick(binding.button9);
        attachOnClick(binding.button10);
        setContentView(view);
    }

    private void attachOnClick(Button button) {
        button.setOnClickListener(v -> addItemAndEndActivity(button));
    }

    private void addItemAndEndActivity(Button button) {
        String itemName = button.getText().toString();
        String id = button.getResources().getResourceName(button.getId());
        Intent intent = new Intent();
        intent.putExtra(BUTTON_ID, id);
        Log.d("MainActivity2", id);
        intent.putExtra(ITEM_REPLY, itemName);
        setResult(RESULT_OK, intent);
        finish();
    }
}