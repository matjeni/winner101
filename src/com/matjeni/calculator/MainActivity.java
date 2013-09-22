package com.matjeni.calculator;


import android.os.Bundle;
import android.app.Activity;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	private EditText etfuel;
	private EditText etdistance;
	private Button btnconsumption;
	private EditText etconsumption;
	private EditText etjourney;
	private Button btnfuelj;
	private EditText etfneeded;
	private EditText etprice;
	private Button btnjprice;
	private EditText ettotal;
	private TextView TXTtotal;
	private double fuel;
	private double fuelC;
	private double need;
	private double needed;
	private String fueltext;
	
	private double PetrolPrice;
	private double GRAND_TOTAL;
	private String PetrolSt;
	private String fuelneed;
	
	private String distancetext;
	private double distance;
	private double con;
	private String wateva;
	private String wat3va;
	private String Total;
	private double Totally;
	private String TAG = "###MAIN";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etfuel = (EditText) findViewById(R.id.etfuel);
		
		etdistance = (EditText) findViewById(R.id.etdistance);
		btnconsumption = (Button) findViewById(R.id.btnconsumption);
		// TXTtotal = (TextView)findViewById(R.id.textView4);
		etconsumption =(EditText)findViewById(R.id.etconsumption);
		etjourney  = (EditText)findViewById(R.id.etjourney);
		btnfuelj = (Button)findViewById(R.id.btnfuelj);
		etfneeded = (EditText)findViewById(R.id.etfneeded);
		etprice = (EditText)findViewById(R.id.etprice);
		ettotal = (EditText)findViewById(R.id.ettotal);
		
		btnjprice = (Button)findViewById(R.id.btnjprice);
		
		btnjprice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

			ClickTotal();	
			}
		});
		
		btnfuelj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
ClickNeeded();
				
			}
		});
		btnconsumption.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ClickAction();

			}
		});
	}

	public void ClickAction() {
		fueltext = etfuel.getText().toString();
	

		 if (fueltext.length() == 0) {
			 etfuel.setError("Fuel in litres is required");

		 } else {
			 fuel = Double.parseDouble(fueltext);
				distancetext = etdistance.getText().toString();
				distance = Double.parseDouble(distancetext);
				
				con = (fuel / distance) * 100;
				Log.i(TAG, "###Consumption ==>" + con + "Litres### " + fueltext);

				wateva = Double.toString(con);
				
				
				etconsumption.setText(wateva);
				// TXTtotal.append("###"+con);
		 }
		
	}
	
	public void ClickNeeded(){
		String fuelConsumption;
		fuelneed = etjourney.getText().toString();
		if (fuelneed.length() == 0) {
			 etjourney.setError("This field is required");

		 } else {
		
		need = Double.parseDouble(fuelneed);
		fuelConsumption = etconsumption.getText().toString();  
		fuelC = Double.parseDouble(fuelConsumption);
		
		needed = (need * fuelC);
		Log.i(TAG, "###FuelNeeded ==>" + need+ "Litres### " + fueltext);
		wateva = Double.toString(need);
		etfneeded.setText(wateva);}
				
	}
	
	public void ClickTotal(){
		
		PetrolSt = etprice.getText().toString();
		if (PetrolSt.length() == 0) {
			 etprice.setError("This field is required");

		 } else {
		PetrolPrice = Double.parseDouble(PetrolSt);
		
		Total = etjourney.getText().toString();
		Totally = Double.parseDouble(Total);
		
		
		
		GRAND_TOTAL = (PetrolPrice * Totally);
		wat3va = Double.toString(GRAND_TOTAL);
		ettotal.setText(wat3va);
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
