package de.mide.toast_demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Demo-App zur Erstellung von "Custom Toasts":
 * Toast-Objekte an bestimmten Bildschirm-Positionen, z.B. "oben" oder "links unten".
 * Auch Toast-Objekte mit eigenem View-Elementen als Inhalt.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity
                          implements OnClickListener {

    /** Tag für Log-Messages der ganzen App. */
    public static final String TAG4LOGGING = "Toast_Demo";


    protected Button _buttonToastLinks         = null;
    protected Button _buttonToastRechts        = null;
    protected Button _buttonToastOben          = null;
    protected Button _buttonToastZentriert     = null;
    protected Button _buttonToastLinksOben     = null;
    protected Button _buttonToastRechtsUnten   = null;
    protected Button _buttonToastCustomLayout1 = null;
    protected Button _buttonToastCustomLayout2 = null;


    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _buttonToastLinks = findViewById(R.id.button_toast_links);
        _buttonToastLinks.setOnClickListener(this);

        _buttonToastRechts = findViewById(R.id.button_toast_rechts);
        _buttonToastRechts.setOnClickListener(this);

        _buttonToastOben = findViewById(R.id.button_toast_oben);
        _buttonToastOben.setOnClickListener(this);

        _buttonToastZentriert = findViewById(R.id.button_toast_zentriert);
        _buttonToastZentriert.setOnClickListener(this);

        _buttonToastLinksOben = findViewById(R.id.button_toast_links_oben);
        _buttonToastLinksOben.setOnClickListener(this);

        _buttonToastRechtsUnten = findViewById(R.id.button_toast_rechts_unten);
        _buttonToastRechtsUnten.setOnClickListener(this);

        _buttonToastCustomLayout1 = findViewById(R.id.button_toast_custom1);
        _buttonToastCustomLayout1.setOnClickListener(this);

        _buttonToastCustomLayout2 = findViewById(R.id.button_toast_custom2);
        _buttonToastCustomLayout2.setOnClickListener(this);
    }


    /**
     * Einzige Methode aus Interface {@link OnClickListener}.
     *
     * @param view Button, der das Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {

        if (view == _buttonToastLinks) {

            toastLinks();

        } else if (view == _buttonToastOben) {

            toastOben();

        } else if (view == _buttonToastRechts) {

            toastRechts();

        } else if (view == _buttonToastZentriert) {

            toastZentriert();

        } else if (view == _buttonToastLinksOben) {

            toastLinksOben();

        } else if (view == _buttonToastRechtsUnten) {

            toastRechtsUnten();

        } else if (view == _buttonToastCustomLayout1) {

            toastMitCustomLayout1();

        } else if (view == _buttonToastCustomLayout2) {

            toastMitCustomLayout2();

        } else {
            Log.w(TAG4LOGGING, "Methode onClick() für unerwartetes View-Objekt aufgerufen: " + view);
        }
    }


    /**
     * Zeigt Toast am linken Bildschirm-Rand.
     */
    protected void toastLinks() {

        Toast toast = Toast.makeText(this, "Toast am linken Rand", Toast.LENGTH_LONG);

        toast.setGravity(Gravity.LEFT, 0, 0);

        toast.show();
    }


    /**
     * Zeigt Toast am oberen Bildschirm-Rand.
     */
    protected void toastOben() {

        Toast toast = Toast.makeText(this, "Toast am oberen Rand", Toast.LENGTH_LONG);

        toast.setGravity(Gravity.TOP, 0, 0);

        toast.show();
    }


    /**
     * Zeigt Toast am rechten Bildschirm-Rand.
     */
    protected void toastRechts() {

        Toast toast = Toast.makeText(this, "Toast am rechten Rand", Toast.LENGTH_LONG);

        toast.setGravity(Gravity.RIGHT, 0, 0);

        toast.show();
    }


    /**
     * Zeigt Toast, der horizontal & vertikal auf dem Bildschirm zentriert ist.
     */
    protected void toastZentriert() {

        Toast toast = Toast.makeText(this, "Zentrierter Toast", Toast.LENGTH_LONG);

        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();
    }


    /**
     * Zeigt Toast, der in der Ecke "links oben" ist.
     */
    protected void toastLinksOben() {

        Toast toast = Toast.makeText(this, "Toast links oben", Toast.LENGTH_LONG);

        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
        // Zwei Gravity-Konstanten mit logischem "Oder" verknüpft

        toast.show();
    }


    /**
     * Zeigt Toast, der in der Ecke "rechts unten" ist.
     */
    protected void toastRechtsUnten() {

        Toast toast = Toast.makeText(this, "Toast rechts unten", Toast.LENGTH_LONG);

        toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        // Zwei Gravity-Konstanten mit logischem "Oder" verknüpft

        toast.show();
    }


    /**
     * Custom Toast-Objekt erzeugen (zwei TextView-Objekte in einem
     * LinearLayout-Objekt, alles programmatisch erzeugt).
     */
    protected void toastMitCustomLayout1() {

        Toast toast = Toast.makeText(this, "Dummy-Text", Toast.LENGTH_LONG);

        // Programmatisch zwei TextView-Objekte erzeugen
        TextView textView1 = new TextView(this);
        textView1.setText("Links");
        textView1.setBackgroundColor(0x80008000);
        textView1.setPadding(15, 15, 15, 15);

        TextView textView2 = new TextView(this);
        textView2.setText("Rechts");
        textView2.setBackgroundColor(0x80800000);
        textView2.setPadding(15, 15, 15, 15);


        // LinearLayout-Objekt programmatisch erzeugen
        LinearLayout linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Die beiden TextView-Elemente programmatisch dem Layout hinzufügen
        LayoutParams layoutParams =
                new LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                                  LinearLayout.LayoutParams.WRAP_CONTENT );

        linLayout.addView(textView1, layoutParams);
        linLayout.addView(textView2, layoutParams);


        // LinearLayout als View des Toasts setzen
        toast.setView(linLayout);

        toast.show();
    }


    /**
     * Erzeugt Toast-Objekt, das ein Layout aus einer Layout-Datei enthält.
     */
    protected void toastMitCustomLayout2() {

        Toast toast = Toast.makeText(this, "Dummy-Text", Toast.LENGTH_LONG);

        // "Inflater" ("Aufblaser") verwenden, um von XML-Layout ein View-Objekt zu bekommen
        View view = getLayoutInflater().inflate(R.layout.toast_layout, null);
        toast.setView(view);

        toast.show();
    }

};
