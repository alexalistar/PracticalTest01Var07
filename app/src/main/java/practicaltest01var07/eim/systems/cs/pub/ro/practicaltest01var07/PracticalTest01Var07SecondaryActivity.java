package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private  TextView firstText;
    private TextView secondText;
    private Button okButton;
    private Button cancelButton;

    private class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        firstText = (TextView)findViewById(R.id.first_text);
        secondText = (TextView)findViewById(R.id.second_text);
        okButton = (Button)findViewById(R.id.ok_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("nume")
                && intent.getExtras().containsKey("grupa")) {
            firstText.setText(intent.getStringExtra("nume"));
            secondText.setText(intent.getStringExtra("grupa"));
        }

        MyClick myClick = new MyClick();
        okButton.setOnClickListener(myClick);
        cancelButton.setOnClickListener(myClick);
    }
}
