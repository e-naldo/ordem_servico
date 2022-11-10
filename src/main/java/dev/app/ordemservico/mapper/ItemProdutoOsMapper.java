package dev.app.ordemservico.mapper;

import dev.app.ordemservico.domain.ItemProdutoOs;
import dev.app.ordemservico.dto.ItemProdutoOsDto;
import dev.app.ordemservico.dto.ItemProdutoOsInsertDto;
import dev.app.ordemservico.service.OsService;
import dev.app.ordemservico.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemProdutoOsMapper {

    @Autowired
    private OsService osService;

    @Autowired
    private ProdutoService produtoService;

    public ItemProdutoOs toEntity(ItemProdutoOsDto dto){
        ItemProdutoOs itemProdutoOs = new ItemProdutoOs();
        itemProdutoOs.setProduto(new ProdutoMapper().toEntity(dto.getProduto()));
        //itemProdutoOs.setOs(osService.findById(dto.getOs()));
        itemProdutoOs.setQuantidade(dto.getQuantidade());
        itemProdutoOs.setValorUnitario(dto.getValorUnitario());
        itemProdutoOs.setValorSubtotal(dto.getValorSubtotal());
        itemProdutoOs.setTaxaDesconto(dto.getTaxaDesconto());
        itemProdutoOs.setValorDesconto(dto.getValorDesconto());
        itemProdutoOs.setValorTotal(dto.getValorTotal());

        return itemProdutoOs;
    }

    public ItemProdutoOs toInsertEntity(ItemProdutoOsInsertDto dto){
        ItemProdutoOs itemProdutoOs = new ItemProdutoOs();
        itemProdutoOs.setProduto(produtoService.findById(dto.getProduto()));
        //itemProdutoOs.setOs(osService.findById(dto.getOs()));
        itemProdutoOs.setQuantidade(dto.getQuantidade());
        itemProdutoOs.setValorUnitario(dto.getValorUnitario());
        itemProdutoOs.setValorSubtotal(dto.getValorSubtotal());
        itemProdutoOs.setTaxaDesconto(dto.getTaxaDesconto());
        itemProdutoOs.setValorDesconto(dto.getValorDesconto());
        itemProdutoOs.setValorTotal(dto.getValorTotal());

        return itemProdutoOs;
    }


    public ItemProdutoOsDto toDto(ItemProdutoOs item){
        ItemProdutoOsDto dto = new ItemProdutoOsDto();
        dto.setId(item.getId());
        dto.setProduto(new ProdutoMapper().toDto(item.getProduto()));
        dto.setQuantidade(item.getQuantidade());
        dto.setValorUnitario(item.getValorUnitario());
        dto.setValorSubtotal(item.getValorSubtotal());
        dto.setTaxaDesconto(item.getTaxaDesconto());
        dto.setValorDesconto(item.getValorDesconto());
        dto.setValorTotal(item.getValorTotal());

        return dto;
    }

    public List<ItemProdutoOsDto> toListDto(List<ItemProdutoOs> itemProdutoOs){
       return itemProdutoOs.stream().map(new ItemProdutoOsMapper()::toDto).collect(Collectors.toList());
    }
/*

    public List<ItemProdutoOs> toListEntity(List<ItemProdutoOsInsertDto> dto){
        return dto.stream().map(new ItemProdutoOsMapper()::toEntity).collect(Collectors.toList());
    }
*/

}
