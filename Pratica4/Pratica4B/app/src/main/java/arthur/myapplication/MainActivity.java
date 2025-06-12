package arthur.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_LIGHT_VALUE = "LIGHT_VALUE";
    public static final String EXTRA_PROXIMITY_VALUE = "PROXIMITY_VALUE";
    public static final String EXTRA_LIGHT_CLASSIFICATION = "LIGHT_CLASSIFICATION";
    public static final String EXTRA_PROXIMITY_CLASSIFICATION = "PROXIMITY_CLASSIFICATION";

    private float lightValue = 0.0f;
    private float proximityValue = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.txtView);
        Button btnClassify = findViewById(R.id.btnClas);
        btnClassify.setText("Devolver Classificações");

        Intent receivedIntent = getIntent();
        if (receivedIntent != null) {

            lightValue = receivedIntent.getFloatExtra(EXTRA_LIGHT_VALUE, 0.0f);
            proximityValue = receivedIntent.getFloatExtra(EXTRA_PROXIMITY_VALUE, 0.0f);

            String readings = String.format("Valores Recebidos:\n\nLuminosidade: %.2f lx\nProximidade: %.2f cm", lightValue, proximityValue);
            txtView.setText(readings);
        }


        btnClassify.setOnClickListener(v -> {
            Intent resultIntent = new Intent();

            if (lightValue < 20.0f) {
                resultIntent.putExtra(EXTRA_LIGHT_CLASSIFICATION, "baixa");
            } else {
                resultIntent.putExtra(EXTRA_LIGHT_CLASSIFICATION, "alta");
            }

            if (proximityValue > 3.0f) {
                resultIntent.putExtra(EXTRA_PROXIMITY_CLASSIFICATION, "distante");
            } else {
                resultIntent.putExtra(EXTRA_PROXIMITY_CLASSIFICATION, "proximo");
            }

            setResult(Activity.RESULT_OK, resultIntent);

            finish();
        });
    }
}