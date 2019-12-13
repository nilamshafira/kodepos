package com.example.kodepos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class Order extends AppCompatActivity implements View.OnClickListener {
    private Button btnBack;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        EditText alamatField = (EditText) findViewById(R.id.alamat_field);
        Editable alamatEditable = alamatField.getText();
        String alamat = alamatEditable.toString();

        EditText kodeField = (EditText) findViewById(R.id.kode_field);
        Editable kodeEditable = kodeField.getText();
        String kode = kodeEditable.toString();

        EditText jumlahField = (EditText) findViewById(R.id.jumlah_field);
        Editable jumlahEditable = jumlahField.getText();
        String jumlah = jumlahEditable.toString();

        String message = createOrderSummary(name, alamat, kode, jumlah);

        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:nilaamshafiraa@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Create summary of the order.
     *
     * @param name            on the order
     * @param alamat
     * @param kode
     * @param jumlah
     * @return text summary
     */
    private String createOrderSummary(String name, String alamat, String kode,
                                      String jumlah) {
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.order_summary_alamat, alamat);
        priceMessage += "\n" + getString(R.string.order_summary_kode, kode);
        priceMessage += "\n" + getString(R.string.order_summary_jumlah, jumlah);
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */



}