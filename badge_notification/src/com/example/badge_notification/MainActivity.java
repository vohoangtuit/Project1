package com.example.badge_notification;

import shortcutbadger.ShortcutBadger;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {

    private EditText numInput;
	// vohoangtuit
	// add nhompro3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numInput = (EditText) findViewById(R.id.numInput);

        Button button = (Button) findViewById(R.id.btnSetBadge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int badgeCount = 0;
                try {
                    badgeCount = Integer.parseInt(numInput.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Error input", Toast.LENGTH_SHORT).show();
                }

//                    ShortcutBadger.setBadge(getApplicationContext(), badgeCount);
                ShortcutBadger.with(getApplicationContext()).count(badgeCount);
            
           
                Toast.makeText(getApplicationContext(), "Set count=" + badgeCount, Toast.LENGTH_SHORT).show();
            }
        });


        //find the home launcher Package
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        ResolveInfo resolveInfo = getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        String currentHomePackage = resolveInfo.activityInfo.packageName;
// com.example.badge_notification
        TextView textViewHomePackage = (TextView) findViewById(R.id.textViewHomePackage);
        textViewHomePackage.setText("launcher:" + currentHomePackage);
    
        openMain();
    }


    private void openMain(){ // watched notify
    	int badgeCount = 0;
    	 ShortcutBadger.with(getApplicationContext()).count(badgeCount);
    }
}
