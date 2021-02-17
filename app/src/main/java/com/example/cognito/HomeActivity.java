package com.example.cognito;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cognito.response.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private static Retrofit retrofit;
    Button logoutButton;
    TextView totalTasks;
    TextView zoneName;
    TextView zoneUserName;
    TextView zocaId;
    SharedPreferences sharedPreferences;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();

        sharedPreferences = getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);

        logoutButton = findViewById(R.id.btnLogout);
        totalTasks = findViewById(R.id.idTvTaskNumber);
        zoneName = findViewById(R.id.idTvZoneName);
        zoneUserName = findViewById(R.id.idTvZoneUserName);
        zocaId = findViewById(R.id.idTvZocaId);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cognito authentication = new Cognito(getApplicationContext());
                authentication.logout();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("token");
                editor.apply();
                Toast.makeText(getApplicationContext(), "Logout Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://oqm4cnt6ta.execute-api.ap-south-1.amazonaws.com/cors/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        Call<List<BaseResponse>> call = apiInterface.getTasks("test@camp-man");

        call.enqueue(new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {
                totalTasks.setText(response.body().get(0).getNum_task().getN());
                zoneName.setText(response.body().get(0).getZone_name().getS());
                zoneUserName.setText(response.body().get(0).getZone_username().getS());
                zocaId.setText(response.body().get(0).getZoca_id().getS());
            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {
                totalTasks.setText(R.string.some_error);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getString("token", null) == null) {
            this.finish();
        }
    }


}