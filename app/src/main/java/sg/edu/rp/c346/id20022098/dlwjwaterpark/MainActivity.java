package sg.edu.rp.c346.id20022098.dlwjwaterpark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner ticketPicker;
    int price =0;
    EditText NumPax;
    EditText textViewMessage;
    RadioGroup radioGroup;
    String cardType ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticketPicker = findViewById(R.id.ticketPicker);
        NumPax = findViewById(R.id.editTextNumPax);
        String sPax =NumPax.getText().toString();
        int pax =Integer.parseInt(sPax);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.ticket_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ticketPicker.setAdapter(adapter1);

        radioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checkedRadioID =radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(checkedRadioID);
                if(checkedRadioID == R.id.radioButtonVisa){
                    cardType = "Visa";
                }
                if(checkedRadioID == R.id.radioButtonMasterCard){
                    cardType ="MasterCard";
                }
                else{
                    cardType ="NETS";
                }

            }

        });


        if(ticketPicker.toString() == "One-Day ticket [$24]") {
            price = 24 * pax;
        }
        else {
            price += 34 * pax;
        }

        String output ="A notification will be sent to your email "+ "$" + price + " will be credited from your "+ cardType +"card";
        textViewMessage.setText(output);


    }
}