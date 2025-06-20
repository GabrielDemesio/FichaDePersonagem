package com.rpg.rpg_ficha.dto.gemini;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Candidate(Content content) {}
