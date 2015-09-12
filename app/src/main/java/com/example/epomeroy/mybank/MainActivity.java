package com.example.epomeroy.mybank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText amountInput;
    private Button depositButton;
    private Button withdrawButton;
    private TextView balanceDisplay;
    private BankAccount currentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentAccount = new BankAccount(BankAccount.Type.SAVINGS);

        amountInput = (EditText) findViewById(R.id.amount_input);
        depositButton = (Button) findViewById(R.id.deposit_button);
        withdrawButton = (Button) findViewById(R.id.withdrawl_button);
        balanceDisplay = (TextView) findViewById(R.id.balance_display);

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                currentAccount.withdraw(Double.parseDouble(amount));
                balanceDisplay.setText("Balance is " + currentAccount.getBalance());
            }
        });

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                currentAccount.deposit(Double.parseDouble(amount));
                balanceDisplay.setText("Balance is " + currentAccount.getBalance());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
