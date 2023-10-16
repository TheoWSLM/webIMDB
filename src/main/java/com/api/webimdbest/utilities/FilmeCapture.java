package com.api.webimdbest.utilities;

import com.api.webimdbest.models.FilmeModel;
import com.api.webimdbest.services.FilmeService;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

@Component
public class FilmeCapture {
      final FilmeService filmeService;

    public FilmeCapture(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void Action() {
        final String URL_GET = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            TodosOsFilmes listaDeFilmes = gson.fromJson(response.body(), TodosOsFilmes.class);

            List<FilmeModel> filmes = listaDeFilmes.getItems();
            for (FilmeModel filme : filmes) {
                var filmeModel = new FilmeModel();
                BeanUtils.copyProperties(filme, filmeModel);
                this.filmeService.saveFilme(filmeModel);
            }

        } else {
            System.out.println("Ocorreu um erro na requisição: " + response.statusCode());
        }
    }
}

class TodosOsFilmes {
    private List<FilmeModel> items;
    private String errorMessage;

    public List<FilmeModel> getItems() {
        return items;
    }
}
