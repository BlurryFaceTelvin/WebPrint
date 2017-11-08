package com.example.blurryface.webprint;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class WebPrintActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_print);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myWebView = findViewById(R.id.myWebView);
        myWebView.loadUrl("https://developer.android.com/google/index.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_print, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_print) {
            createWebPrintJob(myWebView);
        }

        return super.onOptionsItemSelected(item);
    }
    public void createWebPrintJob(WebView view){
        PrintManager printManager = (PrintManager)this.getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printDocumentAdapter = view.createPrintDocumentAdapter("MyDocument");
        String jobName =  getString(R.string.app_name)+"PrintTest";
        printManager.print(jobName,printDocumentAdapter,new PrintAttributes.Builder().build());
    }
}
