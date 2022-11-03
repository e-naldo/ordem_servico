package dev.app.ordemservico.service;

import dev.app.ordemservico.domain.Servico;
import dev.app.ordemservico.dto.ServicoConsultaDto;
import dev.app.ordemservico.exception.RecursoNaoEncontradoException;
import dev.app.ordemservico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findById(Integer id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException());
    }


    public List<Servico> findByFilter(ServicoConsultaDto dto) {
        List<Servico> servicos = servicoRepository.findAllByFilter(
                dto.getId(),
                dto.getNome(),
                dto.getReferencia()
        );
        return servicos;
    }
}
