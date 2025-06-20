package com.rpg.rpg_ficha.controllers;

import com.rpg.rpg_ficha.dto.GerarHistoriaRequest;
import com.rpg.rpg_ficha.dto.GerarHistoriaResponse;
import com.rpg.rpg_ficha.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    private AiService aiService;

    @PostMapping("/gerar-historia")
    public ResponseEntity<GerarHistoriaResponse> gerarHistoria(@RequestBody GerarHistoriaRequest request) {
        try {
            String historiaGerada = aiService.gerarHistoria(
                    request.nome(),
                    request.raca(),
                    request.classe()
            );
            GerarHistoriaResponse response = new GerarHistoriaResponse(historiaGerada);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}