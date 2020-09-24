package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_ACTIVITY_LOG = "MAIN ACTIVITY LOG";
    private static final String KEY = "helloworld";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onChangeColor(View view) {
        TextView textView = findViewById(R.id.textView);
        TextView output = findViewById(R.id.output);
        EditText message = findViewById(R.id.messageTarget);

        ConstraintLayout layout = findViewById(R.id.layout1);

        int textColor = textView.getCurrentTextColor();
        Drawable layoutBackground = layout.getBackground();
        int layoutColor = ((ColorDrawable) layoutBackground).getColor();

        layout.setBackgroundColor(textColor);
        textView.setTextColor(layoutColor);
        output.setTextColor(layoutColor);
        message.setTextColor(layoutColor);
    }

    public void onClickEncrypt(View view) {
        EditText message = findViewById(R.id.messageTarget);
        TextView output = findViewById(R.id.output);

        String encrypted = VigenereCipher.encrypt(message.getText().toString(), KEY);
        output.setText(encrypted);
    }

    public void onClickDecrypt(View view) {
        EditText message = findViewById(R.id.messageTarget);
        TextView output = findViewById(R.id.output);

        String encrypted = VigenereCipher.decrypt(message.getText().toString(), KEY);
        output.setText(encrypted);
    }
}