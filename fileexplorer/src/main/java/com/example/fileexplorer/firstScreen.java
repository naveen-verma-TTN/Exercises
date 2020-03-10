/*  1. Create an app to show list of file & folders in a user’s device.
    2. User can navigate the structure
    3. If a user clicks a file, try to open the file with a relevant app
    4. Save one image file inside app’s private space and one in internal memory
    5. Try sharing the file using share button click
 */
package com.example.fileexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class firstScreen extends AppCompatActivity {

    /**
     * click handler for first screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        findViewById(R.id.fileExplorerOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( firstScreen.this, fileExplorer.class));
            }
        });
        findViewById(R.id.saveInPrivatePublic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( firstScreen.this, InternalExternal.class));
            }
        });
        findViewById(R.id.fileExplorerOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( firstScreen.this, fileExplorer.class));
            }
        });
    }


}
