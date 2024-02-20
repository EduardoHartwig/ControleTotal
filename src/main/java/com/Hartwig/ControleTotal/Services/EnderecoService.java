package com.Hartwig.ControleTotal.Services;

import com.Hartwig.ControleTotal.Models.Endereco;
import com.Hartwig.ControleTotal.Repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco cadastrarEndereco(Endereco endereco) throws IOException {
        Endereco end = null;

        end = this.buscarEnderecoPorViaCEP(endereco.getCep());
        end.setComplemento(endereco.getComplemento());
        end.setNumero(endereco.getNumero());

        enderecoRepository.save(end);
        return end;
    }


    public Endereco buscarEnderecoPorViaCEP(String cep) throws IOException {
        Endereco end = null;
        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();
                end = gson.fromJson(result, Endereco.class);
            }
        }
        return end;
    }

}
