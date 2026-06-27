package com.segurosvidaapi.controller;

import com.segurosvidaapi.model.Segurado;
import com.segurosvidaapi.model.Apolice;
import com.segurosvidaapi.model.BeneficiarioApolice;
import com.segurosvidaapi.model.Sinistro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.segurosvidaapi.repository.SeguradoRepository seguradoRepository;

    @Autowired
    private com.segurosvidaapi.repository.ApoliceRepository apoliceRepository;

    @Autowired
    private com.segurosvidaapi.repository.BeneficiarioApoliceRepository beneficiarioApoliceRepository;

    @Autowired
    private com.segurosvidaapi.repository.SinistroRepository sinistroRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalSegurado", seguradoRepository.count());
        resumo.put("somaRendaMensalSegurado", seguradoRepository.findAll().stream().filter(e -> e.getRendaMensal() != null).mapToDouble(e -> e.getRendaMensal()).sum());
        resumo.put("totalApolice", apoliceRepository.count());
        resumo.put("somaCapitalSeguradoApolice", apoliceRepository.findAll().stream().filter(e -> e.getCapitalSegurado() != null).mapToDouble(e -> e.getCapitalSegurado()).sum());
        resumo.put("graficoApolice", apoliceRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalBeneficiarioApolice", beneficiarioApoliceRepository.count());
        resumo.put("somaPercentualBeneficiarioApolice", beneficiarioApoliceRepository.findAll().stream().filter(e -> e.getPercentual() != null).mapToDouble(e -> e.getPercentual()).sum());
        resumo.put("totalSinistro", sinistroRepository.count());
        resumo.put("somaValorReivindicadoSinistro", sinistroRepository.findAll().stream().filter(e -> e.getValorReivindicado() != null).mapToDouble(e -> e.getValorReivindicado()).sum());
        resumo.put("graficoSinistro", sinistroRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
