package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.Os;
import dev.app.ordemservico.dto.OsDto;
import dev.app.ordemservico.dto.OsInsertDto;
import dev.app.ordemservico.service.ClienteService;
import dev.app.ordemservico.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OsMapper {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EquipamentoService equipamentoService;

    public Os toInsertEntity(OsInsertDto dto) {
        Os os = new Os();
        os.setCliente(clienteService.findById(dto.getCliente()));
        os.setEquipamento((equipamentoService.findById(dto.getEquipamento())));
        os.setValorTotal(dto.getValorTotal());
        os.setFormaPagamento(dto.getFormaPagamento());
        os.setObservacao(dto.getObservacao());

       /* os.setProdutos(dto.getProdutos().stream().map(new ItemProdutoOsMapper()::toEntity).collect(Collectors.toSet()));
        os.setServicos(dto.getServicos().stream().map(new ItemServicoOsMapper()::toEntity).collect(Collectors.toSet()));
*/
        return os;

    }

    public OsDto toDto(Os os) {
        OsDto osDto = new OsDto();
        osDto.setId(os.getId());
        osDto.setCliente(new ClienteMapper().toDto(os.getCliente()));
        osDto.setEquipamento(new EquipamentoMapper().toDto(os.getEquipamento()));
        osDto.setValorTotal(os.getValorTotal());
        osDto.setFormaPagamento(os.getFormaPagamento());
        osDto.setObservacao(os.getObservacao());

        osDto.setProdutos(os.getProdutos().stream().map(new ItemProdutoOsMapper()::toDto).collect(Collectors.toSet()));
        osDto.setServicos(os.getServicos().stream().map(new ItemServicoOsMapper()::toDto).collect(Collectors.toSet()));

        return osDto;
    }



}
