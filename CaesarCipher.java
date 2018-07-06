package com.example.nirvi.myapplication;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CaesarCipher extends Activity {
    EditText ed;
    TextView tv, tv2, tv3;
    Button b, b2;
    String message  =  "",cipher  =  "";
    public static final String alpha   =   "abcdefghijklmnopqrstuvwxyz";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed  =  (EditText)findViewById(R.id.ed);
        tv  =  (TextView)findViewById(R.id.textView);
        tv2  =  (TextView)findViewById(R.id.tv2);
        b  =  (Button)findViewById(R.id.button);
        tv3  =  (TextView)findViewById(R.id.textView2);
        b2  =  (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                message  =  ed.getText().toString();
                encryption(message, 3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                message  =  ed.getText().toString();
                int len  =  message.length();
                len  =  len%13;
                if(tv2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "nothing to decrypt", Toast.LENGTH_SHORT).show();
                else
                decrypt(cipher, len);
            }
        });
    }
    
    public  void encryption(String plainText, int Key_shift)
    {
        plainText   =   plainText.toLowerCase();
        String cipherText   =   "";
        for (int i   =   0; i < plainText.length(); i++)
        {
            int alpha_position   =   alpha.indexOf(plainText.charAt(i));
            int key_val   =   (Key_shift + alpha_position) % 26;
            char replaceVal   =   alpha.charAt(key_val);
            cipherText +  =   replaceVal;
        }
        cipher  =  cipherText;
       tv2.setText(cipherText);
    }
    
    public  void decrypt(String cipherText, int shiftKey)
    {
        cipherText   =   cipherText.toLowerCase();
        String plain_text   =   "";
        for (int i   =   0; i < cipherText.length(); i++)
        {
            int charPosition   =   alpha.indexOf(cipherText.charAt(i));
            int keyVal   =   (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal   =   alpha.length() + keyVal;
            }
            char replaceVal   =   alpha.charAt(keyVal);
            plain_text +  =   replaceVal;
        }
        tv3.setText(plain_text);
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
        int id   =   item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id   =    =   R.id.action_settings) {
            return true;}
        return super.onOptionsItemSelected(item);
    }
}

