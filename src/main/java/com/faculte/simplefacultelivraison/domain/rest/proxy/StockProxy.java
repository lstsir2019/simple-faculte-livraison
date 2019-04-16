/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.proxy;

import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.StockGlobal;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.StockVo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author gouss
 */
@RibbonClient(name = "microservice-stock")
@FeignClient(name = "microservice-stock")
public interface StockProxy {

    @PutMapping("/stock-api/stocks/stockglobal/strategy/{strategy}")
    public int livraisonStockGlobal(@RequestBody StockGlobal stockGlobal, @PathVariable("strategy") String strategy);

    @PutMapping("stock-api/stocks/")
    public int stockLivraison(@RequestBody StockVo stockVo);
}
