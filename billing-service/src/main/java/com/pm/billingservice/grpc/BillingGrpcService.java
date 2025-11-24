package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest request, StreamObserver<BillingResponse> responseObserver) {
        log.info("Received Billing Request: {}", request.toString());
        //Build business logic here
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("generated-account-id")
                .setStatus("Account Created Successfully")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
