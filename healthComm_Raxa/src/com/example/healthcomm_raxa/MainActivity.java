package com.example.healthcomm_raxa;

// bluetooth implementation using filetransfer
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity{
	Button fileconnection;
	// @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	//void your method(){
	// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
	// } else } } 
	// Doesn't work 
	SearchView searchFiles;
	BluetoothAdapter test_btAdapter;
	
	
	private static final int DISCOVER_DURATION = 300;
	private static final int REQUEST_BLU = 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		if (test_btAdapter == null){
			//figure out a message
			Toast.makeText(getApplicationContext(), "No bluetooth detected", 0).show();
			finish();
		}
		else{
			enableBlu();
				
			}
				
	}


	// some inside method maybe for the test_btAdapter
	private void init() {
			// TODO Auto-generated method stub
			fileconnection = (Button)findViewById(R.id.fileTransbutton);
			searchFiles = (SearchView)findViewById(R.id.searchView);
			test_btAdapter = BluetoothAdapter.getDefaultAdapter();
		}
	
	
	public void enableBlu(){
	// enable bluetooth - done automatically using action_request_discoverable
	Intent discoveryIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
	discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, DISCOVER_DURATION);
	startActivityForResult(discoveryIntent,REQUEST_BLU);
	}
}


	//Intent bt_intent = new Intent();
	// bt_intent.setAction(Intent.ACTION_SEND);



