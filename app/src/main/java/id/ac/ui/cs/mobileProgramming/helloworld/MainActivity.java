package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mNumber1;
    EditText mNumber2;
    TextView mOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onAdd(View view) {
        mNumber1 = findViewById(R.id.field1);
        mNumber2 = findViewById(R.id.field2);

        double total = Double.parseDouble(mNumber1.getText().toString()) + Double.parseDouble(mNumber2.getText().toString());

        mOutput = findViewById(R.id.output);
        mOutput.setText(String.valueOf(total));
    }
}