package aguinaga.cs.niu.portfolio15b;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doChange(View view)
    {
        //get the info from
        EditText dataET = findViewById(R.id.dataEditText);
        //only parse string to an integer
        int faveNum = Integer.parseInt(dataET.getText().toString());

        Log.w("MainActivity", "Create the test Task object");

        TestTask tk = new TestTask(this);

        Log.w("MainActivity", "starting testTask");

        tk.execute(faveNum);
    }

    //method to update the screen
    public void updateView(String message)
    {
        TextView messageTv = findViewById(R.id.messageTextView);

        messageTv.setText(message);
    }
}
