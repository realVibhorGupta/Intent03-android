package www.vibhorgupta.in.intent003;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // A simple way of ensuring that your log tags are unique
    final static String TAG = MainActivity.class.getSimpleName();

    // Local Variables
    String   textTitle;
    EditText titleTextBox;
    Button buttonToPress;
    Activity currActivity = this;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define my UI elements
        titleTextBox  = (EditText)this.findViewById(R.id.text_box);
        buttonToPress = (Button)this.findViewById(R.id.display_button);

        // Set up my listeners
        buttonToPress.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "Button Pressed!");
                // Put up a toast
                Toast.makeText(currActivity, "You pressed the '" + buttonToPress.getText().toString() + "' button!", Toast.LENGTH_SHORT).show();
                // You don't .show() a Toast, it'll never pop-up...

                // Intent to jump to the next activity
                Intent titleIntent = new Intent(currActivity, TitleActivity.class);

                // Add a bundle to the intent, so that we can actually pass something from activity to activity
                Bundle bundle = new Bundle();
                bundle.putString(TitleActivity.TITLE_ID, titleTextBox.getText().toString());

                titleIntent.putExtras(bundle);

                currActivity.startActivity(titleIntent);
                // We've got it in the manifest, so that we can go to it.
            }

        });
        // This is nice, in that it takes the data from the first activity and then sends it to the second activity, but the user
        // really shouldn't be able to hit the button unless there's text in the EditText element.
    }
}