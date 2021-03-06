package com.example.basiclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * <h2><b>Main Activity:</b></h2> This Activity is a landing page that shows the posts of the associated user that logged in.
 *
 * @author  Alex Espinoza-Fuentes
 */

public class MainActivity extends AppCompatActivity {

    private Bundle bun;
    private TextView textViewResult;
    public static final String ACTIVITY_LABEL = "SECOND_ACTIVITY_COM_EXAMPLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bun = getIntent().getBundleExtra(ACTIVITY_LABEL);
        textViewResult = findViewById(R.id.text_view_result);
        textViewResult.setText("Welcome " + bun.getString("username") + ", Id: " + bun.getString("id") + "\n\n\n");

        /**
         * Retrofit code from video that displays posts of user.
         * Retrieves all posts from API and uses id from intent bundle to match correct posts
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    System.out.println("on response failure");
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for(Post post: posts){
                    String content ="";
                    if(Integer.parseInt(bun.getString("id")) == post.getUserId()){
                        content += "ID: " + post.getId() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Text: " + post.getText() + "\n\n";

                        textViewResult.append(content);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                System.out.println("on failure failure");
                textViewResult.setText(t.getMessage());
            }
        });
    }

    /**
     * Function creates an intent with given context and inserts given bundle.
     * It then returns that intent.
     *
     * @param context
     * @param bun
     * @return Intent
     */
    public static Intent getIntent(Context context, Bundle bun) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.ACTIVITY_LABEL, bun);
        return intent;
    }
}