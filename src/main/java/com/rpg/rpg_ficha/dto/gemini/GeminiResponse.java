package com.rpg.rpg_ficha.dto.gemini;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeminiResponse(List<Candidate> candidates) {
    public String text() {
        if (candidates != null && !candidates.isEmpty()) {
            Candidate firstCandidate = candidates.get(0);
            if (firstCandidate != null && firstCandidate.content() != null && !firstCandidate.content().parts().isEmpty()) {
                return firstCandidate.content().parts().get(0).text();
            }
        }
        return "Não foi possível extrair a história da resposta da IA.";
    }
}