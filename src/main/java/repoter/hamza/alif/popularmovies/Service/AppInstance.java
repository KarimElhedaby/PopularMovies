package repoter.hamza.alif.popularmovies.Service;

import android.app.Application;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karim pc on 9/14/2017.
 */

public class AppInstance  extends Application {

    public static ApiServiceInterface apiServiceInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient
                .Builder().addInterceptor(httpLoggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.Base_URL_MOVIE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        apiServiceInterface = retrofit.create(ApiServiceInterface.class);

    }
}

