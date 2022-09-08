package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

  @Autowired
  private SaleRepository repository;

  // Estamos retornando todas as vendas! A tipagem do método é do tipo "List" pois
  // o método "findAll()" também é!
  public List<Sale> findSales() {
    return repository.findAll();
  }



}
