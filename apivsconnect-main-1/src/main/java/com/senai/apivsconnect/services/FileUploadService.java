package com.senai.apivsconnect.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileUploadService {
    private final Path diretorioImg = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img");

    public String FazerUpload(MultipartFile imagem) throws IOException {

        if (imagem.isEmpty()) {
            System.out.println("Imagem vazia");
            return null;
        }

        String nomeOriginal = imagem.getOriginalFilename();
        String[] nomeArquivoArray = nomeOriginal.split("\\.");

        // jpg
        String extensaoArquivo = nomeArquivoArray[nomeArquivoArray.length - 1];

        // 27102023202134
        String prefixoArquivo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));

        String novoNomeImagem = prefixoArquivo + "." + extensaoArquivo;

        File imagemCriada = new File(diretorioImg + "\\" + novoNomeImagem);

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imagemCriada));

        stream.write(imagem.getBytes());
        stream.close();

        return novoNomeImagem;

    }
}
