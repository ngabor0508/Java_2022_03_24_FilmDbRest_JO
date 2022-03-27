package hu.nagy_gabor.filmdb;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FilmApi {

    private static final String BASE_URL = "http://localhost:8000";
    private static final String FILM_API_URL = BASE_URL + "/api/film";

    public static List<Film> getFilmek() throws IOException {
        Response response = RequestHandler.get(FILM_API_URL);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if(response.getResponseCode() >= 400){
            System.out.println(json);
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Film>>(){}.getType();
        return jsonConvert.fromJson(json, type);
    }
}
