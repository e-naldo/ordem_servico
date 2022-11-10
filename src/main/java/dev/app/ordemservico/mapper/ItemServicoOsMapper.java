package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.ItemServicoOs;
import dev.app.ordemservico.dto.ItemServicoOsDto;
import dev.app.ordemservico.dto.ItemServicoOsInsertDto;
import dev.app.ordemservico.service.OsService;
import dev.app.ordemservico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemServicoOsMapper {

    @Autowired
    private OsService osService;

    @Autowired
    private ServicoService servicoService;

    public ItemServicoOs toEntity(ItemServicoOsDto dto){
        ItemServicoOs itemServicoOs = new ItemServicoOs();
        itemServicoOs.setServico(new ServicoMapper().toEntity(dto.getServico()));
        itemServicoOs.setQuantidade(dto.getQuantidade());
        itemServicoOs.setValorUnitario(dto.getValorUnitario());
        itemServicoOs.setValorSubtotal(dto.getValorSubtotal());
        itemServicoOs.setTaxaDesconto(dto.getTaxaDesconto());
        itemServicoOs.setValorDesconto(dto.getValorDesconto());
        itemServicoOs.setValorTotal(dto.getValorTotal());

        return itemServicoOs;
    }

    public ItemServicoOs toInsertEntity(ItemServicoOsInsertDto dto){
        ItemServicoOs itemServicoOs = new ItemServicoOs();
        itemServicoOs.setQuantidade(dto.getQuantidade());
        itemServicoOs.setValorUnitario(dto.getValorUnitario());
        itemServicoOs.setValorSubtotal(dto.getValorSubtotal());
        itemServicoOs.setTaxaDesconto(dto.getTaxaDesconto());
        itemServicoOs.setValorDesconto(dto.getValorDesconto());
        itemServicoOs.setValorTotal(dto.getValorTotal());

        return itemServicoOs;
    }


    public ItemServicoOsDto toDto(ItemServicoOs item){
        ItemServicoOsDto dto = new ItemServicoOsDto();
        dto.setId(item.getId());
        dto.setServico(new ServicoMapper().toDto(item.getServico()));
        dto.setQuantidade(item.getQuantidade());
        dto.setValorUnitario(item.getValorUnitario());
        dto.setValorSubtotal(item.getValorSubtotal());
        dto.setTaxaDesconto(item.getTaxaDesconto());
        dto.setValorDesconto(item.getValorDesconto());
        dto.setValorTotal(item.getValorTotal());

        return dto;
    }

    public List<ItemServicoOsDto> toListDto(List<ItemServicoOs> itemServicoOs){
       return itemServicoOs.stream().map(new ItemServicoOsMapper()::toDto).collect(Collectors.toList());
    }
/*

    public List<ItemServicoOs> toListEntity(List<ItemServicoOsInsertDto> dto){
        return dto.stream().map(new ItemServicoOsMapper()::toEntity).collect(Collectors.toList());
    }
*/

}
