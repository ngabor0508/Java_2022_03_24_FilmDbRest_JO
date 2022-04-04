package hu.nagy_gabor.filmdb;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TermekApi {

    private static final String BASE_URL = "http://localhost:8000";
    public static final String TERMEK_API_URL = BASE_URL + "/api/termekek";

    public static List<Termek> getTermekek() throws IOException {
        Response response = RequestHandler.get(TERMEK_API_URL);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if(response.getResponseCode() >= 400){
            System.out.println(json);
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Termek>>(){}.getType();
        return jsonConvert.fromJson(json, type);
    }

    public static Termek termekHozzaadasa(Termek ujTermek) throws IOException {
        Gson jsonConvert = new Gson();
        String termekJson = jsonConvert.toJson(ujTermek);
        Response response = RequestHandler.post(TERMEK_API_URL, termekJson);
        String json = response.getContent();
        if(response.getResponseCode() >= 400){
            System.out.println(json);
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json, Termek.class);
    }

    public static Termek termekModositasa(Termek modositando) throws IOException {
        Gson jsonConvert = new Gson();
        String termekJson = jsonConvert.toJson(modositando);
        Response response = RequestHandler.put(TERMEK_API_URL + "/" + modositando.getId(), termekJson);
        String json = response.getContent();
        if(response.getResponseCode() >= 400){
            System.out.println(json);
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json, Termek.class);
    }

    public static boolean termekTorlese(int id) throws IOException {
       Response response = RequestHandler.delete(TERMEK_API_URL + "/" + id);
        Gson jsonConvert = new Gson();
        String json = response.getContent();
        if(response.getResponseCode() >= 400){
            System.out.println(json);
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return response.getResponseCode() == 204;
    }
}
