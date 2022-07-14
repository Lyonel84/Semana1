package com.nttdata.BC21.Transaction.webclient;

import com.nttdata.BC21.Transaction.model.responseWC.*;
import com.nttdata.BC21.Transaction.model.responseWC.*;
import reactor.core.publisher.Mono;

public interface IServiceWC {
    Mono<PasProPerCli> findPasProPerCliById(String id);
    Mono<PasProBusCli> findPasProBusCliById(String id);
    Mono<ActProCrePerCli> findActProCrePerCliById(String id);
    Mono<ActProCreCarPerCli> findActProCreCarPerCliById(String id);
    Mono<ActProCreBusCli> findActProCreBusCliById(String id);
    Mono<ActProCreCarBusCli> findActProCreCarBusCliById(String id);

    Mono<PasProPerCli> updatePasProPerCli(PasProPerCli pasProPerCli);
    Mono<PasProBusCli> updatePasProBusCli(PasProBusCli pasProBusCli);
    Mono<ActProCrePerCli> updateActProCrePerCli(ActProCrePerCli actProCrePerCli);
    Mono<ActProCreBusCli> updateActProCreBusCli(ActProCreBusCli actProCreBusCli);
    Mono<ActProCreCarPerCli> updateActProCreCarPerCli(ActProCreCarPerCli actProCreCarPerCli);
    Mono<ActProCreCarBusCli> updateActProCreCarBusCli(ActProCreCarBusCli actProCreCarBusCli);
}
