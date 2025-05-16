package com.cesar.msotsvalidacionesv1.services;

import com.cesar.msotsvalidacionesv1.models.Seguro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "segurosClient", url = "http://localhost:8080/api/seguros")
public interface SeguroClient {
    @GetMapping("/{id}")
    Seguro getById(@PathVariable Long id);
}
