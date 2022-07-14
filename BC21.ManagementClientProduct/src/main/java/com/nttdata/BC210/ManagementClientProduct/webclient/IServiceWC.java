package com.nttdata.BC210.ManagementClientProduct.webclient;

import com.nttdata.BC210.ManagementClientProduct.model.responseWC.ActiveProduct;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.BusinessClient;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.PasiveProduct;
import com.nttdata.BC210.ManagementClientProduct.model.responseWC.PersonClient;
import reactor.core.publisher.Mono;

public interface IServiceWC {
    Mono<PersonClient> findPersonClientById(String id);

    Mono<BusinessClient> findBusinessClientById(String id);

    Mono<PasiveProduct> findPassiveProductById(String id);

    Mono<ActiveProduct> findActiveProductById(String id);
}
