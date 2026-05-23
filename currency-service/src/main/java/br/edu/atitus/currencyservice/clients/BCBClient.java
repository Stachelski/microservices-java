package br.edu.atitus.currencyservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "bcb-client",
        url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata"
)
public interface BCBClient {

    @GetMapping(
            "/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?@dataCotacao='05-22-2026'&$format=json"
    )
    BCBResponse getBCBCurrency(
            @RequestParam("@moeda") String moeda
    );
}