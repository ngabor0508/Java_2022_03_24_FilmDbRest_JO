package hu.nagy_gabor.filmdb;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FilmApi {

    public static List<Film> getFilmek() throws IOException {
        Response response = RequestHandler.get("http://localhost:8000/api/film/35");
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if(response.getResponseCode() >= 400){
            System.out.println(json);
            String message = jsonConvert.fromJson(json, String.class);
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Film>>(){}.getType();
        List<Film> filmList = jsonConvert.fromJson(json, type);
        return filmList;
    }
}
