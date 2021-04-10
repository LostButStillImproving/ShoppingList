package com.lostbutimproving.shoppinglist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lostbutimproving.shoppinglist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static final int ITEM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.buttonAddItem.setOnClickListener(this::launchSecondActivity);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }

    public void searchOnMaps(View view) {
        String location = binding.editSearch.getText().toString();
        if (location.length() == 0) location = "netto";
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else Log.d("MainActivity", "Can't handle this");
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ITEM_REQUEST) {

            if (resultCode == RESULT_OK) {
                String itemName = data.getStringExtra(MainActivity2.ITEM_REPLY);
                String buttonID = data.getStringExtra(MainActivity2.BUTTON_ID);
                Log.d("MainActivity", buttonID);
                updateTextView(itemName, buttonID);
            }
        }

    }

    private void updateTextView(String itemName, String buttonID) {
        switch (buttonID) {
            case "com.lostbutimproving.shoppinglist:id/button1": binding.textView1.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button2": binding.textView2.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button3": binding.textView3.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button4": binding.textView4.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button5": binding.textView5.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button6": binding.textView6.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button7": binding.textView7.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button8": binding.textView8.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button9": binding.textView9.setText(itemName); break;
            case "com.lostbutimproving.shoppinglist:id/button10": binding.textView10.setText(itemName); break;
        }
    }
}