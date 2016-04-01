package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private CheckBox firstCheck;
    private EditText firstEdit;
    private CheckBox secondCheck;
    private EditText secondEdit;
    private Button nextButton;

    private static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private class CheckListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.first_check:
                    firstEdit.setEnabled(isChecked);
                    break;
                case R.id.second_check:
                    secondEdit.setEnabled(isChecked);
            }
        }
    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
            String nume = firstEdit.getText().toString();
            String grupa = secondEdit.getText().toString();

            intent.putExtra("nume", nume);
            intent.putExtra("grupa", grupa);
            startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        firstCheck = (CheckBox)findViewById(R.id.first_check);
        secondCheck = (CheckBox)findViewById(R.id.second_check);
        firstEdit = (EditText)findViewById(R.id.first_edit);
        secondEdit = (EditText)findViewById(R.id.second_edit);
        nextButton = (Button)findViewById(R.id.next_button);

        CheckListener checkListener = new CheckListener();
        firstCheck.setOnCheckedChangeListener(checkListener);
        secondCheck.setOnCheckedChangeListener(checkListener);

        ClickListener clickListener = new ClickListener();
        nextButton.setOnClickListener(clickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("firstCheck", firstCheck.isChecked());
        outState.putBoolean("secondCheck", secondCheck.isChecked());
        outState.putString("firstEdit", firstEdit.getText().toString());
        outState.putString("secondEdit", secondEdit.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("firstCheck"))
            firstCheck.setChecked(savedInstanceState.getBoolean("firstCheck"));
        if (savedInstanceState.containsKey("secondCheck"))
            secondCheck.setChecked(savedInstanceState.getBoolean("secondCheck"));
        if (savedInstanceState.containsKey("firstEdit"))
            firstEdit.setText(savedInstanceState.getString("firstEdit"));
        if (savedInstanceState.containsKey("secondEdit"))
            secondEdit.setText(savedInstanceState.getString("secondEdit"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
